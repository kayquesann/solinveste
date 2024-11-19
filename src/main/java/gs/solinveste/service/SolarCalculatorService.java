package gs.solinveste.service;

import org.springframework.stereotype.Service;

@Service
public class SolarCalculatorService {

    public double calculateNumberOfPanels (double monthlyConsumption, double panelPower) {
        return Math.ceil(monthlyConsumption / panelPower);
    }

    public double calculateTotalInvestmentCost (double numberOfPanels, double panelCost) {
        return numberOfPanels * panelCost;
    }

    public double calculatePaybackPeriod (double totalCost, double monthlySavings) {
        return totalCost / monthlySavings;
    }
}
