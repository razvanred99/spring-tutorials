package ro.razvan.spring.testingweb

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForObject

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class HttpRequestTest {

    @LocalServerPort
    private var port: Int = -1

    @Autowired
    private lateinit var restTemplate: TestRestTemplate

    @Test
    fun `greeting should return default message`() {
        assertThat(
                restTemplate.getForObject<String>("http://localhost:$port/")
        ).contains("Hello, World!")
    }

}