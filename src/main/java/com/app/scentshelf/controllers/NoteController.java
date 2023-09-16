package com.app.scentshelf.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.scentshelf.models.Note;
import com.app.scentshelf.services.NoteService;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    NoteService service;

    @Autowired
    NoteController(NoteService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Note>> getPersonList() {

        return new ResponseEntity<List<Note>>(service.getAllEntities() , HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Note> show(@PathVariable("id") Long id) {
//        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
//    }
}
