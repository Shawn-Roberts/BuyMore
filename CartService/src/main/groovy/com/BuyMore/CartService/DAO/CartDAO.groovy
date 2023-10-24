package com.BuyMore.CartService.DAO

import com.BuyMore.CartService.Entity.Cart
import com.BuyMore.CartService.Entity.CartDetails

interface CartDAO {
    Cart save(Cart cart)
    void deleteCart(Cart cart)
    CartDetails displayCartItemsByUser(UUID userID)
}
