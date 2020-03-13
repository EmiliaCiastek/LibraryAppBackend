package com.ciastek.librarybackend

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class SimpleController {

    @RequestMapping(method = [RequestMethod.GET])
    fun index(): String {
        return "Greetings from Spring Boot!"
    }
}