package gs.solinveste.dto;

import gs.solinveste.model.Address;
import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;

public class SolarPanelBudgetDTO {

    private Integer id;

    private Address addressBudget;

    private double investmentCost;

    @PositiveOrZero
    private double systemSize;

    @PositiveOrZero
    private int modulesNumber;

    @PositiveOrZero
    private double estimatedAnnualProduction;

    public SolarPanelBudgetDTO() {
    }

    public SolarPanelBudgetDTO(Integer id, Address addressBudget, double investmentCost, double systemSize, int modulesNumber, double estimatedAnnualProduction) {
        this.id = id;
        this.addressBudget = addressBudget;
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

    public Address getAddressBudget() {
        return addressBudget;
    }

    public void setAddressBudget(Address addressBudget) {
        this.addressBudget = addressBudget;
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
