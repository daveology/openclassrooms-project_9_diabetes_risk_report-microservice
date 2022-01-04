package com.mediscreen.service;

import com.mediscreen.model.Note;
import com.mediscreen.model.Report;
import com.mediscreen.service.ReportService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReportServiceTests {

    @Autowired
    private ReportService reportService;

    @Test
    public void shouldGetTriggersCount() {

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
        Note thirdNote = new Note(secondNote.getNoteId(),
                secondNote.getPatientId(),
                secondNote.getNoteDate(),
                secondNote.getContent());
        thirdNote.setContent("Poids");
        noteList.add(thirdNote);

        assertEquals(3, reportService.getTriggersCount(noteList));
    }

    @Test
    public void shouldGetReport() {

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
        String actual = reportService.getReport("Harry Potter", 50, "M", noteList);
        String expected = "Patient: Test Harry Potter (age 50) diabetes assessment is: BORDERLINE";

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetGenerateReport() {

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

        String actual = reportService.generateReport(50, "M", noteList);
        String expected = Report.BORDERLINE.toString();

        assertEquals(expected, actual);
    }
}
