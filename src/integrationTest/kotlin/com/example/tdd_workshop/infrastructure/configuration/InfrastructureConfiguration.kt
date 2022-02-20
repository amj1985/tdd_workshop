package com.example.tdd_workshop.infrastructure.configuration

import com.example.tdd_workshop.infrastructure.helper.ReportRepositoryForTest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.test.context.ActiveProfiles

@Configuration
@ActiveProfiles("test")
class InfrastructureConfiguration {
    @Bean
    fun reportsRepositoryForTest(namedParameterJdbcTemplate: NamedParameterJdbcTemplate)
    : ReportRepositoryForTest = ReportRepositoryForTest(namedParameterJdbcTemplate)
}