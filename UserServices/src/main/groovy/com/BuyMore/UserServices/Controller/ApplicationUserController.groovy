package com.BuyMore.UserServices.Controller

import com.BuyMore.UserServices.Service.ApplicationUserService
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("/user")
class ApplicationUserController {

    @Autowired
    ApplicationUserService applicationUserService
    private static final Logger log = LogManager.getLogger(ApplicationUserController.class)

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

}
