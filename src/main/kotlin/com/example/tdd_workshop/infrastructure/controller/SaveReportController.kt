package com.example.tdd_workshop.infrastructure.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class SaveReportController {
    @PostMapping("/reports/save")
    fun saveReport(@RequestBody saveReportRequest : SaveReportRequest) : ResponseEntity<Unit> {
        return ResponseEntity.status(HttpStatus.OK).build()
    }
}