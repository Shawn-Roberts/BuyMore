package com.BuyMore.CartService.Service

import com.BuyMore.CartService.Entity.Product
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Component
interface ProductDetailsProxy {
    @GetMapping("products/search/{productId}")
    Product getProductById(@PathVariable UUID productId)
}
