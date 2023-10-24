package com.BuyMore.CartService.Entity

import com.BuyMore.ProductServices.Entity.Product

class CartDetails {


    private UUID userId
    private ArrayList<Product> list

    //GETTERS
    UUID getUserId() { return userId }
    ArrayList<Product> getList() { return Collections.copy(list, new ArrayList<Product>()) }

    //SETTERS
    void setUserId(UUID userId) { this.userId = userId }
    void setList(ArrayList<Product> list) { this.list = Collections.copy(list, new ArrayList<>()) }
}
