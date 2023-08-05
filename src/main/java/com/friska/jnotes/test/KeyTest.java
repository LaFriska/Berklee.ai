package com.friska.jnotes.test;

import com.friska.jnotes.core.keys.Key;
import com.friska.jnotes.core.keys.KeyQualities;
import com.friska.jnotes.core.keys.KeyQuality;
import com.friska.jnotes.core.notes.Note;
import com.friska.jnotes.core.notes.Notes;
import com.friska.jnotes.test.testutil.Assertion;
import com.friska.jnotes.test.testutil.Suite;

public class KeyTest {

    protected static void scaleDegrees(){
        TestMain.test.addSuite(new Suite("Key.ScaleDegrees").addAssertions(
                new Assertion<>("E F# G# A B C# D#", getTestString(Notes.E, KeyQualities.major())),
                new Assertion<>("E F# G# A# B C# D#", getTestString(Notes.E, KeyQualities.lydian())),
                new Assertion<>("C D Eb F G A B", getTestString(Notes.C, KeyQualities.melodicMinor())),
                new Assertion<>("Bb C Db Eb F G Ab", getTestString(Notes.B_FLAT, KeyQualities.dorian())),
                new Assertion<>("A# B# C# D# E# F# G#", getTestString(Notes.A_SHARP, KeyQualities.minor())),
                new Assertion<>("A# B# Cx D# E# Fx Gx", getTestString(Notes.A_SHARP, KeyQualities.major())),
                new Assertion<>("C# D# E F# G# A B#", getTestString(Notes.C_SHARP, KeyQualities.harmonicMinor())),
                new Assertion<>("F Gb Ab Bb Cb Db Eb", getTestString(Notes.F, KeyQualities.locrian())),
                new Assertion<>("B C D E F G A", getTestString(Notes.B, KeyQualities.locrian())),
                new Assertion<>("D E F# G A B C", getTestString(Notes.D, KeyQualities.mixolydian())),
                new Assertion<>("C D E F G A Bb", getTestString(Notes.C, KeyQualities.mixolydian())),
                new Assertion<>("F# G# A# B C# D# E", getTestString(Notes.F_SHARP, KeyQualities.mixolydian())),
                new Assertion<>("D Eb F G A Bb C", getTestString(Notes.D, KeyQualities.phrygian())),
                new Assertion<>("E F G A B C D", getTestString(Notes.E, KeyQualities.phrygian())),
                new Assertion<>("Eb F Gb Ab Bb Cb D", getTestString(Notes.E_FLAT, KeyQualities.harmonicMinor())),
                new Assertion<>("C D E F# G A Bb", getTestString(Notes.C, KeyQualities.lydianDominant())),
                new Assertion<>("Eb F G A Bb C Db", getTestString(Notes.E_FLAT, KeyQualities.lydianDominant())),
                new Assertion<>("D E F# G# A B C", getTestString(Notes.D, KeyQualities.lydianDominant()))
        ));
    }

    private static String getTestString(Note note, KeyQuality keyQuality){
        Key key = new Key(note, keyQuality);
        Note[] notes = key.getScaleDegrees();
        StringBuilder sb = new StringBuilder(notes[0].getSpelling());
        for (int i = 1; i < notes.length; i++) {
            sb.append(" ");
            sb.append(notes[i].getSpelling());
        }
        return TestMain.getReplacedAccidentals(sb.toString());
    }
}
