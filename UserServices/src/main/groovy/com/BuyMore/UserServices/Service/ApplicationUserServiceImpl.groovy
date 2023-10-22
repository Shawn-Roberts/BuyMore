package com.BuyMore.UserServices.Service

import com.BuyMore.UserServices.DAO.ApplicationUserDAO
import com.BuyMore.UserServices.Response.ApplicationUserResponseHandler
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.http.HttpStatus

@Service
@Transactional(readOnly = true)
class ApplicationUserServiceImpl implements ApplicationUserService{

    @Autowired
    private final ApplicationUserDAO applicationUserDAO

    private static final Logger log = LogManager.getLogger(ApplicationUserService.class)

    @Override
    ResponseEntity<Object> findAll() {
        try{
            log.info("ApplicationUser Service  - request findAll returned successful response")
            ApplicationUserResponseHandler.generateResponse("Results Returned",HttpStatus.OK,applicationUserDAO.findAll())
        }
        catch(Exception e)
        {
            log.error("ApplicationUser Service - request findAll Exception: ${e.getMessage()}")
            return  ApplicationUserResponseHandler.generateResponse("Bad Request: ${e.getMessage()}",HttpStatus.BAD_REQUEST,[])
        }
    }

    @Override
    ResponseEntity<Object> findById(String id) {
        try{
            log.info("ApplicationUser Service Error - request findByID with params ${id} returned successful response")
            ApplicationUserResponseHandler.generateResponse("Results Returned",HttpStatus.OK,applicationUserDAO.findById(id))
        }
        catch(IllegalArgumentException e)
        {
            log.error("ApplicationUser Service Error - request findByID with params ${id} Bad Request: ${e.getMessage()}")
            return  ApplicationUserResponseHandler.generateResponse("Bad Request: ${e.getMessage()}",HttpStatus.BAD_REQUEST,[])
        }
        catch(Exception e){
            log.error("ApplicationUser Service Error  - reuqest findById General Error: ${e.getMessage()} ")
            return  ApplicationUserResponseHandler.generateResponse("Bad Request: ${e.getMessage()}",HttpStatus.BAD_REQUEST,[])
        }
    }

    @Override
    ResponseEntity<Object> search(String parameter) {
        try {
            log.info("ApplicationUser Service - request findAllSimpleQuery with params ${parameter} returned successful response")
            ApplicationUserResponseHandler.generateResponse("Results Returned", HttpStatus.OK,applicationUserDAO.search(parameter))
        }
        catch(Exception e){
            log.error("ApplicationUser Service Error  - reuqest findAllSimpleQuery General Error: ${e.getMessage()} ")
            return  ApplicationUserResponseHandler.generateResponse("Bad Request: ${e.getMessage()}",HttpStatus.BAD_REQUEST,[])
        }
    }
}
