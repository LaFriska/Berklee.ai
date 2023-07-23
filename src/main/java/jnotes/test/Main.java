package jnotes.test;

import jnotes.core.notes.Alteration;
import jnotes.core.notes.BaseNote;
import jnotes.core.notes.Note;
import jnotes.test.testutil.Test;

public class Main {

    public static final Test test = new Test();

    public static void main(String[] args) {
        runTest();
    }

    private static void runTest(){
        NotesTest.comparison();
        NotesTest.pitch();
        NotesTest.pitch();
        IntervalsTest.values();
        test.run();
    }
}
