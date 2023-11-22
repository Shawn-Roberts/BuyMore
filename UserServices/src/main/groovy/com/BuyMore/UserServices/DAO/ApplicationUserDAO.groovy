package com.BuyMore.UserServices.DAO

import com.BuyMore.UserServices.DTO.ApplicationUserDTO
import com.BuyMore.UserServices.Entity.ApplicationUser

interface ApplicationUserDAO {
    Collection<ApplicationUser> findAll()
    ApplicationUser findById(Long id)
    ApplicationUserDTO saveApplicationUser(ApplicationUserDTO  userDTO)
    ApplicationUserDTO updateApplicationUser(ApplicationUserDTO userDTO)
    void deleteApplicationUser(ApplicationUserDTO userDTO)
    void deleteApplicationUserById(Long id)
}
