package com.app.scentshelf.models;

import com.app.scentshelf.models.enums.NoteType;

import lombok.*;

@Getter
@Setter
public class NoteDTO {
    private Long id;

    private Long fragranceId;

    private Long scentId;

    private NoteType noteType;
}
