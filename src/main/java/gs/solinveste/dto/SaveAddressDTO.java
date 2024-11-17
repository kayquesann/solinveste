package gs.solinveste.dto;

import gs.solinveste.model.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class SaveAddressDTO {

    private Integer id;

    private Integer userId;

    @NotNull
    @Size(min = 1, max = 200)
    private String street;

    @NotNull
    @Size(min = 1, max = 100)
    private String neighborhood;

    @NotNull
    @Size(min = 8, max = 20)
    private String cep;

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

    public SaveAddressDTO(Integer id, Integer userId, String street, String neighborhood, String cep, int houseNumber, String city, String localType) {
        this.id = id;
        this.userId = userId;
        this.street = street;
        this.neighborhood = neighborhood;
        this.cep = cep;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public @NotNull @Size(min = 8, max = 20) String getCep() {
        return cep;
    }

    public void setCep(@NotNull @Size(min = 8, max = 20) String cep) {
        this.cep = cep;
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
