package com.BuyMore.UserServices.Controller

import com.BuyMore.UserServices.DTO.ApplicationUserDTO
import com.BuyMore.UserServices.Entity.ApplicationUser
import com.BuyMore.UserServices.Service.ApplicationUserService
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("/user")
class ApplicationUserController {

    private final ApplicationUserService applicationUserService
    private static final Logger log = LogManager.getLogger(ApplicationUserController.class)

    @Autowired
    ApplicationUserController(final ApplicationUserService applicationUserService) {
        this.applicationUserService = applicationUserService
    }

    @GetMapping("/")
    ResponseEntity<Object> findAll() {
        log.info("ApplicationUser Controller - request findAll")
        return applicationUserService.findAll()
    }

    @GetMapping("/{id}")
    ResponseEntity<Object> findById(@PathVariable(required = true, name = "id") String id) {
        log.info("ApplicationUser Controller - request findByID with params ${id}")
        return applicationUserService.findById(id)
    }

    @PostMapping("/save")
    ResponseEntity<Object> saveApplicationUser(@RequestBody ApplicationUserDTO userDTO)
    {
        log.info("ApplicationUser Controller - request saveApplicationUser")
        return applicationUserService.saveUser(userDTO)
    }

    @PutMapping('/update')
    ResponseEntity<Object> updateApplicationUser(@RequestBody ApplicationUser user)
    {
        log.info("ApplicationUser Controller - request updateApplicationUser")
        return applicationUserService.saveUser(user)
    }

    @DeleteMapping('/delete')
    ResponseEntity<Object> deleteApplicationUser(@RequestBody ApplicationUser user)
    {
        log.info("ApplicationUser Controller - request deleteApplicationUserById")
        return applicationUserService.deleteUser(user)
    }

    @DeleteMapping('/delete/{id}')
    ResponseEntity<Object> deleteApplicationUserById(@PathVariable(required = true, name = "id") String id)
    {
        log.info("ApplicationUser Controller - request deleteApplicationUserById with params ${id}")
        return applicationUserService.deleteUserById(id)
    }

}
