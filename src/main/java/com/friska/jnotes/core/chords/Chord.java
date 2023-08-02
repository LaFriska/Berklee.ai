package com.friska.jnotes.core.chords;

import com.friska.jnotes.core.chords.enums.Sus;
import com.friska.jnotes.core.chords.enums.Tension;
import com.friska.jnotes.core.intervals.Interval;
import com.friska.jnotes.core.intervals.IntervalQuality;
import com.friska.jnotes.core.notes.Alteration;
import com.friska.jnotes.core.notes.Note;
import com.friska.jnotes.debug.MissingJavadoc;
import com.friska.jnotes.exceptions.ChordException;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class Chord {

    private final Note root;
    private final ChordQuality quality;

    @Nullable
    private Sus sus = null;

    @Nullable
    private Alteration alt5 = null;

    private final ArrayList<Tension> tensions = new ArrayList<>();

    /**
     * This class aims to represent a musical chord of 3 or more notes. Chords in JNotes are compiled by
     * instantiating this class, inputting a root note, chord quality. Any alterations, tensions that should
     * be added to a chord can be achieved by using various methods in this class. Once completed, the {@link Chord#compile()} method
     * compiles the chord into a record with its respective chord spelling and an array of notes.
     *
     * @param rootNote Root note of the chord. DO NOT choose a note too high, as that would increase the chance of
     *                 not being able to stack chord tones or tensions on the root note.
     * <p>
     * @param chordQuality Quality of the chord such as major 7 or minor 6. See {@link ChordQualities} for most a list of common
     *                     chord qualities. If you want to use the half diminished chord quality, please call the {@link ChordQualities#min7()} method
     *                     and use the {@link Chord#b5()} method to flat the five.
     * **/
    public Chord(Note rootNote, ChordQuality chordQuality){
        if(rootNote.isOctaveAbstract()) throw new ChordException("Cannot process root note with an abstract octave.");
        this.root = rootNote;
        this.quality = chordQuality;
    }

    /**
     * Suspends the 3rd chord tone with a perfect 4th.
     * */
    public Chord sus4(){
        sus = Sus.SUS4;
        return this;
    }

    /**
     * Suspends the 3rd chord tone with a major 2nd.
     * */
    public Chord sus2(){
        sus = Sus.SUS2;
        return this;
    }

    /**
     * Flats the 5th.
     * */
    public Chord b5(){
        alt5 = Alteration.FLAT;
        return this;
    }

    /**
     * Sharps the 5th.
     * */
    public Chord s5(){
        alt5 = Alteration.SHARP;
        return this;
    }

    /**
     * Adds a chord tension by parsing a Tension enumerator as an argument.
     * @see Tension
     * */
    public Chord tension(Tension tension){
        this.tensions.add(tension);
        return this;
    }

    /**
     * Adds one or more chord tensions by parsing a Tension enumerator varargs as an argument.
     * @see Tension
     * */
    public Chord tensions(Tension... tensions){
        for (Tension tension : tensions) {
            tension(tension);
        }
        return this;
    }

    /**
     * Compiles the chord into a CompiledChord record, where notes are actualised from the array of
     * intervals representing the chord tones and tensions. The chord spelling and lily code can also be
     * accessed through the CompiledChord record.
     *
     * @see CompiledChord
     * */
    public CompiledChord compile(){
        StringBuilder sb = new StringBuilder(root.getSpelling());
        sb.append(quality.getQualityNotation());

        if(alt5 != null) {
            switch (alt5) {
                case FLAT -> {
                    quality.setInterval(1, new Interval(5, IntervalQuality.DIMINISHED));
                    sb.append("♭5");
                }
                case SHARP -> {
                    quality.setInterval(1, new Interval(5, IntervalQuality.AUGMENTED));
                    sb.append("♯5");
                }
            }
        }

        if(sus != null) {
            switch (sus) {
                case SUS4 -> quality.setInterval(0, new Interval(4, IntervalQuality.PERFECT));
                case SUS2 -> quality.setInterval(0, new Interval(2, IntervalQuality.MAJOR));
            }
            sb.append(sus.notation);
        }

        if(tensions.size() != 0) {
            sb.append("(");
            for(Tension tension : tensions) {
                sb.append(tension.notation);
            }
            sb.append(")");
        }

        Interval[] qualityCompressed = quality.getCompressedArray();
        Note[] notes = new Note[qualityCompressed.length + tensions.size() + 1];
        notes[0] = root;
        for (int i = 1; i < notes.length; i++) {
            notes[i] = root.getNoteAbove(
                    i - 1 <= qualityCompressed.length - 1 ?
                        qualityCompressed[i - 1] :
                        tensions.get(i - qualityCompressed.length - 1).interval
            );
        }
        return new CompiledChord(sb.toString(), notes);
    }
}
