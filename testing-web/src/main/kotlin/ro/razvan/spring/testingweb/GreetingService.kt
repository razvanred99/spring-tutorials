package ro.razvan.spring.testingweb

import org.springframework.stereotype.Service

@Service
class GreetingService {

    fun greet(): String = "Hello, World!"
}