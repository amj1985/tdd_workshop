package com.example.tdd_workshop

import com.example.tdd_workshop.helper.DockerComposeHelper
import io.restassured.module.mockmvc.RestAssuredMockMvc
import org.junit.Assert
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
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
    properties = ["spring.profiles.active=integration-test"],
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
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
