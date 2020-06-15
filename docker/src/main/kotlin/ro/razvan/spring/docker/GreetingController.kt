package ro.razvan.spring.docker

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController {

    @GetMapping("/hello")
    fun sayWorld(): String = "World"
}