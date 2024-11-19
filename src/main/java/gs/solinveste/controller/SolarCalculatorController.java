package gs.solinveste.controller;

import gs.solinveste.dto.SolarPanelCalcResponseDTO;
import gs.solinveste.dto.SolarPanelCalculatorDTO;
import gs.solinveste.service.SolarCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/solar")
public class SolarCalculatorController {

    @Autowired
    private SolarCalculatorService service;

    @GetMapping("/calculate")
    public ResponseEntity<SolarPanelCalcResponseDTO> calculateInvestment (@RequestBody SolarPanelCalculatorDTO solarPanelCalculator) {

        double numberOfPanels = service.calculateNumberOfPanels(solarPanelCalculator.getMonthlyConsumption(), 40);
        double totalInvestmentCost = service.calculateTotalInvestmentCost(numberOfPanels, 1500);
        double monthlySavings = solarPanelCalculator.getMonthlyConsumption() * solarPanelCalculator.getEnergyCost();
        double paybackPeriod = service.calculatePaybackPeriod(totalInvestmentCost, monthlySavings);

        int years = (int) paybackPeriod / 12;
        int months = (int) paybackPeriod % 12;

        SolarPanelCalcResponseDTO solarPanelCalcResponseDTO = new SolarPanelCalcResponseDTO();

        solarPanelCalcResponseDTO.setNumberOfPanels(numberOfPanels);
        solarPanelCalcResponseDTO.setMonthlySavings(monthlySavings);
        solarPanelCalcResponseDTO.setTotalInvestmentCost(totalInvestmentCost);
        solarPanelCalcResponseDTO.setPaybackPeriod(String.format("%d anos e %d meses",years,months));

        return ResponseEntity.ok(solarPanelCalcResponseDTO);
    }

}
