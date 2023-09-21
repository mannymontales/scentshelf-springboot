package com.app.scentshelf.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.scentshelf.models.Fragrance;
import com.app.scentshelf.models.Scent;
import com.app.scentshelf.services.ScentService;

@RestController
@RequestMapping("/api/scent")
@CrossOrigin
public class ScentController {

    ScentService service;

    @Autowired
    ScentController(ScentService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Scent>> getPersonList() {

        return new ResponseEntity<List<Scent>>(service.getAllEntities() , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Scent> show(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }
    
    @PostMapping(value = "/", consumes = {"application/json"})
    public ResponseEntity<Scent> create(@RequestBody Scent scent) {
        return new ResponseEntity<>(service.createScent(scent), HttpStatus.CREATED);
    }
}