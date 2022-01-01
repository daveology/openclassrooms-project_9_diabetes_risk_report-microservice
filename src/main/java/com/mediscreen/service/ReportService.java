package com.mediscreen.service;

import com.mediscreen.model.Note;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ReportService {

    public String generateReport(Collection<Note> noteList) {

        Set<String> triggers = new HashSet<>(Arrays.asList(
                "Hémoglobine A1C",
                "Microalbumine",
                "Taille",
                "Poids",
                "Fumeur",
                "Anormal",
                "Cholestérol",
                "Vertige",
                "Rechute",
                "Réaction",
                "Anticorps"
        ));

        return "";
    }
}
