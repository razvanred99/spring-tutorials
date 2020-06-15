package ro.razvan.spring.testingweb

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HomeController {

    @RequestMapping("/")
    @GetMapping
    @ResponseBody
    fun greeting(): String =
            "Hello, World!"

}