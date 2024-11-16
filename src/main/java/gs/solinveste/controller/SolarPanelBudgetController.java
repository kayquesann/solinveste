package gs.solinveste.controller;

import gs.solinveste.dto.SolarPanelBudgetDTO;
import gs.solinveste.service.SolarPanelBudgetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/budget")
public class SolarPanelBudgetController {

    @Autowired
    private SolarPanelBudgetService solarPanelBudgetService;

    @GetMapping("{addressId}")
    public ResponseEntity<Set<SolarPanelBudgetDTO>> readSolarPanelBudgetByAddress (@PathVariable Integer addressId) {
        return ResponseEntity.ok(solarPanelBudgetService.readSolarPanelBudgetByAddress(addressId));
    }

    @GetMapping
    public ResponseEntity<List<SolarPanelBudgetDTO>> readAllSolarPanelBudgets () {
        return ResponseEntity.ok(solarPanelBudgetService.readAllSolarPanelBudgets());
    }

    @PostMapping
    public ResponseEntity<SolarPanelBudgetDTO> saveSolarPanelBudget (@RequestBody @Valid SolarPanelBudgetDTO solarPanelBudgetDTO) {
        return ResponseEntity.ok(solarPanelBudgetService.saveSolarPanelBudget(solarPanelBudgetDTO));
    }
}
