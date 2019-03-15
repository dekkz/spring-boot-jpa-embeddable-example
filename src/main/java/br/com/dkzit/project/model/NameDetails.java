package br.com.dkzit.project.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class NameDetails {

    @NotNull
    @Size(max = 40)
    private String firstName;

    @Size(max = 40)
    private String lastName;

    public NameDetails() {
    }

    public NameDetails(@NotNull @Size(max = 40) String firstName, @Size(max = 40) String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
