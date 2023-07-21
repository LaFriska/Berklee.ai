package jnotes.test;

import jnotes.core.intervals.Interval;
import jnotes.core.notes.Note;
import jnotes.core.notes.Notes;
import jnotes.test.testutil.Test;

public class Main {

    public static final Test test = new Test();

    public static void main(String[] args) {

    }

    private static void runTest(){
        NotesTest.comparison();
        NotesTest.pitch();
        IntervalsTest.values();
        test.run();
    }
}
