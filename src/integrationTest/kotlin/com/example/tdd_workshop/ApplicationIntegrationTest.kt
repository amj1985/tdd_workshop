package com.example.tdd_workshop

import com.example.tdd_workshop.infrastructure.helper.DockerComposeHelper
import io.restassured.module.mockmvc.RestAssuredMockMvc
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
@SpringBootTest(
    classes = [Application::class],
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ActiveProfiles("test")
@AutoConfigureMockMvc
class ApplicationIntegrationTest {

    @Autowired
    lateinit var mvc: MockMvc

    companion object {

        @Container
        private val dockerComposeContainer = DockerComposeHelper.create()

        @BeforeAll
        @JvmStatic
        fun setSystemProperties() {
            DockerComposeHelper.setSystemProperties(dockerComposeContainer)
        }
    }

    @BeforeEach
    fun setUp() {
        RestAssuredMockMvc.mockMvc(mvc)
    }

}
