package com.friska.jnotes.test;

import com.friska.jnotes.core.chords.CompiledChord;
import com.friska.jnotes.core.notes.Note;
import com.friska.jnotes.test.testutil.Assertion;
import com.friska.jnotes.test.testutil.Suite;

public class ChordTest {


    protected static void tones(){
        Main.test.addSuite(new Suite("Chord.Tone.Notes").addAssertions(
                new Assertion<>("")
        ));
    }

    private static String getAllNotes(CompiledChord chord){
        Note[] notes = chord.notes();
        StringBuilder sb = new StringBuilder(notes[0].getSpelling());

        for (int i = 0; i < notes.length; i++) {
            sb.append(" ").append(notes[i]);
        }
        return sb.toString()
                .replaceAll("♭", "b")
                .replaceAll("♯", "#")
                .replaceAll("\uD834\uDD2A", "x")
                .replaceAll("\uD834\uDD2B", "bb");
    }

}
