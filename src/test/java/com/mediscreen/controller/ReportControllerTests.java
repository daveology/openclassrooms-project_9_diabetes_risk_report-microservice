package com.mediscreen.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mediscreen.dto.ReportEntriesDto;
import com.mediscreen.model.Note;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ReportControllerTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ReportController reportController;

    @Test
    public void shouldGenerateReport() throws Exception {

        Collection<Note> noteList = new ArrayList<>();
        Note firstNote = new Note();
        firstNote.setNoteId(99L);
        firstNote.setPatientId(99L);
        firstNote.setNoteDate(LocalDate.now());
        firstNote.setContent("Hémoglobine A1C");
        noteList.add(firstNote);
        Note secondNote = new Note();
        secondNote.setNoteId(firstNote.getNoteId());
        secondNote.setPatientId(firstNote.getPatientId());
        secondNote.setNoteDate(firstNote.getNoteDate());
        secondNote.setContent(firstNote.getContent() + " Hémoglobine A1C");
        secondNote.setContent("Microalbumine A1C");
        noteList.add(secondNote);

        ReportEntriesDto report = new ReportEntriesDto();
        report.setPatientId(99L);
        report.setFullName("Harry Potter");
        report.setAge(50);
        report.setGender("M");
        report.setNoteList(noteList);

        mockMvc.perform(post("/generateReport")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(report))
        ).andExpect(status().isOk());
    }

    @Test
    public void shouldGetReport() throws Exception {

        Collection<Note> noteList = new ArrayList<>();
        Note firstNote = new Note();
        firstNote.setNoteId(99L);
        firstNote.setPatientId(99L);
        firstNote.setNoteDate(LocalDate.now());
        firstNote.setContent("Hémoglobine A1C");
        noteList.add(firstNote);
        Note secondNote = new Note();
        secondNote.setNoteId(firstNote.getNoteId());
        secondNote.setPatientId(firstNote.getPatientId());
        secondNote.setNoteDate(firstNote.getNoteDate());
        secondNote.setContent(firstNote.getContent() + " Hémoglobine A1C");
        secondNote.setContent("Microalbumine A1C");
        noteList.add(secondNote);

        ReportEntriesDto report = new ReportEntriesDto();
        report.setPatientId(99L);
        report.setFullName("Harry Potter");
        report.setAge(50);
        report.setGender("M");
        report.setNoteList(noteList);

        mockMvc.perform(post("/getReport")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(report))
        ).andExpect(status().isOk());
    }
}
