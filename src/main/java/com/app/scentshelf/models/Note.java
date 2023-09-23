package com.app.scentshelf.models;


import com.app.scentshelf.models.enums.NoteType;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor // <--- THIS is it
@Table(name = "note")
public class Note {

    //https://www.baeldung.com/jpa-join-column
    //https://www.geeksforgeeks.org/when-to-use-joincolumn-annotation-in-hibernate/#
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "note_pk")
    private Long id;

    ////@Id//@many to one represents many (this entity) to another entity one (fragrance)
    @ManyToOne //many scent to ONE fragrance, ex. fragrance notes in top, middle, and base but a fragrance only has one set of these
    @JoinColumn(name = "fragrance_id", nullable = false) ////join column used to represent relationship between two entities, fragrance_id is the fk referencing back to the Fragrance table
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Fragrance fragrance;

    //@Id
    @ManyToOne //many fragrancescent to One scent , ex. bergamot in top, middle, and base but only One bergamont scent
    @JoinColumn(name = "scent_id", nullable = false)
    private Scent scent;

    @Enumerated(EnumType.STRING)
    @Column(name = "note_type")
    private NoteType noteType;

    public Note(Long id, Fragrance fragrance, Scent scent, NoteType type) {
        this.id = id;
        this.fragrance = fragrance;
        this.scent = scent;
        this.noteType = type;
    }


    public Long getId() {
        return this.id;
    }

    public Note id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NoteType getNoteType() {
        return this.noteType;
    }

    public Note noteType(NoteType noteType) {
        this.setNoteType(noteType);
        return this;
    }

    public void setNoteType(NoteType noteType) {
        this.noteType = noteType;
    }

    public Fragrance getFragrance() {
        return this.fragrance;
    }

    public void setFragrance(Fragrance fragrance) {
        this.fragrance = fragrance;
    }

    public Note fragrance(Fragrance fragrance) {
        this.setFragrance(fragrance);
        return this;
    }

    public Scent getScent() {
        return this.scent;
    }

    public void setScent(Scent scent) {
        this.scent = scent;
    }

    public Note scent(Scent scent) {
        this.setScent(scent);
        return this;
    }


}