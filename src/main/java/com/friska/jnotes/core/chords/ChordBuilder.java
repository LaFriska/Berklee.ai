package com.friska.jnotes.core.chords;

import com.friska.jnotes.core.intervals.Interval;
import com.friska.jnotes.core.intervals.IntervalQuality;
import com.friska.jnotes.core.notes.Note;
import com.friska.jnotes.debug.MissingJavadoc;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import static com.friska.jnotes.core.intervals.IntervalQuality.*;

@MissingJavadoc
public class ChordBuilder{

    private final Note root;
    private final ChordQuality quality;

    private final ArrayList<Interval> tension = new ArrayList<>();

    public ChordBuilder(Note rootNote, ChordQuality chordQuality){
        this.root = rootNote;
        this.quality = chordQuality;
    }

    public ChordBuilder sus4(){
        quality.sus4();
        return this;
    }

    public ChordBuilder sus2(){
        quality.sus2();
        return this;
    }

    private void addTension(int value, @NotNull IntervalQuality quality){
        this.tension.add(new Interval(value, quality));
    }

    public ChordBuilder addFlat9(){
        addTension(9, MINOR);
        return this;
    }

    public ChordBuilder add9(){
        addTension(9, MAJOR);
        return this;
    }

    public ChordBuilder addSharp9(){
        addTension(9, AUGMENTED);
        return this;
    }

    public ChordBuilder addFlat11(){
        addTension(11, DIMINISHED);
        return this;
    }

    public ChordBuilder add11(){
        addTension(11, PERFECT);
        return this;
    }

    public ChordBuilder addSharp11(){
        addTension(11, AUGMENTED);
        return this;
    }

    public ChordBuilder addFlat13(){
        addTension(13, MINOR);
        return this;
    }

    public ChordBuilder add13(){
        addTension(13, MAJOR);
        return this;
    }

    public ChordBuilder addSharp13(){
        addTension(13, AUGMENTED);
        return this;
    }

}
