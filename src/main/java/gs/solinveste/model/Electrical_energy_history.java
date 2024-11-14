package gs.solinveste.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "TB_HISTORICO_ENERGIA_ELETRICA_GE")
public class Electrical_energy_history {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JoinColumn(name = "ID_ENDERECO")
    @OneToOne
    private Address addressHistory;
    
    @Column(name = "CONSUMO")
    private double consumption;

    @Column(name = "UNIDADE_MEDIDA")
    private String measurementUnit;

    @Column(name = "DATA_REGISTRO")
    private LocalDate registryDate;

    @Column(name = "CUSTO")
    private double cost;

    public Electrical_energy_history() {
    }

    public Electrical_energy_history(Integer id, Address addressHistory, double consumption, String measurementUnit, LocalDate registryDate, double cost) {
        this.id = id;
        this.addressHistory = addressHistory;
        this.consumption = consumption;
        this.measurementUnit = measurementUnit;
        this.registryDate = registryDate;
        this.cost = cost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Address getAddressHistory() {
        return addressHistory;
    }

    public void setAddressHistory(Address addressHistory) {
        this.addressHistory = addressHistory;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public LocalDate getRegistryDate() {
        return registryDate;
    }

    public void setRegistryDate(LocalDate registryDate) {
        this.registryDate = registryDate;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
