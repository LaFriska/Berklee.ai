package jnotes.test;

import jnotes.core.notes.Notes;
import jnotes.test.testutil.Test;

public class Main {

    public static final Test test = new Test();

    public static void main(String[] args) {

        runTest();

    }

    private static float getHerz(int x){
        return (float) (16.351597831287414 * Math.pow(2, (float) x / 12));
    }

    private static void runTest(){
        NotesTest.comparison();
        NotesTest.pitch();
        test.run();
    }
}
