package ro.razvan.spring.quickstart

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForObject
import org.springframework.boot.web.server.LocalServerPort

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HttpRequestTest {

    @LocalServerPort
    private var port: Int = -1

    @Autowired
    private lateinit var restTemplate: TestRestTemplate

    @Test
    fun `hello with name param should return "Hello name!"`() {
        assertThat(restTemplate.getForObject<String>("http://localhost:$port/hello?name=Emma"))
                .contains("Hello Emma!")
    }

    @Test
    fun `hello with no params should return "Hello World!"`() {
        assertThat(restTemplate.getForObject<String>("http://localhost:$port/hello"))
                .contains("Hello World!")
    }
}