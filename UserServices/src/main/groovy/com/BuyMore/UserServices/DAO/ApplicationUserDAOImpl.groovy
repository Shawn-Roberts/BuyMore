package com.BuyMore.UserServices.DAO

import com.BuyMore.UserServices.Entity.ApplicationUser
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class ApplicationUserDAOImpl implements ApplicationUserDAO {

    @PersistenceContext
    private EntityManager entityManager

    @Autowired
    ApplicationUserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager
    }


    private ApplicationUser userForPOC = ApplicationUser.createUser()
            .email("TEST@EMAIL.COM")
            .lastName("LAST")
            .firstName("FIRST")
            .build()

    @Override
    Collection<ApplicationUser> findAll() {
        return List.of(userForPOC)
    }

    @Override
    Optional<ApplicationUser> findById(String id) {
        return Optional.of(userForPOC)
    }

    @Override
    Collection<ApplicationUser> search(String query) {
        return List.of(userForPOC)
    }

    @Override
    ApplicationUser saveApplicationUser() {
        return userForPOC
    }

    @Override
    void deleteApplicationUserById(String id) {}
}
