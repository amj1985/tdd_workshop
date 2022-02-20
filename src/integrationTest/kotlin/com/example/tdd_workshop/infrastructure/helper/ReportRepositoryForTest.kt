package com.example.tdd_workshop.infrastructure.helper

import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate

class ReportRepositoryForTest(private val jdbcTemplate: NamedParameterJdbcTemplate) {
    fun existsReportByName(name : String) : Boolean {
        val query =
            """
          SELECT COUNT(1)
          FROM reports
          WHERE name = :name
        """

        val namedParameters = MapSqlParameterSource()

        namedParameters.addValue("name", name)

        return try {
            val count = jdbcTemplate.queryForObject(query, namedParameters, Int::class.java)
            count == 1
        } catch (e: EmptyResultDataAccessException) {
            false
        }
    }
}