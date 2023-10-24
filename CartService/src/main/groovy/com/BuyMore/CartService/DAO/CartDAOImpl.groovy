package com.BuyMore.CartService.DAO

import com.BuyMore.CartService.Entity.Cart
import com.BuyMore.CartService.Entity.CartDetails
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

import java.awt.font.TextLayout

@Repository
class CartDAOImpl implements CartDAO {

    @PersistenceContext
    private EntityManager entityManager

    @Autowired
    CartDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager
    }

    private Cart cartPOC = Cart.createCart()
    .userID(UUID.randomUUID())
    .productID(UUID.randomUUID())
    .build()

    @Override
    CartDetails displayCartItemsByUser(UUID userID) {
        return null
    }

    @Override
    Cart save(Cart cart) {
        entityManager.persist(cart)
        return cartPOC
    }

    @Override
    void deleteCart(Cart cart) {}

}
