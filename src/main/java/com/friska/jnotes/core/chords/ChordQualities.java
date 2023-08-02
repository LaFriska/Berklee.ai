package com.friska.jnotes.core.chords;

import com.friska.jnotes.core.intervals.IntervalQuality;
import com.friska.jnotes.debug.MissingJavadoc;

/**
 * A list of chord qualities that could be used in the creation of a Chord object.
 * */
public class ChordQualities {

    /**Major triad*/
    public static final ChordQuality maj(){
        return new ChordQuality("major", "")
            .third(IntervalQuality.MAJOR)
            .fifth(IntervalQuality.PERFECT);
    }

    /**Minor triad*/
    public static final ChordQuality min(){
        return new ChordQuality("minor", "-")
                .third(IntervalQuality.MINOR)
                .fifth(IntervalQuality.PERFECT);
    }

    /**Diminished triad*/
    public static final ChordQuality dim(){
        return new ChordQuality("diminished", "dim")
                .third(IntervalQuality.MINOR)
                .fifth(IntervalQuality.DIMINISHED);
    }
    /**Augmented triad*/
    public static final ChordQuality aug(){
        return new ChordQuality("augmented", "+")
                .third(IntervalQuality.MAJOR)
                .fifth(IntervalQuality.AUGMENTED);
    }

    /**Augmented 7th chord*/
    public static final ChordQuality aug7(){
        return new ChordQuality("augmented 7", "+7")
                .third(IntervalQuality.MAJOR)
                .fifth(IntervalQuality.AUGMENTED)
                .extensionTone(7, IntervalQuality.MINOR);
    }

    /**Major 7th chord*/
    public static final ChordQuality maj7(){
        return new ChordQuality("major 7", "maj7")
                .third( IntervalQuality.MAJOR)
                .fifth( IntervalQuality.PERFECT)
                .extensionTone(7, IntervalQuality.MAJOR);
    }

    /**Dominant 7th chord*/
    public static final ChordQuality dom7(){
        return new ChordQuality("7", "7")
                .third( IntervalQuality.MAJOR)
                .fifth(IntervalQuality.PERFECT)
                .extensionTone(7, IntervalQuality.MINOR);
    }

    /**Minor 7th chord*/
    public static final ChordQuality min7(){
        return new ChordQuality("minor 7", "-7")
                .third(IntervalQuality.MINOR)
                .fifth(IntervalQuality.PERFECT)
                .extensionTone(7, IntervalQuality.MINOR);
    }

    /**Minor major 7th chord (chords with a minor triad and major 7th chord tone)*/
    public static final ChordQuality minMaj7(){
        return new ChordQuality("minor major 7", "-maj7")
                .third(IntervalQuality.MINOR)
                .fifth(IntervalQuality.PERFECT)
                .extensionTone(7, IntervalQuality.MAJOR);
    }

    /**Diminished 7th chord*/
    public static final ChordQuality dim7(){
        return new ChordQuality("diminished 7", "dim7")
                .third(IntervalQuality.MINOR)
                .fifth(IntervalQuality.DIMINISHED)
                .extensionTone(6, IntervalQuality.MAJOR);
    }

    /**Minor 6th chord*/
    public static final ChordQuality min6(){
        return new ChordQuality("minor 6", "-6")
                .third(IntervalQuality.MINOR)
                .fifth( IntervalQuality.PERFECT)
                .extensionTone(6, IntervalQuality.MAJOR);
    }

    /**Major 6th chord*/
    public static final ChordQuality maj6(){
        return new ChordQuality("major 6", "maj6")
                .third(IntervalQuality.MAJOR)
                .fifth(IntervalQuality.PERFECT)
                .extensionTone(6, IntervalQuality.MAJOR);
    }

}
