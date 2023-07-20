package jnotes.test;

import jnotes.core.intervals.Interval;
import jnotes.core.notes.Notes;
import jnotes.test.testutil.Assertion;
import jnotes.test.testutil.Suite;

public class IntervalsTest {
    protected static void values(){
        Main.test.addSuite(
                new Suite("Intervals.Values.Abstract").addAssertions(
                        new Assertion<>(3, new Interval(Notes.C, Notes.E).getValue()),
                        new Assertion<>(4, new Interval(Notes.C, Notes.F).getValue()),
                        new Assertion<>(3, new Interval(Notes.E_FLAT, Notes.G_SHARP).getValue()),
                        new Assertion<>(7, new Interval(Notes.A, Notes.G).getValue()),
                        new Assertion<>(6, new Interval(Notes.F_FLAT, Notes.D_SHARP).getValue()),
                        new Assertion<>(1, new Interval(Notes.A_DOUBLE_SHARP, Notes.A_DOUBLE_FLAT).getValue()),
                        new Assertion<>(3, new Interval(Notes.C_DOUBLE_FLAT, Notes.E_DOUBLE_SHARP).getValue()),
                        new Assertion<>(7, new Interval(Notes.C_DOUBLE_FLAT, Notes.B_DOUBLE_SHARP).getValue()),
                        new Assertion<>(7, new Interval(Notes.F_DOUBLE_FLAT, Notes.E_DOUBLE_SHARP).getValue()),
                        new Assertion<>(5, new Interval(Notes.E, Notes.B_SHARP).getValue()),

                        new Assertion<>(3, new Interval(Notes.D_FLAT, Notes.F_SHARP).getValue()),
                        new Assertion<>(1, new Interval(Notes.G_FLAT, Notes.G_DOUBLE_FLAT).getValue())
                )
        );

        Main.test.addSuite(
                new Suite("Intervals.Values.DefinedOctave").addAssertions(
                        new Assertion<>(8, new Interval(Notes.C.setOctave(3), Notes.C.setOctave(4)).getValue()),
                        new Assertion<>(8, new Interval(Notes.E.setOctave(3), Notes.E_FLAT.setOctave(4)).getValue()),
                        new Assertion<>(9, new Interval(Notes.C.setOctave(3), Notes.D_FLAT.setOctave(4)).getValue()),
                        new Assertion<>(9, new Interval(Notes.C_DOUBLE_FLAT.setOctave(3), Notes.D_DOUBLE_SHARP.setOctave(4)).getValue()),
                        new Assertion<>(3, new Interval(Notes.G.setOctave(3), Notes.B.setOctave(3)).getValue()),
                        new Assertion<>(24, new Interval(Notes.G.setOctave(1), Notes.G.setOctave(3)).getValue()),
                        new Assertion<>(28, new Interval(Notes.F_FLAT.setOctave(4), Notes.B.setOctave(6)).getValue()),
                        new Assertion<>(12, new Interval(Notes.A.setOctave(3), Notes.E.setOctave(4)).getValue()),
                        new Assertion<>(13, new Interval(Notes.D_SHARP.setOctave(3), Notes.B_DOUBLE_SHARP.setOctave(4)).getValue()),
                        new Assertion<>(7, new Interval(Notes.F.setOctave(3), Notes.E.setOctave(3)).getValue())
                )
        );
    }
}
