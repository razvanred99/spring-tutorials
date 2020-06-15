package ro.razvan.spring.testingweb

import org.assertj.core.api.Assertions.assertThat
import org.hamcrest.CoreMatchers.containsString
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class TestingWebApplicationTest {

    @Autowired
    private lateinit var homeController: HomeController

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun contextLoads() {
        assertThat(homeController).isNotNull
    }

    @Test
    fun shouldReturnDefaultMessage() {
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk)
                .andExpect(content().string(containsString("Hello, World!")))
    }
}