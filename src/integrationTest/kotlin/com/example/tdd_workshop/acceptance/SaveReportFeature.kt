package com.example.tdd_workshop.acceptance

import com.example.tdd_workshop.ApplicationIntegrationTest
import io.restassured.module.mockmvc.RestAssuredMockMvc.given
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.net.HttpURLConnection

class SaveReportFeature : ApplicationIntegrationTest() {
    @Test
    fun `save student report`() {
        given()
            .contentType("application/json")
            .body("{ \"name\": \"Adria Manzano\", \"note\": 10 }")
            .post("/reports/save")
            .then()
            .statusCode(HttpURLConnection.HTTP_OK)
    }
}