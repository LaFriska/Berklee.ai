package com.friska.jnotes.test;

import com.friska.jnotes.core.chords.Chord;
import com.friska.jnotes.core.chords.ChordQualities;
import com.friska.jnotes.core.chords.CompiledChord;
import com.friska.jnotes.core.chords.enums.Tension;
import com.friska.jnotes.core.notes.Note;
import com.friska.jnotes.core.notes.Notes;
import com.friska.jnotes.test.testutil.Assertion;
import com.friska.jnotes.test.testutil.Suite;

public class ChordTest {


    protected static void tones(){
        TestMain.test.addSuite(new Suite("Chord.Tone.Notes").addAssertions(
                new Assertion<>("A4 C5 E5", getAllNotes(new Chord(Notes.A.setOctave(4), ChordQualities.min()).compile())),
                new Assertion<>("A4 C#5 E5 G#5", getAllNotes(new Chord(Notes.A.setOctave(4), ChordQualities.maj7()).compile())),
                new Assertion<>("Db3 Fb3 Ab3 Cb4 Eb4", getAllNotes(new Chord(Notes.D_FLAT.setOctave(3), ChordQualities.min7()).tension(Tension.T9).compile())),
                new Assertion<>("C5 F5 G5 Bb5", getAllNotes(new Chord(Notes.C.setOctave(5), ChordQualities.dom7()).sus4().compile())),
                new Assertion<>("B1 D2 F2 A2 G#3", getAllNotes(new Chord(Notes.B.setOctave(1), ChordQualities.min7()).b5().tension(Tension.T13).compile())),
                new Assertion<>("Gb4 Bb4 D5 Eb5 Abb5 C6 Ebb6", getAllNotes(new Chord(Notes.G_FLAT.setOctave(4), ChordQualities.maj6()).s5().tensions(Tension.Tb9, Tension.Ts11, Tension.Tb13).compile())),
                new Assertion<>("D2 F#2 A#2 C3", getAllNotes(new Chord(Notes.D.setOctave(2), ChordQualities.dom7()).s5().compile())),
                new Assertion<>("C2 D2 G#2 B2 Db3 Fb3 A3 Gb2", getAllNotes(new Chord(Notes.C.setOctave(2), ChordQualities.maj7()).s5().sus2().tensions(Tension.Tb9, Tension.Tb11, Tension.T13, Tension.Tb5).compile()))
        ));
    }

    private static String getAllNotes(CompiledChord chord){
        Note[] notes = chord.notes();
        StringBuilder sb = new StringBuilder(notes[0].getSpelling(true));

        for (int i = 1; i < notes.length; i++) {
            sb.append(" ").append(notes[i].getSpelling(true));
        }
        return TestMain.getReplacedAccidentals(sb.toString());
    }

}
