package com.BuyMore.UserServices.DAO

import com.BuyMore.UserServices.DTO.ApplicationUserDTO
import com.BuyMore.UserServices.Entity.ApplicationUser

interface ApplicationUserDAO {
    Collection<ApplicationUser> findAll()
    ApplicationUser findById(String id)
    ApplicationUserDTO saveApplicationUser(ApplicationUserDTO  userDTO)
    ApplicationUser updateApplicationUser(ApplicationUser applicationUser)
    void deleteApplicationUserById(String id)
    void deleteApplicationUser(ApplicationUser applicationUser)
}
