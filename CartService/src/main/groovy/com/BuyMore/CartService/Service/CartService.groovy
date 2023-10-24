package com.BuyMore.CartService.Service

import com.BuyMore.CartService.Entity.Cart
import com.BuyMore.CartService.Entity.CartDetails
import com.BuyMore.CartService.Entity.Product
import org.springframework.http.ResponseEntity

interface CartService {

    ResponseEntity<Object> addItemToCart(Cart cart)
    ResponseEntity<Object> removeItemFromCart(Cart cart)
    ResponseEntity<CartDetails> displayItemsInUsersCart(UUID userId)
}
