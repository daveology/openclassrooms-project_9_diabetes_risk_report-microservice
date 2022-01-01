package com.mediscreen.controller;

import com.mediscreen.model.Note;
import com.mediscreen.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/generateReport")
    public String generateReport(@RequestBody Collection<Note> noteList) {

        return reportService.generateReport(noteList);
    }
}
