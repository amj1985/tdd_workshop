package com.example.tdd_workshop.application.usecase

import com.example.tdd_workshop.domain.Report
import com.example.tdd_workshop.domain.ReportsRepository
import com.nhaarman.mockito_kotlin.argumentCaptor
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.jupiter.api.Assertions.assertEquals

// TODO LIST
// Validar que la nota no pueda ser inferior a 0 -> OK
// Validar que el nombre no contiene numeros
// Validar que se llama al repositorio con los valores esperados

class SaveReportShould {
    @Test
    fun `throw when note is lower than zero` () {
        val saveReportCommand = SaveReportCommand("Adrià Manzano", -1)
        val reportsRepository = mock<ReportsRepository>()

        val saveReport = SaveReport(reportsRepository)

        assertThrows<IllegalArgumentException> {
            saveReport.execute(saveReportCommand)
        }
    }

    @Test
    fun `throw when name contains numbers` () {
        val saveReportCommand = SaveReportCommand("Adrià Manzano 2", 10)
        val reportsRepository = mock<ReportsRepository>()

        val saveReport = SaveReport(reportsRepository)

        assertThrows<IllegalArgumentException> {
            saveReport.execute(saveReportCommand)
        }
    }

    @Test
    fun `save student report` () {
        val saveReportCommand = SaveReportCommand("Adrià Manzano", 10)
        val reportsRepository = mock<ReportsRepository>()
        val saveReport = SaveReport(reportsRepository)
        val reportCaptor = argumentCaptor<Report>()

        saveReport.execute(saveReportCommand)

        verify(reportsRepository, times(1)).save(reportCaptor.capture())
        assertEquals(saveReportCommand.name, reportCaptor.firstValue.name)
        assertEquals(saveReportCommand.note, reportCaptor.firstValue.note)
    }
}