package com.BuyMore.UserServices

import com.BuyMore.UserServices.Entity.ApplicationUser
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener

@SpringBootApplication
class UserService{

    static void main(String[] args) {
        SpringApplication.run(UserService, args)
    }

    @EventListener(ApplicationReadyEvent.class)
    def initialize()
    {
        ApplicationUser user = ApplicationUser.createUser()
        .email("TEST@EMAIL.COM")
        .lastName("LAST")
        .firstName("FIRST")
        .build()

    }
}
