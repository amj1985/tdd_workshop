package com.example.tdd_workshop.acceptance

import com.example.tdd_workshop.ApplicationIntegrationTest
import com.example.tdd_workshop.infrastructure.helper.ReportRepositoryForTest
import io.restassured.module.mockmvc.RestAssuredMockMvc.given
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.util.Assert
import java.net.HttpURLConnection

class SaveReportFeature : ApplicationIntegrationTest() {

    @Autowired
    private lateinit var reportsRepositoryForTest : ReportRepositoryForTest

    @Test
    fun `save student report`() {
        val name = "Adria Manzano"
        val note = 10

        given()
            .contentType("application/json")
            .body("{ \"name\": \"$name\", \"note\": $note }")
            .post("/reports/save")
            .then()
            .statusCode(HttpURLConnection.HTTP_OK)

        Assert.isTrue(reportsRepositoryForTest.existsReportByName(name))
    }
}