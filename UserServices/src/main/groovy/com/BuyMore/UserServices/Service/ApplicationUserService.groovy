package com.BuyMore.UserServices.Service

import com.BuyMore.UserServices.DTO.ApplicationUserDTO
import com.BuyMore.UserServices.Entity.ApplicationUser
import org.springframework.http.ResponseEntity

interface ApplicationUserService {
    ResponseEntity<Object> findAll()
    ResponseEntity<Object> findById(Long id)
    ResponseEntity<Object> saveUser(ApplicationUserDTO userDTO)
    ResponseEntity<Object> updateUser(ApplicationUserDTO userDTO)
    ResponseEntity<Object> deleteUser(ApplicationUserDTO userDTO)
    ResponseEntity<Object> deleteUserById(Long id)
}
