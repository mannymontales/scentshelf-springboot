package com.app.scentshelf.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.scentshelf.models.Fragrance;
import com.app.scentshelf.services.FragranceService;

@RestController
@RequestMapping("/api/fragrance")
@CrossOrigin
public class FragranceController {

    //https://stackoverflow.com/questions/671118/what-exactly-is-restful-programming

    FragranceService fragranceService;

    @Autowired
    FragranceController(FragranceService fragranceService) {
        this.fragranceService = fragranceService;
    }

    @GetMapping()
    public ResponseEntity<List<Fragrance>> getPersonList() {

        return new ResponseEntity<List<Fragrance>>(fragranceService.getAllEntities() , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fragrance> show(@PathVariable("id") Long id) {
        return new ResponseEntity<>(fragranceService.get(id), HttpStatus.OK);
    }

    //cant do multiple post at once need to create endpoint that takes in multiple fragrances
    @PostMapping(value = "/example", consumes = {"application/json"})
    public ResponseEntity<Fragrance> create(@RequestBody Fragrance fragrance) {
        return new ResponseEntity<>(fragranceService.createFragrance(fragrance), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fragrance> update(@PathVariable Long id, @RequestBody Fragrance updatedFragrance) {
        return new ResponseEntity<>(fragranceService.updateFragrance(id, updatedFragrance), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return new ResponseEntity<>(fragranceService.deleteFragrance(id), HttpStatus.OK);
    }
}
