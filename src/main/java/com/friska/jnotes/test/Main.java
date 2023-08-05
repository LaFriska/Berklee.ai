package com.friska.jnotes.test;

import com.friska.jnotes.core.keys.Key;
import com.friska.jnotes.core.keys.KeyQualities;
import com.friska.jnotes.core.notes.Note;
import com.friska.jnotes.core.notes.Notes;
import com.friska.jnotes.test.testutil.Test;

public class Main {

    public static final Test test = new Test();

    public static void main(String[] args) {
        Key key = new Key(Notes.G_FLAT, KeyQualities.major());
        Note[] notes = key.getScaleDegrees();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= notes.length - 1; i++){
            sb.append(notes[i].getSpelling()).append(" ");
        }
        System.out.println(sb);
    }
    private static void runTest(){
        NotesTest.comparison();
        NotesTest.pitch();
        NotesTest.misc();
        IntervalsTest.values();
        IntervalsTest.noteFinder();
        ChordTest.tones();
        test.run();
    }
}
