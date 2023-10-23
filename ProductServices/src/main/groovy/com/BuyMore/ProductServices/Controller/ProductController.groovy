package com.BuyMore.ProductServices.Controller

import com.BuyMore.ProductServices.Service.ProductService
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("/product")
class ProductController {

    @Autowired
    ProductService productService
    private static final Logger log = LogManager.getLogger(ProductService.class)

    @GetMapping("/")
    ResponseEntity<Object> findAll() {
        log.info("Product Controller - request findAll")
        return productService.findAll()
    }

    @GetMapping("/{id}")
    ResponseEntity<Object> findById(@PathVariable(required = true, name = "id") String id) {
        log.info("Product Controller - request findByID with params ${id}")
        return productService.findById(id)
    }
}
