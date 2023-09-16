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
    @ManyToOne //many fragrance scent to ONE fragrance, ex. fragrance notes in top, middle, and base but a fragrance only has one set of these
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

}