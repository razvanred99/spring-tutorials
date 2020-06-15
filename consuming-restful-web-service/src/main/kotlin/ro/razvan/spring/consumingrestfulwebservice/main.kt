package ro.razvan.spring.consumingrestfulwebservice

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject

@SpringBootApplication
class ConsumingRestfulWebServiceApplication {

    companion object {
        private val log: Logger = LoggerFactory.getLogger(ConsumingRestfulWebServiceApplication::class.java)
    }

    @Bean
    fun restTemplate(builder: RestTemplateBuilder): RestTemplate =
            builder.build()

    @Bean
    fun run(restTemplate: RestTemplate): CommandLineRunner = CommandLineRunner {
        val quote: Quote = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random")
        log.info(quote.toString())
    }
}

fun main(args: Array<String>) {
    runApplication<ConsumingRestfulWebServiceApplication>(*args)
}