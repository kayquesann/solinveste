package gs.solinveste.service;

import gs.solinveste.dto.ElectricalEnergyHistoryDTO;
import gs.solinveste.dto.SolarPanelBudgetDTO;
import gs.solinveste.model.Address;
import gs.solinveste.model.ElectricalEnergyHistory;
import gs.solinveste.model.SolarPanelBudget;
import gs.solinveste.repository.AddressRepository;
import gs.solinveste.repository.SolarPanelBudgetRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SolarPanelBudgetService {

    @Autowired
    private final SolarPanelBudgetRepository solarPanelBudgetRepository;

    @Autowired
    private final AddressRepository addressRepository;

    public SolarPanelBudgetService(SolarPanelBudgetRepository solarPanelBudgetRepository, AddressRepository addressRepository) {
        this.solarPanelBudgetRepository = solarPanelBudgetRepository;
        this.addressRepository = addressRepository;
    }

    private Address findAddressById(Integer addressId) {
        Optional<Address> address = addressRepository.findById(addressId);
        if (address.isEmpty()) {
            throw new EntityNotFoundException("Endereço não encontrado");
        }
        return address.get();
    }

    public SolarPanelBudgetDTO convertToDTO (SolarPanelBudget solarPanelBudget) {
        SolarPanelBudgetDTO solarPanelBudgetDTO = new SolarPanelBudgetDTO();
        solarPanelBudgetDTO.setId(solarPanelBudget.getId());
        solarPanelBudgetDTO.setAddressBudgetId(solarPanelBudget.getAddressBudget().getId());
        solarPanelBudgetDTO.setInvestmentCost(solarPanelBudget.getInvestmentCost());
        solarPanelBudgetDTO.setSystemSize(solarPanelBudget.getSystemSize());
        solarPanelBudgetDTO.setModulesNumber(solarPanelBudget.getModulesNumber());
        solarPanelBudgetDTO.setEstimatedAnnualProduction(solarPanelBudget.getEstimatedAnnualProduction());
        return solarPanelBudgetDTO;
    }

    public SolarPanelBudget convertToEntity (SolarPanelBudgetDTO solarPanelBudgetDTO) {
        SolarPanelBudget solarPanelBudget = new SolarPanelBudget();
        solarPanelBudget.setSystemSize(solarPanelBudgetDTO.getSystemSize());
        solarPanelBudget.setModulesNumber(solarPanelBudgetDTO.getModulesNumber());
        solarPanelBudget.setInvestmentCost(solarPanelBudgetDTO.getInvestmentCost());
        solarPanelBudget.setEstimatedAnnualProduction(solarPanelBudgetDTO.getEstimatedAnnualProduction());
        return solarPanelBudget;
    }

    public Set<SolarPanelBudgetDTO> readSolarPanelBudgetByAddress (Integer addressId) {
        Address existingAddress = findAddressById(addressId);
        Set<SolarPanelBudget> solarPanelBudgets = existingAddress.getBudgets();

        return solarPanelBudgets.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toSet());
    }

    public List<SolarPanelBudgetDTO> readAllSolarPanelBudgets () {
        List<SolarPanelBudget> budget = solarPanelBudgetRepository.findAll();
        return budget.stream().map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public SolarPanelBudgetDTO saveSolarPanelBudget (SolarPanelBudgetDTO solarPanelBudgetDTO) {
        Address existingAddress = findAddressById(solarPanelBudgetDTO.getAddressBudgetId());
        SolarPanelBudget solarPanelBudget = convertToEntity(solarPanelBudgetDTO);
        solarPanelBudget.setAddressBudget(existingAddress);
        SolarPanelBudget savedSolarPanelBudget = solarPanelBudgetRepository.save(solarPanelBudget);
        return convertToDTO(savedSolarPanelBudget);
    }


}
