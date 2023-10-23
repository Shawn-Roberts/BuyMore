package com.BuyMore.ProductServices.DAO

import com.BuyMore.ProductServices.Entity.Product

interface ProductDAO {
    Collection<Product> findAll()
    Optional<Product> findById(String id)
    Collection<Product> search(String query)
    Product saveProduct(Product product)
    void deleteProductById(String id)
}
