package com.app.scentshelf.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor // <--- THIS is it
@Table(name = "Scent")
public class Scent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "scent_id")
    private Long id; // scent_id

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "scent")
    @JsonManagedReference
    private List<Note> notes = new ArrayList<>();

    //make sure to validate existing scent name when user inputs stuff for the future
    public Scent(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}