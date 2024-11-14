package gs.solinveste.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
@Table(name = "TB_USUARIO_GE")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOME")
    private String name;

    @NotNull
    @Size(min = 11, max = 11)
    @Column(name = "TELEFONE")
    private String phoneNumber;

    @Email
    @Column(name = "EMAIL")
    @Size(min = 1, max = 100)
    private String email;

    @NotNull
    @Column(name = "SENHA")
    @Size(min = 1, max = 100)
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<Address> addresses;

    public User() {
    }

    public User(Integer id, String name, String phoneNumber, String email, String password) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
