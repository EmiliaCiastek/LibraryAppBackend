package com.ciastek.librarybackend

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SimpleController {

    @RequestMapping("/")
    fun index(): String {
        return "Greetings from Spring Boot!"
    }
}