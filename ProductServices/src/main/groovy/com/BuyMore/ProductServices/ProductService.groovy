package com.BuyMore.ProductServices

import com.BuyMore.ProductServices.DAO.ProductDAO
import com.BuyMore.ProductServices.Entity.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener

@SpringBootApplication
class ProductService{

    @Autowired
    ProductDAO productDAO

    static void main(String[] args) {
        SpringApplication.run(ProductService, args)
    }

    @EventListener(ApplicationReadyEvent.class)
    def initialize()
    {
        var products = List.of(
            Product.createProduct()
                    .name("product")
                    .description("product desc")
                    .price(new BigDecimal(9.99))
                    .rating(1.25)
                    .build(),
            Product.createProduct()
                    .name("product2")
                    .description("product desc2")
                    .price(new BigDecimal(0.60))
                    .rating(5)
                    .build()
        )

        products.each {it -> productDAO.saveProduct(it)}



    }
}
