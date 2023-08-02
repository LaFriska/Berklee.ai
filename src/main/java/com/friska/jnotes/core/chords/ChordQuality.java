package com.friska.jnotes.core.chords;

import com.friska.jnotes.core.intervals.Interval;
import com.friska.jnotes.core.intervals.IntervalQuality;
import com.friska.jnotes.debug.MissingJavadoc;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

@MissingJavadoc
public class ChordQuality {
    private final Interval[] chordIntervals = new Interval[]{null, null, null};
    private final String qualityName;
    private final String qualityNotation;

    /**
     * A chord quality is the blueprint to actualise chord tones of a chord. Calling various
     * methods in this class will allow you to determine the intervals in your chord quality.
     * <b>Note that most chord qualities you will ever need is in the ChordQualities class,</b>
     * and using this method is pointless unless the desired chord quality is not given. (Such
     * as the rare minor-b6 quality used only in line clichés).
     *
     * @param qualityName Name of the quality, such as "major 7th".
     * @param qualityNotation Notation of the quality, such as "maj7".
     * */
    public ChordQuality(String qualityName, String qualityNotation){
        this.qualityName = qualityName;
        this.qualityNotation = qualityNotation;
    }

    /**Interval quality for the third chord tone*/
    public ChordQuality third(@NotNull IntervalQuality quality){
        chordIntervals[0] = new Interval(3, quality);
        return this;
    }

    /**Interval quality for the fifth chord tone*/
    public ChordQuality fifth(@NotNull IntervalQuality quality){
        chordIntervals[1] = new Interval(5, quality);
        return this;
    }

    /**An extension tone, such as the 7th or the 6th considered to be a chord tone.*/
    public ChordQuality extensionTone(int value, @NotNull IntervalQuality quality){
        chordIntervals[2] = new Interval(value, quality);
        return this;
    }

    /**@return Returns the name of the quality.*/
    public String getQualityName() {
        return qualityName;
    }

    /**@return Returns the notation of the quality.*/
    public String getQualityNotation() {
        return qualityNotation;
    }

    /**Forcefully set interval of the index number of chord tone above the root note.*/
    public ChordQuality setInterval(int index, Interval interval){
        this.chordIntervals[index] = interval;
        return this;
    }

    /**Returns an array of all chord tones added.*/
    public Interval[] getCompressedArray(){
        ArrayList<Interval> arr = new ArrayList<>();
        for (Interval chordInterval : chordIntervals) {
            if(chordInterval != null) arr.add(chordInterval);
        }
        return arr.toArray(new Interval[0]);
    }
}
