package jnotes.test;

import jnotes.core.notes.Alteration;
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
        test.run();
    }
}
