package com.mediscreen.controller;

import com.mediscreen.model.Note;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {

    @GetMapping("/generateReport")
    public String generateReport(@RequestBody Collection<Note> noteList) {

        return patientReadService.generateReport(noteList);
    }
}
