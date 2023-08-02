package com.friska.jnotes.test;

import com.friska.jnotes.core.chords.Chord;
import com.friska.jnotes.core.chords.ChordQualities;
import com.friska.jnotes.core.chords.ChordQuality;
import com.friska.jnotes.core.chords.CompiledChord;
import com.friska.jnotes.core.notes.Notes;
import com.friska.jnotes.test.testutil.Test;

import java.util.LinkedList;
import java.util.Random;

public class Main {

    public static final Test test = new Test();

    public static void main(String[] args) {
        runTest();
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
