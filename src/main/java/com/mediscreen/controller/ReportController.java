package com.mediscreen.controller;

import com.mediscreen.dto.ReportEntriesDto;
import com.mediscreen.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping("/generateReport")
    public String generateReport(@RequestBody ReportEntriesDto entries) {

        return reportService.generateReport(entries.getAge(), entries.getGender(), entries.getNoteList());
    }
}
