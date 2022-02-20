package com.example.tdd_workshop.application.usecase

import com.example.tdd_workshop.domain.Report
import com.example.tdd_workshop.domain.ReportsRepository

class SaveReport(private val saveReportRepository: ReportsRepository) {

    fun execute(saveReportCommand: SaveReportCommand) {
        if(saveReportCommand.note < 0) {
            throw IllegalArgumentException("note cannot be lower than zero")
        }
        if(saveReportCommand.name.contains("[0-9]".toRegex())) {
            throw IllegalArgumentException("a name cannot contain numbers")
        }

        saveReportRepository.save(Report(saveReportCommand.name, saveReportCommand.note))
    }
}

data class SaveReportCommand (val name: String, val note: Int)
