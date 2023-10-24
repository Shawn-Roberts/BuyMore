package com.BuyMore.CartService.Service

import com.BuyMore.CartService.Entity.Cart
import com.BuyMore.CartService.Entity.CartDetails
import com.BuyMore.CartService.Entity.Product

interface CartService {

    void addItemToCart(Product product, Cart cart)
    void removeItemFromCart(Product product, Cart cart)
    CartDetails displayItemsInUsersCart(UUID userId)
}
