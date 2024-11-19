package gs.solinveste.dto;

import gs.solinveste.model.Address;
import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;

public class SolarPanelBudgetDTO {

    private Integer id;

    private Integer addressBudgetId;

    private double investmentCost;

    @PositiveOrZero
    private double systemSize;

    @PositiveOrZero
    private int modulesNumber;

    @PositiveOrZero
    private double estimatedAnnualProduction;

    public SolarPanelBudgetDTO() {
    }

    public SolarPanelBudgetDTO(Integer id, Integer addressBudgetId, double investmentCost, double systemSize, int modulesNumber, double estimatedAnnualProduction) {
        this.id = id;
        this.addressBudgetId = addressBudgetId;
        this.investmentCost = investmentCost;
        this.systemSize = systemSize;
        this.modulesNumber = modulesNumber;
        this.estimatedAnnualProduction = estimatedAnnualProduction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAddressBudgetId() {
        return addressBudgetId;
    }

    public void setAddressBudgetId(Integer addressBudgetId) {
        this.addressBudgetId = addressBudgetId;
    }

    public double getInvestmentCost() {
        return investmentCost;
    }

    public void setInvestmentCost(double investmentCost) {
        this.investmentCost = investmentCost;
    }

    @PositiveOrZero
    public double getSystemSize() {
        return systemSize;
    }

    public void setSystemSize(@PositiveOrZero double systemSize) {
        this.systemSize = systemSize;
    }

    @PositiveOrZero
    public int getModulesNumber() {
        return modulesNumber;
    }

    public void setModulesNumber(@PositiveOrZero int modulesNumber) {
        this.modulesNumber = modulesNumber;
    }

    @PositiveOrZero
    public double getEstimatedAnnualProduction() {
        return estimatedAnnualProduction;
    }

    public void setEstimatedAnnualProduction(@PositiveOrZero double estimatedAnnualProduction) {
        this.estimatedAnnualProduction = estimatedAnnualProduction;
    }
}
