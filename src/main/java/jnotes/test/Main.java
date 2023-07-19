package jnotes.test;

import jnotes.test.testutil.Test;

public class Main {

    public static final Test test = new Test();

    public static void main(String[] args) {

        System.out.println(getHerz(9));

        //runTest();

    }

    private static float getHerz(int x){
        return (float) (16.351597831287414 * Math.pow(2, (float) x / 12));
    }

    private static void runTest(){
        NotesTest.comparison();

        test.run();
    }
}
