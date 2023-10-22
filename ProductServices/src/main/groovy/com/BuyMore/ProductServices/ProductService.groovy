package com.BuyMore.ProductServices

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener

@SpringBootApplication
class ProductService{
    static void main(String[] args) {
        SpringApplication.run(ProductService, args)
    }

    @EventListener(ApplicationReadyEvent.class)
    def initialize()
    {

    }
}
