package com.BuyMore.UserServices.Service

import org.springframework.http.ResponseEntity

interface ApplicationUserService {
    ResponseEntity<Object> findAll()
    ResponseEntity<Object> findById(String id)
    ResponseEntity<Object> search(String parameter)
}
