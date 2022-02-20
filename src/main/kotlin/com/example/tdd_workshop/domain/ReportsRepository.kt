package com.example.tdd_workshop.domain

interface ReportsRepository {
    fun save(report: Report)
}