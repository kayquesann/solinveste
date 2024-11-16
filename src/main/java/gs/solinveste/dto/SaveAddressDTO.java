package gs.solinveste.dto;

import gs.solinveste.model.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class SaveAddressDTO {

    private Integer id;

    private User user;

    @NotNull
    @Size(min = 1, max = 200)
    private String street;

    @NotNull
    @Size(min = 1, max = 100)
    private String neighborhood;

    @NotNull
    @Size(min = 8, max = 20)
    private String CEP;

    @Positive
    private int houseNumber;

    @NotNull
    @Size(min = 1, max = 100)
    private String city;

    @NotNull
    @Size(min = 1, max = 50)
    private String localType;

    public SaveAddressDTO() {
    }

    public SaveAddressDTO(Integer id, User user, String street, String neighborhood, String CEP, int houseNumber, String city, String localType) {
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

    public @NotNull @Size(min = 1, max = 200) String getStreet() {
        return street;
    }

    public void setStreet(@NotNull @Size(min = 1, max = 200) String street) {
        this.street = street;
    }

    public @NotNull @Size(min = 1, max = 100) String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(@NotNull @Size(min = 1, max = 100) String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public @NotNull @Size(min = 8, max = 20) String getCEP() {
        return CEP;
    }

    public void setCEP(@NotNull @Size(min = 8, max = 20) String CEP) {
        this.CEP = CEP;
    }

    @Positive
    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(@Positive int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public @NotNull @Size(min = 1, max = 100) String getCity() {
        return city;
    }

    public void setCity(@NotNull @Size(min = 1, max = 100) String city) {
        this.city = city;
    }

    public @NotNull @Size(min = 1, max = 50) String getLocalType() {
        return localType;
    }

    public void setLocalType(@NotNull @Size(min = 1, max = 50) String localType) {
        this.localType = localType;
    }
}
