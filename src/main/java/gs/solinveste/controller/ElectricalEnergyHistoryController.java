package gs.solinveste.controller;

import gs.solinveste.dto.ElectricalEnergyHistoryDTO;
import gs.solinveste.model.ElectricalEnergyHistory;
import gs.solinveste.service.ElectricalEnergyHistoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/EnergyHistory")
public class ElectricalEnergyHistoryController {

    @Autowired
    private ElectricalEnergyHistoryService electricalEnergyHistoryService;

    @GetMapping("{addressId}")
    public ResponseEntity<Set<ElectricalEnergyHistoryDTO>> readElectricalEnergyHistory (@PathVariable Integer addressId) {
        return ResponseEntity.ok(electricalEnergyHistoryService.readElectricalEnergyHistoryByAddressId(addressId));
    }

    @GetMapping
    public ResponseEntity<List<ElectricalEnergyHistoryDTO>> readAllElectricalEnergyHistory () {
        return ResponseEntity.ok(electricalEnergyHistoryService.readAllElectricalEnergyHistory());
    }

    @PostMapping
    public ResponseEntity<ElectricalEnergyHistoryDTO> saveElectricalEnergyHistory (@RequestBody @Valid ElectricalEnergyHistoryDTO electricalEnergyHistoryDTO) {
        return ResponseEntity.ok(electricalEnergyHistoryService.saveElectricalEnergyHistory(electricalEnergyHistoryDTO));
    }



}
