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
            Collection<ApplicationUser> users = applicationUserDAO.findAll()
            ApplicationUserResponseHandler.generateResponse("Results Returned",HttpStatus.OK,users)
        }
        catch(Exception ignored)
        {
            return  ApplicationUserResponseHandler.generateResponse("Bad Request: Internal Server Error",HttpStatus.BAD_REQUEST,[])
        }
    }

    @Override
    ResponseEntity<Object> findById(Long id) {
        try
        {
            ApplicationUser user = applicationUserDAO.findById(id)
            ApplicationUserResponseHandler.generateResponse("Results Returned",HttpStatus.OK,user)
        }
        catch(IllegalArgumentException ignored)
        {
            return  ApplicationUserResponseHandler.generateResponse("Bad Request: Invalid Arguments ${id}",HttpStatus.BAD_REQUEST,[])
        }
        catch(NoResultException ignored)
        {
            return ApplicationUserResponseHandler.generateResponse("No Users found with ID ${id}",HttpStatus.NOT_FOUND,[])
        }
        catch(Exception ignored)
        {
            return  ApplicationUserResponseHandler.generateResponse("Bad Request: Internal Server Error",HttpStatus.BAD_REQUEST,[])
        }
    }

    @Override
    ResponseEntity<Object> saveUser(ApplicationUserDTO userDTO) {
        try{
            if(userDTO == null) throw new IllegalArgumentException("Invalid user argument")
            ApplicationUserDTO savedUserDTO = applicationUserDAO.saveApplicationUser(userDTO)
            ApplicationUserResponseHandler.generateResponse("Successfully saved new user",HttpStatus.OK,savedUserDTO)
        }
        catch(IllegalArgumentException | EntityExistsException ignored)
        {
            return  ApplicationUserResponseHandler.generateResponse("Bad Request: Save User with invalid arguments",HttpStatus.BAD_REQUEST,[])
        }
        catch(Exception ignored){
            return  ApplicationUserResponseHandler.generateResponse("Bad Request: Internal Server Error",HttpStatus.BAD_REQUEST,[])
        }
    }

    @Override
    ResponseEntity<Object> updateUser(ApplicationUserDTO userDTO) {
        try{
            if(userDTO == null) throw new IllegalArgumentException("Invalid user argument")
            ApplicationUserDTO updatedUserDTO = applicationUserDAO.updateApplicationUser(userDTO)
            ApplicationUserResponseHandler.generateResponse("Successfully updated new user",HttpStatus.OK,updatedUserDTO)
        }
        catch(IllegalArgumentException | EntityExistsException e)
        {
            return  ApplicationUserResponseHandler.generateResponse("Bad Request: Save User with invalid arguments",HttpStatus.BAD_REQUEST,[])
        }
        catch(Exception e){
            return  ApplicationUserResponseHandler.generateResponse("Bad Request: Internal Server Error",HttpStatus.BAD_REQUEST,[])
        }
    }

    @Override
    ResponseEntity<Object> deleteUser(ApplicationUserDTO userDTO) {
        try
        {
            applicationUserDAO.deleteApplicationUser(userDTO)
            ApplicationUserResponseHandler.generateResponse("Successfully deleted user", HttpStatus.OK, [])
        }
        catch(IllegalArgumentException | EntityExistsException e)
        {
            return  ApplicationUserResponseHandler.generateResponse("Bad Request: delete user with invalid arguments",HttpStatus.BAD_REQUEST,[])
        }
        catch(Exception e)
        {
            return  ApplicationUserResponseHandler.generateResponse("Bad Request: Internal Server Error",HttpStatus.BAD_REQUEST,[])
        }
    }

    @Override
    ResponseEntity<Object> deleteUserById(Long id) {
        try
        {
            if(Objects.isNull(id)) throw new IllegalArgumentException("Invalid user argument")
            applicationUserDAO.deleteApplicationUserById(id)
            ApplicationUserResponseHandler.generateResponse("Successfully deleted user with id ${id}", HttpStatus.OK, [])
        }
        catch(IllegalArgumentException | EntityExistsException e)
        {
            return  ApplicationUserResponseHandler.generateResponse("Bad Request: delete user with invalid arguments",HttpStatus.BAD_REQUEST,[])
        }
        catch(Exception e){
            return  ApplicationUserResponseHandler.generateResponse("Bad Request: Internal Server Error",HttpStatus.BAD_REQUEST,[])
        }
    }

}
