package gs.solinveste.service;

import gs.solinveste.dto.SaveAddressDTO;
import gs.solinveste.model.Address;
import gs.solinveste.model.User;
import gs.solinveste.repository.AddressRepository;
import gs.solinveste.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AddressService {

    @Autowired
    private final AddressRepository addressRepository;

    @Autowired
    private final UserRepository userRepository;

    public AddressService(AddressRepository addressRepository, UserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    public SaveAddressDTO convertToSaveAddressDTO (Address address) {
        SaveAddressDTO saveAddressDTO = new SaveAddressDTO();
        saveAddressDTO.setId(address.getId());
        saveAddressDTO.setUserId(address.getUser().getId());
        saveAddressDTO.setStreet(address.getStreet());
        saveAddressDTO.setNeighborhood(address.getNeighborhood());
        saveAddressDTO.setCep(address.getCEP());
        saveAddressDTO.setHouseNumber(address.getHouseNumber());
        saveAddressDTO.setCity(address.getCity());
        saveAddressDTO.setLocalType(address.getLocalType());
        return saveAddressDTO;
    }

    public Address convertToEntity(SaveAddressDTO saveAddressDTO) {
        Address address = new Address();
        address.setStreet(saveAddressDTO.getStreet());
        address.setNeighborhood(saveAddressDTO.getNeighborhood());
        address.setCEP(saveAddressDTO.getCep());
        address.setHouseNumber(saveAddressDTO.getHouseNumber());
        address.setCity(saveAddressDTO.getCity());
        address.setLocalType(saveAddressDTO.getLocalType());
        return address;
    }


    public Set<SaveAddressDTO> readAddressByUser (Integer userId) {
        Optional<User> user  = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new EntityNotFoundException("Usuário não encontrado");
        }
        User existingUser = user.get();
        Set<Address> addresses = existingUser.getAddresses();
        return addresses.stream()
                .map(this::convertToSaveAddressDTO).
                collect(Collectors.toSet());
    }

    public SaveAddressDTO saveAddress (SaveAddressDTO saveAddressDTO) {
        Optional<User> user = userRepository.findById(saveAddressDTO.getUserId());
        if (user.isEmpty()) {
            throw new EntityNotFoundException("Usuário não encontrado");
        }
        User existingUser = user.get();
        Address address = convertToEntity(saveAddressDTO);
        address.setUser(existingUser);
        Address savedAddress = addressRepository.save(address);
        return convertToSaveAddressDTO(savedAddress);
    }

    public List<SaveAddressDTO> readAllAddresses () {
        List<Address> addresses = addressRepository.findAll();
        return addresses.stream().map(this::convertToSaveAddressDTO).collect(Collectors.toList());
    }

}
