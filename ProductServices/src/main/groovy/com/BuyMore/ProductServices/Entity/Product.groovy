package com.BuyMore.ProductServices.Entity

import com.BuyMore.Utilities.PriceValidationTests
import com.BuyMore.Utilities.StringValidationTests
import groovy.transform.builder.Builder
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.NotNull

@Entity
@Table(name = 'product')
class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long productID

    @Column(name="uniqueID")
    @NotNull
    private UUID uniqueID

    @Column(name="name")
    @NotNull
    private String name

    @Column(name="description")
    @NotNull
    private String description

    @Column(name="price")
    @NotNull
    @DecimalMin(value = "0.50")
    private BigDecimal price = 0.00

    @Column(name="rating")
    @NotNull
    @DecimalMin(value = "0.00")
    @DecimalMax(value = "5.00")
    private Double rating = 0.00

    //CONSTRUCTORS
    Product() {}

    //BUILDERS
    @Builder(builderMethodName = 'createProduct')
    Product(String name, String description, BigDecimal price, Double rating) {
        setName(name)
        setDescription(description)
        setPrice(price)
        setRating(rating)
        setUniqueID()
    }

    //GETTERS
    Long getUserID() { return userID }
    UUID getUniqueID() { return uniqueID }
    String getName() { return name }
    String getDescription() { return description }
    BigDecimal getPrice() { return price }
    Double getRating() { return rating }

    //SETTERS

    void setName(String name) throws IllegalArgumentException, NullPointerException
    {
        if(StringValidationTests.validateStringField(name,"name"))
        this.name = new String(name)
    }

    void setDescription(String description) throws IllegalArgumentException, NullPointerException
    {
        if(StringValidationTests.validateStringField(description,"description"))
        this.description = new String(description)
    }

    void setPrice(BigDecimal price) throws IllegalArgumentException, NullPointerException
    {
        if(PriceValidationTests.validatePrice(price,"price"))
        this.price = BigDecimal.valueOf(price)
    }

    void setRating(Double rating) throws IllegalArgumentException, NullPointerException
    {
        if(PriceValidationTests.validatePrice(rating,"rating"))
        this.rating = Double.valueOf(rating)
    }

    private void setUniqueID() { this.uniqueID = UUID.randomUUID() }
}
