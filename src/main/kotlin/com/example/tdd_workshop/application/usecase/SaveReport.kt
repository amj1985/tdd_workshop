package com.example.tdd_workshop.application.usecase

import com.example.tdd_workshop.domain.Report
import com.example.tdd_workshop.domain.ReportsRepository

class SaveReport(private val saveReportRepository: ReportsRepository) {

    fun execute(saveReportCommand: SaveReportCommand) {
        TODO("Missing implementation")
    }
}

data class SaveReportCommand (val name: String, val note: Int)
