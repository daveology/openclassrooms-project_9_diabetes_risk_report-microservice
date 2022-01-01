package com.mediscreen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {

    @GetMapping("/generateReport")
    public String generateReport(@RequestBody Collection<Note> noteList) {

        return patientReadService.generateReport(noteList);
    }
}
