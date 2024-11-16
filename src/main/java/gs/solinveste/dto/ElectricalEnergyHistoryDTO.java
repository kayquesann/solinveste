package gs.solinveste.dto;

import gs.solinveste.model.Address;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ElectricalEnergyHistoryDTO {

    private Integer id;

    private Address addressHistory;

    @PositiveOrZero
    private double consumption;

    @NotNull
    @Size(min = 1, max = 10)
    private String measurementUnit;


    private LocalDate registryDate;

    @PositiveOrZero
    private double cost;

    public ElectricalEnergyHistoryDTO() {
    }

    public ElectricalEnergyHistoryDTO(Integer id, Address addressHistory, double consumption, String measurementUnit, LocalDate registryDate, double cost) {
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

    @PositiveOrZero
    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(@PositiveOrZero double consumption) {
        this.consumption = consumption;
    }

    public @NotNull @Size(min = 1, max = 10) String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(@NotNull @Size(min = 1, max = 10) String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public LocalDate getRegistryDate() {
        return registryDate;
    }

    public void setRegistryDate(LocalDate registryDate) {
        this.registryDate = registryDate;
    }

    @PositiveOrZero
    public double getCost() {
        return cost;
    }

    public void setCost(@PositiveOrZero double cost) {
        this.cost = cost;
    }
}
