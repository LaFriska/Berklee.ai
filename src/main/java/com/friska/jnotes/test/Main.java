package com.friska.jnotes.test;

import com.friska.jnotes.test.testutil.Test;

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
