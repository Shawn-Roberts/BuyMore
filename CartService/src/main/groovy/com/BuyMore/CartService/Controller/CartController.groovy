package com.BuyMore.CartService.Controller

import com.BuyMore.CartService.Entity.Cart
import com.BuyMore.CartService.Service.CartService
import com.BuyMore.ProductServices.Service.ProductService
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("/cart")
class CartController {

    @Autowired
    CartService cartService
    private static final Logger log = LogManager.getLogger(CartController.class)

    @GetMapping("/show/{userId}")
    ResponseEntity<Object> showCartById(@PathVariable(required = true, name = "userId") UUID userId)
    {
        log.info("Cart Controller - request show cart by ID")
        return cartService.displayItemsInUsersCart(userId)
    }

    @PostMapping("/add")
    ResponseEntity<Object> addToCart(@RequestBody Cart cart)
    {
        log.info("Cart Controller - request add to cart")
        return cartService.addItemToCart(cart)
    }

    @DeleteMapping("/remove")
    ResponseEntity<Object> removeFromCart(@RequestBody Cart cart)
    {
        log.info("Cart Controller - request remove from cart")
        return cartService.removeItemFromCart(cart)
    }
}
