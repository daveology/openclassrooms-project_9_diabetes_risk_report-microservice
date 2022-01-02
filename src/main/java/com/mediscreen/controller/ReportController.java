package com.mediscreen.controller;

import com.mediscreen.dto.ReportEntriesDto;
import com.mediscreen.model.Note;
import com.mediscreen.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping("/generateReport")
    public String generateReport(@RequestBody ReportEntriesDto entries) {

        Collection<Note> noteList = new ArrayList<>();
        if (noteList != null) {noteList.addAll(noteList);}
        String result = reportService.generateReport(entries.getAge(), entries.getGender(), noteList);
        return result;
    }
}
