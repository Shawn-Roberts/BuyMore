package com.BuyMore.CartService

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener

@SpringBootApplication
class CartService {
    static void main(String[] args) {
        SpringApplication.run(CartService, args)
    }

    @EventListener(ApplicationReadyEvent.class)
    def initialize()
    { println "HELLO"}
}
