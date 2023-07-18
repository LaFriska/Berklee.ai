package jnotes.test;

import jnotes.core.notes.Notes;
import jnotes.test.testutil.Test;

public class Main {

    public static final Test test = new Test();

    public static void main(String[] args) {

        NotesTest.enharmonicSuite();

        test.run();
    }
}
