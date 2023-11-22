package com.BuyMore.UserServices.Service

import com.BuyMore.UserServices.DTO.ApplicationUserDTO
import com.BuyMore.UserServices.Entity.ApplicationUser
import org.springframework.http.ResponseEntity

interface ApplicationUserService {
    ResponseEntity<Object> findAll()
    ResponseEntity<Object> findById(String id)
    ResponseEntity<Object> saveUser(ApplicationUserDTO userDTO)
    ResponseEntity<Object> updateUser(ApplicationUser updatedUser)
    ResponseEntity<Object> deleteUserById(String id)
    ResponseEntity<Object> deleteUser(ApplicationUser applicationUser)
}
