package com.BuyMore.CartService.Service

import com.BuyMore.CartService.DAO.CartDAO
import com.BuyMore.CartService.Entity.Cart
import com.BuyMore.CartService.Entity.CartDetails
import com.BuyMore.CartService.Entity.Product
import com.BuyMore.CartService.Response.CartResponseHandler
import com.BuyMore.ProductServices.Response.ProductResponseHandler
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class CartServiceImpl implements CartService {

    @Autowired
    private final CartDAO cartDAO

    private static final Logger log = LogManager.getLogger(CartServiceImpl.class)

    @Override
    ResponseEntity<Object> addItemToCart(Cart cart) {
        try{
            log.info("Cart Service - add item to cart returned successful response")
            CartResponseHandler.generateResponse("Results Returned", HttpStatus.OK, cartDAO.save(cart))
        }
        catch(Exception e)
        {
            log.error("Cart Service  - request add item to cart Exception: ${e.getMessage()}")
            return  ProductResponseHandler.generateResponse("Bad Request: ${e.getMessage()}",HttpStatus.BAD_REQUEST,[])
        }
    }

    @Override
    ResponseEntity<Object> removeItemFromCart(Cart cart) {
        try{
            log.info("Cart Service - remove item to cart returned successful response")
            CartResponseHandler.generateResponse("Results Returned", HttpStatus.OK, cartDAO.deleteCart(cart))
        }
        catch(Exception e)
        {
            log.error("Cart Service  - request remove item from cart Exception: ${e.getMessage()}")
            return  ProductResponseHandler.generateResponse("Bad Request: ${e.getMessage()}",HttpStatus.BAD_REQUEST,[])
        }
    }

    @Override
    ResponseEntity<Object> displayItemsInUsersCart(UUID userId) {
        try{
            log.info("Cart Service - display cart items  returned successful response")
            CartResponseHandler.generateResponse("Results Returned", HttpStatus.OK, cartDAO.displayCartItemsByUser(userId))
        }
        catch(Exception e)
        {
            log.error("Cart Service  - request display cart itemsException: ${e.getMessage()}")
            return  ProductResponseHandler.generateResponse("Bad Request: ${e.getMessage()}",HttpStatus.BAD_REQUEST,[])
        }
    }
}
