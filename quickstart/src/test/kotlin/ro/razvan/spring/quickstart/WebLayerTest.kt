package ro.razvan.spring.quickstart

import org.hamcrest.CoreMatchers.containsString
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class WebLayerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `hello with name param should return "Hello name!"`() {
        mockMvc.perform(get("/hello?name=Madalina"))
                .andExpect(status().isOk)
                .andExpect(content().string(containsString("Hello Madalina!")))
    }
}