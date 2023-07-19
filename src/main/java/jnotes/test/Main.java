package jnotes.test;

import jnotes.core.notes.Alteration;
import jnotes.core.notes.NoteBase;
import jnotes.core.util.NoteUtils;
import jnotes.test.testutil.Test;

import java.util.AbstractList;

public class Main {

    public static final Test test = new Test();

    public static void main(String[] args) {


        System.out.println(NoteUtils.getBaseNoteNumber(2, 10, NoteBase.A));

        //runTest();

    }

    private static void runTest(){
        NotesTest.comparison();
        NotesTest.pitch();
        test.run();
    }
}
