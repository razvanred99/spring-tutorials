package ro.razvan.spring.restservice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {

    companion object {
        private const val template = "Hello, %s!"
    }

    private val counter = AtomicLong(0)

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String): Greeting =
            Greeting(counter.getAndIncrement(), String.format(template, name))

}