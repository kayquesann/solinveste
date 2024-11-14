package gs.solinveste.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "TB_ENDERECO_GE")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JoinColumn(name = "ID_USUARIO")
    @OneToOne
    private User user;

    @Column(name = "LOGRADOURO")
    private String street;

    @Column(name = "BAIRRO")
    private String neighborhood;

    @Column(name = "CEP")
    private String CEP;

    @Column(name = "NUMERO_RESIDENCIA")
    private int houseNumber;

    @Column(name = "CIDADE")
    private String city;

    @Column(name = "TIPO_LOCAL")
    private String localType;

    @OneToMany(mappedBy = "addressBudget")
    private Set<Solar_panel_budget> budgets;

    @OneToMany(mappedBy = "addressHistory")
    private Set<Electrical_energy_history> history;

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
}
