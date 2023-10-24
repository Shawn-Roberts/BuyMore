package com.BuyMore.CartService.Entity

import groovy.transform.builder.Builder
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull

@Entity
@Table(name="cart")
class Cart {

    //TO DO
    //implement logic to ensure product/user ID exist before applying

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long cartID

    @Column(name="userID", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @NotNull
    private UUID userID

    @Column(name="productID", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @NotNull
    private UUID productID

    //CONSTRUCTORS
    Cart() {}

    //BUILDERS
    @Builder(builderMethodName ='createCart')
    Cart(UUID userID, UUID productID) {
        this.userID = userID
        this.productID = productID
    }

    //GETTERS
    UUID getUserID() { return userID}
    UUID getProductID() { return productID }

    //SETTERS
    void setUserID(UUID userID) { this.userID = userID }
    void setProductID(UUID productID) { this.productID = productID }
}
