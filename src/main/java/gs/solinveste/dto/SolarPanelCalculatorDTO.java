package gs.solinveste.dto;

public class SolarPanelCalculatorDTO {

    private double monthlyConsumption;  // In kWh
    private double energyCost; // Cost per kWh

    public SolarPanelCalculatorDTO() {
    }

    public SolarPanelCalculatorDTO(double monthlyConsumption, double energyCost) {
        this.monthlyConsumption = monthlyConsumption;
        this.energyCost = energyCost;
    }

    public double getMonthlyConsumption() {
        return monthlyConsumption;
    }

    public void setMonthlyConsumption(double monthlyConsumption) {
        this.monthlyConsumption = monthlyConsumption;
    }

    public double getEnergyCost() {
        return energyCost;
    }

    public void setEnergyCost(double energyCost) {
        this.energyCost = energyCost;
    }
}
