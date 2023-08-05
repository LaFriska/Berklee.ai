package com.friska.jnotes.test;

import com.friska.jnotes.test.testutil.Test;

public class TestMain {

    public static final Test test = new Test();

    public static void main(String[] args) {
        run();
    }
    private static void run(){
        NotesTest.comparison();
        NotesTest.pitch();
        NotesTest.misc();
        IntervalsTest.values();
        IntervalsTest.noteFinder();
        ChordTest.tones();
        KeyTest.scaleDegrees();
        test.run();
    }

    public static String getReplacedAccidentals(String str){
        return str.replaceAll("♭", "b")
                .replaceAll("♯", "#")
                .replaceAll("\uD834\uDD2A", "x")
                .replaceAll("\uD834\uDD2B", "bb");
    }
}
