package com.example.tdd_workshop.domain.usecase

class SaveReport() {

    fun execute(saveReportCommand: SaveReportCommand) {
        if(saveReportCommand.notes < 0) {
            throw IllegalArgumentException("note cannot be lower than zero")
        }
        if(saveReportCommand.name.contains("[0-9]".toRegex())) {
            throw IllegalArgumentException("a name cannot contain numbers")
        }
    }
}

data class SaveReportCommand (val name: String, val notes: Int)
