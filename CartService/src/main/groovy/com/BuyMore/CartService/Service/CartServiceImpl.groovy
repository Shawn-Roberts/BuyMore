package com.BuyMore.CartService.Service

import com.BuyMore.CartService.DAO.CartDAO
import com.BuyMore.CartService.Entity.Cart
import com.BuyMore.CartService.Entity.CartDetails
import com.BuyMore.CartService.Entity.Product
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class CartServiceImpl implements CartService {

    @Autowired
    private final CartDAO cartDAO

    private static final Logger log = LogManager.getLogger(CartServiceImpl.class)

    @Override
    void addItemToCart(Product product, Cart cart) {
            cartDAO.save(cart)
    }

    @Override
    void removeItemFromCart(Product product, Cart cart) {
            cartDAO.deleteCart(cart)
    }

    @Override
    CartDetails displayItemsInUsersCart(UUID userId) {
        return null
    }
}
