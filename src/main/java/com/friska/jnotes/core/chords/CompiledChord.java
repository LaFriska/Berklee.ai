package com.friska.jnotes.core.chords;

import com.friska.jnotes.core.LilyCode;
import com.friska.jnotes.core.notes.Note;

/**
 * This object encapsulates the data needed to represent the actualised notes and spelling of a chord.
 * A note array is to represent every chord tone or tension in the chord, and a String for the chord spelling.
 * */
public record CompiledChord(String spelling, Note[] notes) implements LilyCode {
    public Note getNote(int i){
        return notes[i];
    }
    @Override
    public String getLilyCode() {
        return getLilyFromNote(notes);
    }
}