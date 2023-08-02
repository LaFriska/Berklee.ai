package com.friska.jnotes.core.chords;

import com.friska.jnotes.core.LilyCode;
import com.friska.jnotes.core.notes.Note;
import com.friska.jnotes.debug.MissingJavadoc;

@MissingJavadoc
public record CompiledChord(String spelling, Note[] notes) implements LilyCode {
    public Note getNote(int i){
        return notes[i];
    }
    @Override
    public String getLilyCode() {
        return getLily(notes);
    }
}