package com.app.scentshelf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.scentshelf.models.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {
}

