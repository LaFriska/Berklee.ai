package com.friska.jnotes.core.chords;

import com.friska.jnotes.core.intervals.Interval;
import com.friska.jnotes.core.intervals.IntervalQuality;
import com.friska.jnotes.debug.MissingJavadoc;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

@MissingJavadoc
public class ChordQuality { //TODO potentially implement ComparableElement
    private final Interval[] chordIntervals = new Interval[]{null, null, null};
    private final String qualityName;
    private final String qualityNotation;

    protected ChordQuality(String qualityName, String qualityNotation){
        this.qualityName = qualityName;
        this.qualityNotation = qualityNotation;
    }

    public ChordQuality third(@NotNull IntervalQuality quality){
        chordIntervals[0] = new Interval(3, quality);
        return this;
    }

    public ChordQuality fifth(@NotNull IntervalQuality quality){
        chordIntervals[1] = new Interval(5, quality);
        return this;
    }

    public ChordQuality extensionTone(int value, @NotNull IntervalQuality quality){
        chordIntervals[1] = new Interval(value, quality);
        return this;
    }

    public String getQualityName() {
        return qualityName;
    }

    public String getQualityNotation() {
        return qualityNotation;
    }

    public ChordQuality setInterval(int index, Interval interval){
        this.chordIntervals[index] = interval;
        return this;
    }

    public Interval[] getCompressedArray(){
        ArrayList<Interval> arr = new ArrayList<>();
        for (Interval chordInterval : chordIntervals) {
            if(chordInterval != null) arr.add(chordInterval);
        }
        return arr.toArray(new Interval[0]);
    }
}
