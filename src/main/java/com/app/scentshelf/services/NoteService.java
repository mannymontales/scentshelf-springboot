package com.app.scentshelf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.scentshelf.models.Note;
import com.app.scentshelf.repositories.NoteRepository;

@Service
public class NoteService {

    private final NoteRepository repository;

    @Autowired
    public NoteService(NoteRepository repository) {
        this.repository = repository;
    }

    public List<Note> getAllEntities() {
        return repository.findAll();
    }

    public Note get(Long id) {
        return repository.findById(id).get();
    }

    public Note createNote(Note note) {
        return repository.save(note);
    }
}
