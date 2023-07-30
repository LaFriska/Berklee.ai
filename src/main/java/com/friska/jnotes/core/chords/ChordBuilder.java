package com.friska.jnotes.core.chords;

import com.friska.jnotes.core.notes.Note;
import com.friska.jnotes.debug.MissingJavadoc;

@MissingJavadoc
public class ChordBuilder{

    private final Note root;
    private final ChordQuality quality;

    public ChordBuilder(Note rootNote, ChordQuality chordQuality){
        this.root = rootNote;
        this.quality = chordQuality;
    }

    public ChordBuilder sus4(){
        quality.sus4();
        return this;
    }

    public ChordBuilder sus2(){
        quality.sus2();
        return this;
    }

}
