package com.example.tdd_workshop.infrastructure.controller

import com.example.tdd_workshop.application.usecase.SaveReport
import com.example.tdd_workshop.application.usecase.SaveReportCommand
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class SaveReportController(private val saveReport: SaveReport) {
    @PostMapping("/reports/save")
    fun saveReport(@RequestBody saveReportRequest : SaveReportRequest) : ResponseEntity<Unit> {
        return try{
            saveReport.execute(SaveReportCommand(saveReportRequest.name, saveReportRequest.note))
            ResponseEntity.status(HttpStatus.OK).build()
        }
        catch(e: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
        }
    }
}