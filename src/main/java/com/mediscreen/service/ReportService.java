package com.mediscreen.service;

import com.mediscreen.model.Note;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReportService {

    public String generateReport(Collection<Note> noteList) {

        Long triggersCount = getTriggersCount(noteList);

        return "";
    }

    public Long getTriggersCount(Collection<Note> noteList) {

        HashMap<String, Boolean> triggers = new HashMap<>();
        triggers.put("Hémoglobine A1C", false);
        triggers.put("Microalbumine A1C", false);
        triggers.put("Taille A1C", false);
        triggers.put("Poids", false);
        triggers.put("Fumeur", false);
        triggers.put("Anormal", false);
        triggers.put("Cholestérol", false);
        triggers.put("Vertige", false);
        triggers.put("Rechute", false);
        triggers.put("Réaction", false);
        triggers.put("Anticorps", false);

        noteList.stream().forEach(note -> {
            triggers.forEach((key, value) -> {
                if (note.getContent().contains(key)) { value = true; }
            });
        });

        Long triggersCount = triggers.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == true)
                .count();

        return triggersCount;
    }
}
