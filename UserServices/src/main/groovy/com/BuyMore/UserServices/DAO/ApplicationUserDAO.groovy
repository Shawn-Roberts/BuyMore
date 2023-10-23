package com.BuyMore.UserServices.DAO

import com.BuyMore.UserServices.Entity.ApplicationUser

interface ApplicationUserDAO {
    Collection<ApplicationUser> findAll()
    Optional<ApplicationUser> findById(String id)
    Collection<ApplicationUser> search(String query)
    ApplicationUser saveApplicationUser(ApplicationUser applicationUser)
    void deleteApplicationUserById(String id)
}
