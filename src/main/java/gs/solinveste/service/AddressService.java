package gs.solinveste.service;

import gs.solinveste.dto.AddressDTO;
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

    public AddressDTO convertToReadAddressDTO (Address address) {
        AddressDTO readAddressDTO = new AddressDTO();
        readAddressDTO.setId(address.getId());
        readAddressDTO.setStreet(address.getStreet());
        readAddressDTO.setNeighborhood(address.getNeighborhood());
        readAddressDTO.setCEP(address.getCEP());
        readAddressDTO.setHouseNumber(address.getHouseNumber());
        readAddressDTO.setCity(address.getCity());
        return readAddressDTO;
    }

    public SaveAddressDTO convertToSaveAddressDTO (Address address) {
        SaveAddressDTO saveAddressDTO = new SaveAddressDTO();
        saveAddressDTO.setId(address.getId());
        saveAddressDTO.setUser(address.getUser());
        saveAddressDTO.setStreet(address.getStreet());
        saveAddressDTO.setNeighborhood(address.getNeighborhood());
        saveAddressDTO.setCEP(address.getCEP());
        saveAddressDTO.setHouseNumber(address.getHouseNumber());
        saveAddressDTO.setCity(address.getCity());
        return saveAddressDTO;
    }

    public Address convertToEntity(SaveAddressDTO saveAddressDTO) {
        Address address = new Address();
        address.setUser(saveAddressDTO.getUser());
        address.setStreet(saveAddressDTO.getStreet());
        address.setNeighborhood(saveAddressDTO.getNeighborhood());
        address.setCEP(saveAddressDTO.getCEP());
        address.setHouseNumber(saveAddressDTO.getHouseNumber());
        address.setCity(saveAddressDTO.getCity());
        return address;
    }


    public Set<AddressDTO> readAddressByUser (Integer userId) {
        Optional<User> user  = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new EntityNotFoundException("Usuário não encontrado");
        }
        User existingUser = user.get();
        Set<Address> addresses = existingUser.getAddresses();
        return addresses.stream()
                .map(this::convertToReadAddressDTO).
                collect(Collectors.toSet());
    }

    public SaveAddressDTO saveAddress (SaveAddressDTO saveAddressDTO) {
        Address address = convertToEntity(saveAddressDTO);
        Address savedAddress = addressRepository.save(address);
        return convertToSaveAddressDTO(savedAddress);
    }

    public List<AddressDTO> readAllAddresses () {
        List<Address> addresses = addressRepository.findAll();
        return addresses.stream().map(this::convertToReadAddressDTO).collect(Collectors.toList());
    }

}
