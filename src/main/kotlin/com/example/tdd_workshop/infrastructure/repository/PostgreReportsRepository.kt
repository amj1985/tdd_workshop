package com.example.tdd_workshop.infrastructure.repository

import com.example.tdd_workshop.domain.Report
import com.example.tdd_workshop.domain.ReportsRepository
import org.springframework.dao.DataAccessException
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate

class PostgreReportsRepository(private val jdbcTemplate: NamedParameterJdbcTemplate) : ReportsRepository {
    override fun save(report: Report) {
        val sql =
            """
            INSERT INTO reports(
                name,
                note
            )
            VALUES(
                :name,
                :note
            )
        """

        val namedParameters = MapSqlParameterSource()
        namedParameters.addValue("name", report.name)
        namedParameters.addValue("note", report.note)

        try {
            jdbcTemplate.update(sql, namedParameters)
        } catch (exception: DataAccessException) {
            throw exception
        }
    }
}