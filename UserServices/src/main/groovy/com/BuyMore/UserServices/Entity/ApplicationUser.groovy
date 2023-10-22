package com.BuyMore.UserServices.Entity

import com.BuyMore.UserServices.Common.EmailValidation
import com.BuyMore.UserServices.Common.StringValidation
import groovy.transform.builder.Builder
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotNull

@Entity
@Table(name = 'applicationUser')
class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long userID

    @Column(name="uniqueID")
    @NotNull
    public UUID uniqueID

    @Column(name="firstName")
    @NotNull
    private String firstName

    @Column(name="lastName")
    @NotNull
    private String lastName

    @Column(name="email")
    @NotNull
    @Email
    private String email

    //CONSTRUCTORS
    ApplicationUser(){}

    //BUILDER
    @Builder(builderMethodName = 'createUser')
    ApplicationUser(String firstName, String lastName, String email)
    {
        setFirstName(firstName)
        setLastName(lastName)
        setEmail(email)
        setUniqueID()
    }

    //GETTERS
    Long getUserID() { return userID }
    UUID getUniqueID() { return this.uniqueID }
    String getFirstName() { return firstName }
    String getLastName() { return lastName }
    String getEmail() { return email }

    //SETTERS
    void setFirstName(String firstName) throws IllegalArgumentException, NullPointerException {
        if(StringValidation.validateStringField(firstName,"firstName"))
            this.firstName = firstName
    }

    void setLastName(String lastName) throws IllegalArgumentException, NullPointerException {
        if(StringValidation.validateStringField(lastName,"lastName"))
            this.lastName = lastName

    }

    void setEmail(String email) throws IllegalArgumentException, NullPointerException {
        if(EmailValidation.validateEmail(email))
            this.email = email
    }

    private setUniqueID() { this.uniqueID = UUID.randomUUID() }

}
