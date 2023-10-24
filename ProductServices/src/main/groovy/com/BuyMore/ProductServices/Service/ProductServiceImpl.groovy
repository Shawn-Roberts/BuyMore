package com.BuyMore.ProductServices.Service

import com.BuyMore.ProductServices.DAO.ProductDAO
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
class ProductServiceImpl implements ProductService{

    @Autowired
    private final ProductDAO productDAO

    private static final Logger log = LogManager.getLogger(ProductService.class)

    @Override
    ResponseEntity<Object> findAll() {
        try{
            log.info("Product Service  - request findAll returned successful response")
            ProductResponseHandler.generateResponse("Results Returned",HttpStatus.OK,productDAO.findAll())
        }
        catch(Exception e)
        {
            log.error("Product Service  - request findAll Exception: ${e.getMessage()}")
            return  ProductResponseHandler.generateResponse("Bad Request: ${e.getMessage()}",HttpStatus.BAD_REQUEST,[])
        }
    }

    @Override
    ResponseEntity<Object> findById(String id) {
        try{
            log.info("Product Service  Error - request findByID with params ${id} returned successful response")
            ProductResponseHandler.generateResponse("Results Returned",HttpStatus.OK,productDAO.findById(id))
        }
        catch(IllegalArgumentException e)
        {
            log.error("Product Service  Error - request findByID with params ${id} Bad Request: ${e.getMessage()}")
            return  ProductResponseHandler.generateResponse("Bad Request: ${e.getMessage()}",HttpStatus.BAD_REQUEST,[])
        }
        catch(Exception e){
            log.error("Product Service  Error  - reuqest findById General Error: ${e.getMessage()} ")
            return ProductResponseHandler.generateResponse("Bad Request: ${e.getMessage()}",HttpStatus.BAD_REQUEST,[])
        }
    }

    @Override
    ResponseEntity<Object> search(String parameter) {
        try {
            log.info("Product Service  - request findAllSimpleQuery with params ${parameter} returned successful response")
            ProductResponseHandler.generateResponse("Results Returned", HttpStatus.OK,productDAO.search(parameter))
        }
        catch(Exception e){
            log.error("Product Service  Error  - reuqest findAllSimpleQuery General Error: ${e.getMessage()} ")
            return  ProductResponseHandler.generateResponse("Bad Request: ${e.getMessage()}",HttpStatus.BAD_REQUEST,[])
        }
    }
}
