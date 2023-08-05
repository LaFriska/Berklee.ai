package com.friska.jnotes.test;

import com.friska.jnotes.core.intervals.Interval;
import com.friska.jnotes.core.intervals.IntervalCalculator;
import com.friska.jnotes.core.intervals.IntervalQuality;
import com.friska.jnotes.core.notes.Notes;
import com.friska.jnotes.test.testutil.Assertion;
import com.friska.jnotes.test.testutil.Suite;

public class IntervalsTest {
    protected static void values(){

        TestMain.test.addSuites(
                new Suite("Intervals.Values.Values").addAssertions(
                        new Assertion<>(8, new IntervalCalculator(Notes.C.setOctave(3), Notes.C.setOctave(4)).getValue()),
                        new Assertion<>(8, new IntervalCalculator(Notes.E.setOctave(3), Notes.E_FLAT.setOctave(4)).getValue()),
                        new Assertion<>(9, new IntervalCalculator(Notes.C.setOctave(3), Notes.D_FLAT.setOctave(4)).getValue()),
                        new Assertion<>(9, new IntervalCalculator(Notes.C_DOUBLE_FLAT.setOctave(3), Notes.D_DOUBLE_SHARP.setOctave(4)).getValue()),
                        new Assertion<>(3, new IntervalCalculator(Notes.G.setOctave(3), Notes.B.setOctave(3)).getValue()),
                        new Assertion<>(15, new IntervalCalculator(Notes.G.setOctave(1), Notes.G.setOctave(3)).getValue()),
                        new Assertion<>(18, new IntervalCalculator(Notes.F_FLAT.setOctave(4), Notes.B.setOctave(6)).getValue()),
                        new Assertion<>(5, new IntervalCalculator(Notes.A.setOctave(3), Notes.E.setOctave(4)).getValue()),
                        new Assertion<>(13, new IntervalCalculator(Notes.D_SHARP.setOctave(3), Notes.B_DOUBLE_SHARP.setOctave(4)).getValue()),
                        new Assertion<>(9, new IntervalCalculator(Notes.F.setOctave(3), Notes.G.setOctave(4)).getValue()),

                        new Assertion<>(3, new IntervalCalculator(Notes.C.setOctave(4), Notes.E.setOctave(4)).getValue()),
                        new Assertion<>(4, new IntervalCalculator(Notes.C.setOctave(4), Notes.F.setOctave(4)).getValue()),
                        new Assertion<>(3, new IntervalCalculator(Notes.E_FLAT.setOctave(4), Notes.G_SHARP.setOctave(4)).getValue()),
                        new Assertion<>(7, new IntervalCalculator(Notes.A.setOctave(3), Notes.G.setOctave(4)).getValue()),
                        new Assertion<>(6, new IntervalCalculator(Notes.F_FLAT.setOctave(4), Notes.D_SHARP.setOctave(5)).getValue()),
                        new Assertion<>(8, new IntervalCalculator(Notes.A_DOUBLE_SHARP.setOctave(3), Notes.A_DOUBLE_FLAT.setOctave(4)).getValue()),
                        new Assertion<>(3, new IntervalCalculator(Notes.C_DOUBLE_FLAT.setOctave(4), Notes.E_DOUBLE_SHARP.setOctave(4)).getValue()),
                        new Assertion<>(5, new IntervalCalculator(Notes.E.setOctave(4), Notes.B_SHARP.setOctave(4)).getValue()),
                        new Assertion<>(3, new IntervalCalculator(Notes.D_FLAT.setOctave(4), Notes.F_SHARP.setOctave(4)).getValue()),
                        new Assertion<>(1, new IntervalCalculator(Notes.G_DOUBLE_FLAT.setOctave(4), Notes.G_FLAT.setOctave(4)).getValue()),

                        new Assertion<>(15, new IntervalCalculator(Notes.G_DOUBLE_FLAT.setOctave(2), Notes.G_FLAT.setOctave(4)).getValue()),
                        new Assertion<>(10, new IntervalCalculator(Notes.A.setOctave(4), Notes.C.setOctave(6)).getValue()),
                        new Assertion<>(22, new IntervalCalculator(Notes.G_DOUBLE_FLAT.setOctave(4), Notes.G_DOUBLE_SHARP.setOctave(7)).getValue()),
                        new Assertion<>(13, new IntervalCalculator(Notes.A.setOctave(0), Notes.F_SHARP.setOctave(2)).getValue())
                ),

                new Suite("Intervals.Values.Actual").addAssertions(
                        new Assertion<>("Major 3rd", new IntervalCalculator(Notes.C.setOctave(2), Notes.E.setOctave(2)).getFormattedName()),
                        new Assertion<>("Minor 3rd", new IntervalCalculator(Notes.C.setOctave(2), Notes.E_FLAT.setOctave(2)).getFormattedName()),
                        new Assertion<>("Diminished 3rd", new IntervalCalculator(Notes.C.setOctave(2), Notes.E_DOUBLE_FLAT.setOctave(2)).getFormattedName()),
                        new Assertion<>("Octave", new IntervalCalculator(Notes.G_DOUBLE_SHARP.setOctave(2), Notes.G_DOUBLE_SHARP.setOctave(3)).getFormattedName()),
                        new Assertion<>("Diminished Octave", new IntervalCalculator(Notes.G_DOUBLE_SHARP.setOctave(2), Notes.G_SHARP.setOctave(3)).getFormattedName()),
                        new Assertion<>("Unison", new IntervalCalculator(Notes.C_SHARP.setOctave(7), Notes.C_SHARP.setOctave(7)).getFormattedName()),
                        new Assertion<>("Minor 2nd", new IntervalCalculator(Notes.C_SHARP.setOctave(7), Notes.D.setOctave(7)).getFormattedName()),
                        new Assertion<>("Major 2nd", new IntervalCalculator(Notes.F_SHARP.setOctave(7), Notes.G_SHARP.setOctave(7)).getFormattedName()),
                        new Assertion<>("Augmented Unison", new IntervalCalculator(Notes.C_SHARP.setOctave(7), Notes.C_DOUBLE_SHARP.setOctave(7)).getFormattedName()),
                        new Assertion<>("Augmented 2nd", new IntervalCalculator(Notes.C_SHARP.setOctave(7), Notes.D_DOUBLE_SHARP.setOctave(7)).getFormattedName()),

                        new Assertion<>("Double Diminished 4th", new IntervalCalculator(Notes.C_SHARP.setOctave(7), Notes.F_FLAT.setOctave(7)).getFormattedName()),
                        new Assertion<>("Triple Augmented 6th", new IntervalCalculator(Notes.C_FLAT.setOctave(1), Notes.A_DOUBLE_SHARP.setOctave(1)).getFormattedName()),
                        new Assertion<>("Minor 9th", new IntervalCalculator(Notes.A.setOctave(6), Notes.B_FLAT.setOctave(7)).getFormattedName()),
                        new Assertion<>("Diminished 9th", new IntervalCalculator(Notes.A.setOctave(6), Notes.B_DOUBLE_FLAT.setOctave(7)).getFormattedName()),
                        new Assertion<>("Augmented 11th", new IntervalCalculator(Notes.D.setOctave(6), Notes.G_SHARP.setOctave(7)).getFormattedName()),
                        new Assertion<>("Double Augmented 11th", new IntervalCalculator(Notes.D_FLAT.setOctave(6), Notes.G_SHARP.setOctave(7)).getFormattedName()),
                        new Assertion<>("Major 13th", new IntervalCalculator(Notes.F.setOctave(3), Notes.D.setOctave(5)).getFormattedName()),
                        new Assertion<>("Major 16th", new IntervalCalculator(Notes.C_DOUBLE_SHARP.setOctave(5), Notes.D_DOUBLE_SHARP.setOctave(7)).getFormattedName()),
                        new Assertion<>("Augmented Octave", new IntervalCalculator(Notes.B_FLAT.setOctave(5), Notes.B.setOctave(6)).getFormattedName()),
                        new Assertion<>("Quadruple Augmented 6th", new IntervalCalculator(Notes.F_DOUBLE_FLAT.setOctave(3), Notes.D_DOUBLE_SHARP.setOctave(4)).getFormattedName()),
                        new Assertion<>("Augmented 9th", new IntervalCalculator(Notes.A_SHARP.setOctave(0), Notes.B_DOUBLE_SHARP.setOctave(1)).getFormattedName())
                ),

        new Suite("Intervals.Values.Distance").addAssertions(
                new Assertion<>(4, new IntervalCalculator(Notes.C.setOctave(2), Notes.E.setOctave(2)).getDistance()),
                new Assertion<>(8, new Interval(7, IntervalQuality.DOUBLE_DIMINISHED).getDistance()),
                new Assertion<>(12, new Interval(8, IntervalQuality.PERFECT).getDistance()),
                new Assertion<>(7, new Interval(5, IntervalQuality.PERFECT).getDistance()),
                new Assertion<>(8, new Interval(5, IntervalQuality.AUGMENTED).getDistance()),
                new Assertion<>(13, new Interval(9, IntervalQuality.MINOR).getDistance()),
                new Assertion<>(19, new Interval(11, IntervalQuality.DOUBLE_AUGMENTED).getDistance()),
                new Assertion<>(22, new Interval(13, IntervalQuality.AUGMENTED).getDistance()),
                new Assertion<>(3, new Interval(5, IntervalQuality.QUADRUPLE_DIMINISHED).getDistance()),
                new Assertion<>(15, new Interval(12, IntervalQuality.QUADRUPLE_DIMINISHED).getDistance()),
                new Assertion<>(28, new Interval(15, IntervalQuality.QUADRUPLE_AUGMENTED).getDistance()),
                new Assertion<>(5, new Interval(6, IntervalQuality.TRIPLE_DIMINISHED).getDistance()),
                new Assertion<>(20, new Interval(13, IntervalQuality.MINOR).getDistance())
            )
        );
    }

    protected static void noteFinder(){
        TestMain.test.addSuites(
                new Suite("Intervals.Values.NoteFinder").addAssertions(
                        new Assertion<>(Notes.E.setOctave(4).getSpelling(true),
                                Notes.C.setOctave(4).getNoteAbove(new Interval(3, IntervalQuality.MAJOR)).getSpelling(true)),
                        new Assertion<>(Notes.E_FLAT.setOctave(4).getSpelling(true),
                                Notes.C.setOctave(4).getNoteAbove(new Interval(3, IntervalQuality.MINOR)).getSpelling(true)),
                        new Assertion<>(Notes.G.setOctave(7).getSpelling(true),
                                Notes.A.setOctave(6).getNoteAbove(new Interval(7, IntervalQuality.MINOR)).getSpelling(true)),
                        new Assertion<>(Notes.C_FLAT.setOctave(3).getSpelling(true),
                                Notes.B.setOctave(2).getNoteAbove(new Interval(2, IntervalQuality.DIMINISHED)).getSpelling(true)),
                        new Assertion<>(Notes.B_SHARP.setOctave(2).getSpelling(true),
                                Notes.F_SHARP.setOctave(2).getNoteAbove(new Interval(4, IntervalQuality.AUGMENTED)).getSpelling(true)),
                        new Assertion<>(Notes.B_DOUBLE_SHARP.setOctave(2).getSpelling(true),
                                Notes.F_SHARP.setOctave(2).getNoteAbove(new Interval(4, IntervalQuality.DOUBLE_AUGMENTED)).getSpelling(true)),
                        new Assertion<>(Notes.C_FLAT.setOctave(3).getSpelling(true),
                                Notes.G_DOUBLE_SHARP.setOctave(2).getNoteAbove(new Interval(4, IntervalQuality.TRIPLE_DIMINISHED)).getSpelling(true)),
                        new Assertion<>(Notes.D_DOUBLE_FLAT.setOctave(6).getSpelling(true),
                                Notes.D_DOUBLE_FLAT.setOctave(4).getNoteAbove(new Interval(15, IntervalQuality.PERFECT)).getSpelling(true)),
                        new Assertion<>(Notes.D_SHARP.setOctave(6).getSpelling(true),
                                Notes.D_DOUBLE_FLAT.setOctave(4).getNoteAbove(new Interval(15, IntervalQuality.TRIPLE_AUGMENTED)).getSpelling(true)),
                        new Assertion<>(Notes.F.setOctave(6).getSpelling(true),
                                Notes.A_FLAT.setOctave(4).getNoteAbove(new Interval(13, IntervalQuality.MAJOR)).getSpelling(true)),
                        new Assertion<>(Notes.D_DOUBLE_SHARP.setOctave(5).getSpelling(true),
                                Notes.D_DOUBLE_SHARP.setOctave(5).getNoteAbove(new Interval(1, IntervalQuality.PERFECT)).getSpelling(true)),
                        new Assertion<>(Notes.E_SHARP.setOctave(5).getSpelling(true),
                                Notes.A_DOUBLE_SHARP.setOctave(3).getNoteAbove(new Interval(12, IntervalQuality.DIMINISHED)).getSpelling(true)),
                        new Assertion<>(Notes.B_FLAT.setOctave(4).getSpelling(true),
                                Notes.A.setOctave(3).getNoteAbove(new Interval(9, IntervalQuality.MINOR)).getSpelling(true))

                )
        );
    }
}
