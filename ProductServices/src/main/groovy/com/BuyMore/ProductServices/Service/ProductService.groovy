package com.BuyMore.ProductServices.Service

import org.springframework.http.ResponseEntity

interface ProductService {
    ResponseEntity<Object> findAll()
    ResponseEntity<Object> findById(String id)
    ResponseEntity<Object> search(String parameter)
}
