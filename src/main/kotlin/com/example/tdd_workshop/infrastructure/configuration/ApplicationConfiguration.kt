package com.example.tdd_workshop.infrastructure.configuration

import com.example.tdd_workshop.application.usecase.SaveReport
import com.example.tdd_workshop.domain.ReportsRepository
import com.example.tdd_workshop.infrastructure.repository.PostgreReportsRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate

@Configuration
class ApplicationConfiguration {
    @Bean
    fun saveReport(reportsRepository: ReportsRepository) :
            SaveReport = SaveReport(reportsRepository)

    @Bean
    fun reportsRepository(namedParameterJdbcTemplate: NamedParameterJdbcTemplate) :
            ReportsRepository = PostgreReportsRepository(namedParameterJdbcTemplate)
}