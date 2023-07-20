package jnotes.test;

import jnotes.core.intervals.Interval;
import jnotes.core.intervals.IntervalQuality;
import jnotes.core.notes.Alteration;
import jnotes.core.notes.Note;
import jnotes.core.notes.NoteBase;
import jnotes.core.notes.Notes;
import jnotes.test.testutil.Test;

import java.util.AbstractList;

public class Main {

    public static final Test test = new Test();

    public static void main(String[] args) {

        runTest();

    }

    private static void runTest(){
        NotesTest.comparison();
        NotesTest.pitch();
        IntervalsTest.values();
        test.run();
    }
}
