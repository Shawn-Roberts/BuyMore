package com.BuyMore.CartService.DAO

import com.BuyMore.CartService.Entity.Cart

interface CartDAO {
    Cart save(Cart cart)
    void deleteCart(Cart cart)
    ArrayList<Cart> findByUserID(UUID userID)
}
