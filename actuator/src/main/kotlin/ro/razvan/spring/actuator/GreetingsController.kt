package ro.razvan.spring.actuator

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingsController {

    companion object {
        private const val HELLO_FORMAT = "Hello, %s!"
    }

    private val counter = AtomicLong(0)

    @GetMapping("/hello")
    fun sayHello(@RequestParam(value = "name", defaultValue = "World") name: String): Greeting =
            Greeting(id = counter.incrementAndGet(), content = String.format(HELLO_FORMAT, name))
}