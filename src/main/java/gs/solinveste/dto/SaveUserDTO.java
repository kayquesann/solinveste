package gs.solinveste.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SaveUserDTO {

    private int id;

    @NotNull
    @Size(min = 1, max = 100)
    private String name;

    @NotNull
    @Size(min = 11, max = 11)
    private String phoneNumber;

    @Email
    @Size(min = 1, max = 100)
    private String email;

    @Size(min = 1, max = 100)
    private String password;

    public SaveUserDTO() {
    }

    public SaveUserDTO(int id, String name, String phoneNumber, String email, String password) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotNull @Size(min = 1, max = 100) String getName() {
        return name;
    }

    public void setName(@NotNull @Size(min = 1, max = 100) String name) {
        this.name = name;
    }

    public @NotNull @Size(min = 11, max = 11) String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@NotNull @Size(min = 11, max = 11) String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public @Email @Size(min = 1, max = 100) String getEmail() {
        return email;
    }

    public void setEmail(@Email @Size(min = 1, max = 100) String email) {
        this.email = email;
    }

    public @Size(min = 1, max = 100) String getPassword() {
        return password;
    }

    public void setPassword(@Size(min = 1, max = 100) String password) {
        this.password = password;
    }
}
