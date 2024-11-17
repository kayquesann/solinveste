package gs.solinveste.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "TB_ORCAMENTO_PAINEL_SOLAR_GE")
public class SolarPanelBudget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "ID_ENDERECO")
    @OneToOne
    private Address addressBudget;

    @Column(name = "CUSTO_INVESTIMENTO")
    private double investmentCost;

    @Column(name = "TAMANHO_SISTEMA")
    private double systemSize;

    @Column(name = "NUMERO_MODULOS")
    private int modulesNumber;

    @Column(name = "PRODUCAO_ANUAL_ESTIMADA")
    private double estimatedAnnualProduction;

    public SolarPanelBudget() {
    }

    public SolarPanelBudget(Integer id, Address addressBudget, double investmentCost, double systemSize, int modulesNumber, double estimatedAnnualProduction) {
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
