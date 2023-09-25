package com.app.scentshelf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.scentshelf.models.Fragrance;
import com.app.scentshelf.models.Note;
import com.app.scentshelf.models.NoteDTO;
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

    public Note createNote(NoteDTO noteDTO) {
        Fragrance fragrance = fragranceRepository.findById(noteDTO.getFragranceId())
                .orElseThrow(() -> new EntityNotFoundException("Fragrance not found"));
        
        Scent scent = scentRepository.findById(noteDTO.getScentId())
                .orElseThrow(() -> new EntityNotFoundException("Scent not found"));

        Note note = new Note();
        note.setFragrance(fragrance);
        note.setScent(scent);
        note.setNoteType(noteDTO.getNoteType());

        return repository.save(note);
    }
}
