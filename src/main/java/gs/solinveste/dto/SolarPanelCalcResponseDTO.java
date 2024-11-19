package gs.solinveste.dto;

public class SolarPanelCalcResponseDTO {

    private double numberOfPanels;
    private double totalInvestmentCost;
    private double monthlySavings;
    private String paybackPeriod;

    public SolarPanelCalcResponseDTO() {
    }

    public SolarPanelCalcResponseDTO(double numberOfPanels, double totalInvestmentCost, double monthlySavings, String paybackPeriod) {
        this.numberOfPanels = numberOfPanels;
        this.totalInvestmentCost = totalInvestmentCost;
        this.monthlySavings = monthlySavings;
        this.paybackPeriod = paybackPeriod;
    }

    public double getNumberOfPanels() {
        return numberOfPanels;
    }

    public void setNumberOfPanels(double numberOfPanels) {
        this.numberOfPanels = numberOfPanels;
    }

    public double getTotalInvestmentCost() {
        return totalInvestmentCost;
    }

    public void setTotalInvestmentCost(double totalInvestmentCost) {
        this.totalInvestmentCost = totalInvestmentCost;
    }

    public double getMonthlySavings() {
        return monthlySavings;
    }

    public void setMonthlySavings(double monthlySavings) {
        this.monthlySavings = monthlySavings;
    }

    public String getPaybackPeriod() {
        return paybackPeriod;
    }

    public void setPaybackPeriod(String paybackPeriod) {
        this.paybackPeriod = paybackPeriod;
    }
}
