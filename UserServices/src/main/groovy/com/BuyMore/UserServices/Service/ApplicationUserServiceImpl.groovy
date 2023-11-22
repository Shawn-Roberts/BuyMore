package com.BuyMore.UserServices.Service

import com.BuyMore.UserServices.DAO.ApplicationUserDAO
import com.BuyMore.UserServices.DTO.ApplicationUserDTO
import com.BuyMore.UserServices.Entity.ApplicationUser
import com.BuyMore.UserServices.Mapper.ApplicationUserMapper
import com.BuyMore.UserServices.Response.ApplicationUserResponseHandler
import io.micrometer.common.util.StringUtils
import jakarta.persistence.EntityExistsException
import jakarta.persistence.NoResultException
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.codehaus.groovy.util.StringUtil
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
            log.debug("ApplicationUser Service - received findAll request")
            Collection<ApplicationUser> users = applicationUserDAO.findAll()
            log.info("ApplicationUser Service  - request findAll returned successful response")
            ApplicationUserResponseHandler.generateResponse("Results Returned",HttpStatus.OK,users)
        }
        catch(Exception e)
        {
            log.error("ApplicationUser Service - request findAll Exception: ${e.getMessage()}")
            return  ApplicationUserResponseHandler.generateResponse("Bad Request: Internal Server Error",HttpStatus.BAD_REQUEST,[])
        }
    }

    @Override
    ResponseEntity<Object> findById(String id) {
        try{
            //validate input
            log.debug("ApplicationUser Service - received findById request")
            ApplicationUser user = applicationUserDAO.findById(id)
            log.info("ApplicationUser Service - request findByID returned successful response")
            ApplicationUserResponseHandler.generateResponse("Results Returned",HttpStatus.OK,user)
        }
        catch(IllegalArgumentException e)
        {
            log.error("ApplicationUser Service Error - request findByID with params ${id} Bad Request: ${e.getMessage()}")
            return  ApplicationUserResponseHandler.generateResponse("Bad Request: Invalid Arguments ${id}",HttpStatus.BAD_REQUEST,[])
        }
        catch(NoResultException ignored)
        {
            log.info("ApplicationUser Service Info - request findByID with params ${id} returned no results")
            return ApplicationUserResponseHandler.generateResponse("No Users found with ID ${id}",HttpStatus.NOT_FOUND,[])
        }
        catch(Exception e){
            log.error("ApplicationUser Service Error  - reuqest findById General Error: ${e.getMessage()} ")
            return  ApplicationUserResponseHandler.generateResponse("Bad Request: Internal Server Error",HttpStatus.BAD_REQUEST,[])
        }
    }

    @Override
    ResponseEntity<Object> saveUser(ApplicationUserDTO userDTO) {
        try{
            log.debug("ApplicationUser Service - received saveUser request")
            if(userDTO == null) throw new IllegalArgumentException("Invalid user argument")
            ApplicationUserDTO userDTOUpdated = applicationUserDAO.saveApplicationUser(userDTO)
            log.info("ApplicationUser Service - request saveUser returned successful response")
            ApplicationUserResponseHandler.generateResponse("Successfully saved new user",HttpStatus.OK,userDTOUpdated)
        }
        catch(IllegalArgumentException | EntityExistsException e)
        {
            log.error("ApplicationUser Service Error - request saveUser Bad Request: ${e.getMessage()}")
            return  ApplicationUserResponseHandler.generateResponse("Bad Request: Save User with invalid arguments",HttpStatus.BAD_REQUEST,[])
        }
        catch(Exception e){
            log.error("ApplicationUser Service Error  - reuqest saveUser General Error: ${e.getMessage()} ")
            return  ApplicationUserResponseHandler.generateResponse("Bad Request: Internal Server Error",HttpStatus.BAD_REQUEST,[])
        }
    }

    @Override
    ResponseEntity<Object> updateUser(ApplicationUser updatedUser) {
        try{
            log.debug("ApplicationUser Service - received updateUser request")
            if(updatedUser == null) throw new IllegalArgumentException("Invalid user argument")
            applicationUserDAO.updateApplicationUser(updatedUser)
            log.info("ApplicationUser Service - request updateUser returned successful response")
            ApplicationUserResponseHandler.generateResponse("Successfully updated new user",HttpStatus.OK,updatedUser)
        }
        catch(IllegalArgumentException | EntityExistsException e)
        {
            log.error("ApplicationUser Service Error - request updateUser Bad Request: ${e.getMessage()}")
            return  ApplicationUserResponseHandler.generateResponse("Bad Request: Save User with invalid arguments",HttpStatus.BAD_REQUEST,[])
        }
        catch(Exception e){
            log.error("ApplicationUser Service Error  - reuqest updateUser General Error: ${e.getMessage()} ")
            return  ApplicationUserResponseHandler.generateResponse("Bad Request: Internal Server Error",HttpStatus.BAD_REQUEST,[])
        }
    }

    @Override
    ResponseEntity<Object> deleteUserById(String id) {
        try
        {
            log.debug("ApplicationUser Service - received deleteUserById request")
            if(StringUtils.isNotBlank(id)) applicationUserDAO.deleteApplicationUserById(id)
            log.info("ApplicationUser Service - request deleteUserById  returned successful response")
            ApplicationUserResponseHandler.generateResponse("Successfully deleted user with id ${id}", HttpStatus.OK, [])
        }
        catch(IllegalArgumentException | EntityExistsException e)
        {
            log.error("ApplicationUser Service Error - request deleteUserById with params ${id} Bad Request: ${e.getMessage()}")
            return  ApplicationUserResponseHandler.generateResponse("Bad Request: delete user with invalid arguments",HttpStatus.BAD_REQUEST,[])
        }
        catch(Exception e){
            log.error("ApplicationUser Service Error  - reuqest deleteUserById General Error: ${e.getMessage()} ")
            return  ApplicationUserResponseHandler.generateResponse("Bad Request: Internal Server Error",HttpStatus.BAD_REQUEST,[])
        }
    }

    @Override
    ResponseEntity<Object> deleteUser(ApplicationUser applicationUser) {
        try
        {
            log.debug("ApplicationUser Service - received deleteUserById request")
            applicationUserDAO.deleteApplicationUser(applicationUser)
            log.info("ApplicationUser Service - request deleteUserBy returned successful response")
            ApplicationUserResponseHandler.generateResponse("Successfully deleted user", HttpStatus.OK, [])
        }
        catch(IllegalArgumentException | EntityExistsException e)
        {
            log.error("ApplicationUser Service Error - request deleteUserBy  Bad Request: ${e.getMessage()}")
            return  ApplicationUserResponseHandler.generateResponse("Bad Request: delete user with invalid arguments",HttpStatus.BAD_REQUEST,[])
        }
        catch(Exception e){
            log.error("ApplicationUser Service Error  - reuqest deleteUser General Error: ${e.getMessage()} ")
            return  ApplicationUserResponseHandler.generateResponse("Bad Request: Internal Server Error",HttpStatus.BAD_REQUEST,[])
        }
    }
}
