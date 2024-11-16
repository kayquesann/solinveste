package gs.solinveste.service;

import gs.solinveste.dto.ElectricalEnergyHistoryDTO;
import gs.solinveste.model.Address;
import gs.solinveste.model.ElectricalEnergyHistory;
import gs.solinveste.repository.AddressRepository;
import gs.solinveste.repository.ElectricalEnergyHistoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ElectricalEnergyHistoryService {

    @Autowired
    private final ElectricalEnergyHistoryRepository electricalEnergyHistoryRepository;

    @Autowired
    private final AddressRepository addressRepository;

    public ElectricalEnergyHistoryService(ElectricalEnergyHistoryRepository electricalEnergyHistoryRepository, AddressRepository addressRepository) {
        this.electricalEnergyHistoryRepository = electricalEnergyHistoryRepository;
        this.addressRepository = addressRepository;
    }

    public ElectricalEnergyHistoryDTO convertToDTO (ElectricalEnergyHistory electricalEnergyHistory) {
        ElectricalEnergyHistoryDTO electricalEnergyHistoryDTO = new ElectricalEnergyHistoryDTO();
        electricalEnergyHistoryDTO.setId(electricalEnergyHistory.getId());
        electricalEnergyHistoryDTO.setAddressHistory(electricalEnergyHistory.getAddressHistory());
        electricalEnergyHistoryDTO.setConsumption(electricalEnergyHistory.getConsumption());
        electricalEnergyHistoryDTO.setCost(electricalEnergyHistory.getCost());
        electricalEnergyHistoryDTO.setRegistryDate(electricalEnergyHistory.getRegistryDate());
        electricalEnergyHistoryDTO.setMeasurementUnit(electricalEnergyHistory.getMeasurementUnit());
        return electricalEnergyHistoryDTO;
    }

    public ElectricalEnergyHistory convertToEntity (ElectricalEnergyHistoryDTO electricalEnergyHistoryDTO) {
        ElectricalEnergyHistory electricalEnergyHistory = new ElectricalEnergyHistory();
        electricalEnergyHistory.setConsumption(electricalEnergyHistoryDTO.getConsumption());
        electricalEnergyHistory.setCost(electricalEnergyHistoryDTO.getCost());
        electricalEnergyHistory.setRegistryDate(electricalEnergyHistoryDTO.getRegistryDate());
        electricalEnergyHistory.setAddressHistory(electricalEnergyHistoryDTO.getAddressHistory());
        electricalEnergyHistory.setMeasurementUnit(electricalEnergyHistoryDTO.getMeasurementUnit());
        return electricalEnergyHistory;
    }

    public Set<ElectricalEnergyHistoryDTO> readElectricalEnergyHistoryByAddressId (Integer addressId) {
        Optional<Address> address = addressRepository.findById(addressId);
        if (address.isEmpty()) {
            throw new EntityNotFoundException("Endereço não encontrado");
        }
        Address existingAddress = address.get();
        Set<ElectricalEnergyHistory> electricalEnergyHistory = existingAddress.getHistory();

        return electricalEnergyHistory.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toSet());
    }

    public List<ElectricalEnergyHistoryDTO> readAllElectricalEnergyHistory () {
        List<ElectricalEnergyHistory> history = electricalEnergyHistoryRepository.findAll();
        return history.stream().map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ElectricalEnergyHistoryDTO saveElectricalEnergyHistory (ElectricalEnergyHistoryDTO electricalEnergyHistoryDTO) {
        ElectricalEnergyHistory electricalEnergyHistory = convertToEntity(electricalEnergyHistoryDTO);
        ElectricalEnergyHistory savedElectricalEnergyHistory = electricalEnergyHistoryRepository.save(electricalEnergyHistory);
        return convertToDTO(savedElectricalEnergyHistory);
    }
}
