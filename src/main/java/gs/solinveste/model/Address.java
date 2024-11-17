package gs.solinveste.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
@Table(name = "TB_ENDERECO_GE")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "ID_USUARIO")
    @OneToOne
    private User user;

    @Column(name = "LOGRADOURO",length = 200, nullable = false)
    private String street;

    @Column(name = "BAIRRO", length = 100, nullable = false)
    private String neighborhood;

    @Column(name = "CEP", length = 20, nullable = false)
    private String CEP;

    @Column(name = "NUMERO_RESIDENCIA")
    private int houseNumber;

    @Column(name = "CIDADE", length = 100, nullable = false)
    private String city;

    @Column(name = "TIPO_LOCAL", length = 50, nullable = false)
    private String localType;

    @OneToMany(mappedBy = "addressBudget")
    private Set<SolarPanelBudget> budgets;

    @OneToMany(mappedBy = "addressHistory")
    private Set<ElectricalEnergyHistory> history;

    public Address() {
    }

    public Address(Integer id, User user, String street, String neighborhood, String CEP, int houseNumber, String city, String localType) {
        this.id = id;
        this.user = user;
        this.street = street;
        this.neighborhood = neighborhood;
        this.CEP = CEP;
        this.houseNumber = houseNumber;
        this.city = city;
        this.localType = localType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocalType() {
        return localType;
    }

    public void setLocalType(String localType) {
        this.localType = localType;
    }

    public Set<SolarPanelBudget> getBudgets() {
        return budgets;
    }

    public void setBudgets(Set<SolarPanelBudget> budgets) {
        this.budgets = budgets;
    }

    public Set<ElectricalEnergyHistory> getHistory() {
        return history;
    }

    public void setHistory(Set<ElectricalEnergyHistory> history) {
        this.history = history;
    }
}
