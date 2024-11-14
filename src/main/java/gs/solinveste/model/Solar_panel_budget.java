package gs.solinveste.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ORCAMENTO_PAINEL_SOLAR_GE")
public class Solar_panel_budget {

    private Integer id;
    private Adress adress;
    private double investmentCost;
    private double systemSize;
    private int modulesNumber;
    private double estimatedAnnualProduction;

    public Solar_panel_budget() {
    }

    public Solar_panel_budget(Integer id, Adress adress, double investmentCost, double systemSize, int modulesNumber, double estimatedAnnualProduction) {
        this.id = id;
        this.adress = adress;
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

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public double getInvestmentCost() {
        return investmentCost;
    }

    public void setInvestmentCost(double investmentCost) {
        this.investmentCost = investmentCost;
    }

    public double getSystemSize() {
        return systemSize;
    }

    public void setSystemSize(double systemSize) {
        this.systemSize = systemSize;
    }

    public int getModulesNumber() {
        return modulesNumber;
    }

    public void setModulesNumber(int modulesNumber) {
        this.modulesNumber = modulesNumber;
    }

    public double getEstimatedAnnualProduction() {
        return estimatedAnnualProduction;
    }

    public void setEstimatedAnnualProduction(double estimatedAnnualProduction) {
        this.estimatedAnnualProduction = estimatedAnnualProduction;
    }
}
