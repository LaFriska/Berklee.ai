package com.friska.jnotes.core.chords;

import com.friska.jnotes.core.chords.enums.Sus;
import com.friska.jnotes.core.chords.enums.Tension;
import com.friska.jnotes.core.intervals.Interval;
import com.friska.jnotes.core.intervals.IntervalCalculator;
import com.friska.jnotes.core.intervals.IntervalQuality;
import com.friska.jnotes.core.notes.Alteration;
import com.friska.jnotes.core.notes.Note;
import com.friska.jnotes.debug.MissingJavadoc;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

@MissingJavadoc
public class Chord {

    private final Note root;
    private final ChordQuality quality;

    @Nullable
    private Sus sus = null;

    @Nullable
    private Alteration alt5 = null;

    private final ArrayList<Tension> tensions = new ArrayList<>();

    public Chord(Note rootNote, ChordQuality chordQuality){
        this.root = rootNote;
        this.quality = chordQuality;
    }

    public Chord sus4(){
        sus = Sus.SUS4;
        return this;
    }

    public Chord sus2(){
        sus = Sus.SUS2;
        return this;
    }

    public Chord b5(){
        alt5 = Alteration.FLAT;
        return this;
    }

    public Chord s5(){
        alt5 = Alteration.SHARP;
        return this;
    }

    public void addTension(Tension tension){
        this.tensions.add(tension);
    }

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
                case SUS2 -> quality.setInterval(0, new Interval(4, IntervalQuality.PERFECT));
                case SUS4 -> quality.setInterval(0, new Interval(2, IntervalQuality.MAJOR));
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
