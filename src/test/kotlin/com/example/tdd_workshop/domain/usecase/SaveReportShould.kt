package com.example.tdd_workshop.domain.usecase

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

// TODO LIST
// Validar que la nota no pueda ser inferior a 0 -> OK
// Validar que el nombre no contiene numeros
// Validar que se llama al repositorio con los valores esperados

class SaveReportShould {
    @Test
    fun `throw when note is lower than zero` () {
        val saveReportCommand = SaveReportCommand("Adrià Manzano", -1)
        val saveReport = SaveReport()
        assertThrows<IllegalArgumentException> {
            saveReport.execute(saveReportCommand)
        }
    }

    @Test
    fun `throw when name contains numbers` () {
        val saveReportCommand = SaveReportCommand("Adrià Manzano 2", 10)
        val saveReport = SaveReport()
        assertThrows<IllegalArgumentException> {
            saveReport.execute(saveReportCommand)
        }
    }
}