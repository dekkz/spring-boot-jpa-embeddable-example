package br.com.dkzit.project.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class User {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private NameDetails nameDetails;

    @NotNull
    @Email
    @Column(unique = true)
    private String email;

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "addressLine1", column = @Column(name = "house_number")),
            @AttributeOverride(name = "addressLine2", column = @Column(name = "street"))
    })
    private Address address;

    public User(){
    }

    public User(NameDetails nameDetails, @NotNull @Email String email, Address address) {
        this.nameDetails = nameDetails;
        this.email = email;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NameDetails getNameDetails() {
        return nameDetails;
    }

    public void setNameDetails(NameDetails nameDetails) {
        this.nameDetails = nameDetails;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
