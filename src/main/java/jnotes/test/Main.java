package jnotes.test;

import jnotes.core.notes.Alteration;
import jnotes.core.notes.BaseNote;
import jnotes.core.notes.Note;
import jnotes.core.notes.Notes;
import jnotes.test.testutil.Test;

public class Main {

    public static final Test test = new Test();

    public static void main(String[] args) {
        runTest();
        //System.out.println(Notes.A.setOctave(0).getBaseNoteLabel());
    }

    private static void runTest(){
        NotesTest.comparison();
        NotesTest.pitch();
        NotesTest.misc();
        IntervalsTest.values();
        IntervalsTest.noteFinder();
        test.run();
    }
}
