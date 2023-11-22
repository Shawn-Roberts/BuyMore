package com.BuyMore.UserServices

import com.BuyMore.UserServices.DAO.ApplicationUserDAO
import com.BuyMore.UserServices.Entity.ApplicationUser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener

@SpringBootApplication
class UserService{

    @Autowired
    ApplicationUserDAO applicationUserDAO

    static void main(String[] args) {
        SpringApplication.run(UserService, args)
    }

    @EventListener(ApplicationReadyEvent.class)
    def initialize()
    {
        var users = List.of(
        ApplicationUser.createUser()
                .email("first_last@email.com")
                .lastName("last")
                .firstName("first")
                .build(),
        ApplicationUser.createUser()
                .email("second_last-two@email.com")
                .lastName("last-two")
                .firstName("second")
                .build(),
        ApplicationUser.createUser()
                .email("third_last-three@email.com")
                .lastName("last-three")
                .firstName("third")
                .build()

        )

//        users.each {it -> applicationUserDAO.saveApplicationUser(it)}


    }
}
