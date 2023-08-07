package com.friska.jnotes.test;

import com.friska.jnotes.core.intervals.Interval;
import com.friska.jnotes.core.intervals.IntervalCalculator;
import com.friska.jnotes.core.intervals.IntervalQuality;
import com.friska.jnotes.core.keys.Key;
import com.friska.jnotes.core.keys.KeyQualities;
import com.friska.jnotes.core.notes.Notes;
import com.friska.jnotes.test.testutil.Test;

public class TestMain {

    public static final Test test = new Test();

    public static void main(String[] args) {
        System.out.println(new Key(Notes.E_DOUBLE_SHARP, KeyQualities.melodicMinor()).getLilyCode());
        //run();

        //Interval interval = new Interval(3, IntervalQuality.QUADRUPLE_AUGMENTED);
        //System.out.println(Notes.C.setOctave(1).getNoteAbove(interval));
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
