package gs.solinveste.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "TB_HISTORICO_ENERGIA_ELETRICA_GE")
public class Electrical_energy_history {

    private Integer id;
    private Adress adress;
    private double consumption;
    private String measurementUnit;
    private LocalDate registryDate;
    private double cost;

    public Electrical_energy_history() {
    }

    public Electrical_energy_history(Integer id, Adress adress, double consumption, String measurementUnit, LocalDate registryDate, double cost) {
        this.id = id;
        this.adress = adress;
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

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
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
