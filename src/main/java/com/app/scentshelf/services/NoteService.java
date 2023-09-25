package com.app.scentshelf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.scentshelf.models.Fragrance;
import com.app.scentshelf.models.Note;
import com.app.scentshelf.models.Scent;
import com.app.scentshelf.models.enums.NoteType;
import com.app.scentshelf.repositories.FragranceRepository;
import com.app.scentshelf.repositories.NoteRepository;
import com.app.scentshelf.repositories.ScentRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class NoteService {

    private final NoteRepository repository;
    private final FragranceRepository fragranceRepository;
    private final ScentRepository scentRepository;

    @Autowired
    public NoteService(NoteRepository repository, FragranceRepository fragranceRepository, ScentRepository scentRepository) {
        this.repository = repository;
        this.fragranceRepository = fragranceRepository;
        this.scentRepository = scentRepository;
    }

    public List<Note> getAllEntities() {
        return repository.findAll();
    }

    public Note get(Long id) {
        return repository.findById(id).get();
    }

    // public Note createNote(Note note) {
    //     return repository.save(note);
    // }

    // public Note createNote(Long fragranceId, Long scentId, NoteType noteType) {
    // // Fetch the Fragrance and Scent from the database
    // Fragrance fragrance = fragranceRepository.findById(fragranceId)
    //     .orElseThrow(() -> new EntityNotFoundException("Fragrance with ID " + fragranceId + " not found."));
    // Scent scent = scentRepository.findById(scentId)
    //     .orElseThrow(() -> new EntityNotFoundException("Scent with ID " + scentId + " not found."));

    // // Create a new Note and set its relationships
    // Note note = new Note();
    // note.setFragrance(fragrance);
    // note.setScent(scent);
    // note.setNoteType(noteType);

    // // Save and return the Note
    // return repository.save(note);
    // }

    public Note createNote(Note note) {
        Fragrance fragrance = fragranceRepository.findById(note.getFragrance().getId())
            .orElseThrow(() -> new EntityNotFoundException("Fragrance with ID " + note.getFragrance().getId() + " not found."));
        
        Scent scent = scentRepository.findById(note.getScent().getId())
            .orElseThrow(() -> new EntityNotFoundException("Scent with ID " + note.getScent().getId() + " not found."));

        note.setFragrance(fragrance);
        note.setScent(scent);
        return repository.save(note);
    }
}
