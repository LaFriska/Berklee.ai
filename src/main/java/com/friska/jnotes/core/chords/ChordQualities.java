package com.friska.jnotes.core.chords;

import com.friska.jnotes.core.intervals.IntervalQuality;
import com.friska.jnotes.debug.MissingJavadoc;

@MissingJavadoc
public class ChordQualities {

    //TRIADS
    public static final ChordQuality major(){
        return new ChordQuality("major", "")
            .third(IntervalQuality.MAJOR)
            .fifth(IntervalQuality.PERFECT);
    }

    public static final ChordQuality minor(){
        return new ChordQuality("minor", "-")
                .third(IntervalQuality.MINOR)
                .fifth(IntervalQuality.PERFECT);
    }

    public static final ChordQuality diminished(){
        return new ChordQuality("diminished", "dim")
                .third(IntervalQuality.MINOR)
                .fifth(IntervalQuality.DIMINISHED);
    }

    public static final ChordQuality augmented(){
        return new ChordQuality("augmented", "+")
                .third(IntervalQuality.MAJOR)
                .fifth(IntervalQuality.AUGMENTED);
    }

    //SEVENTH CHORDS

    public static final ChordQuality majorSeven(){
        return new ChordQuality("major 7", "maj7")
                .third( IntervalQuality.MAJOR)
                .fifth( IntervalQuality.PERFECT)
                .extensionTone(7, IntervalQuality.MAJOR);
    }

    public static final ChordQuality dominantSeven(){
        return new ChordQuality("7", "7")
                .third( IntervalQuality.MAJOR)
                .fifth(IntervalQuality.PERFECT)
                .extensionTone(7, IntervalQuality.MINOR);
    }

    public static final ChordQuality minorSeven(){
        return new ChordQuality("minor 7", "-7")
                .third(IntervalQuality.MINOR)
                .fifth(IntervalQuality.PERFECT)
                .extensionTone(7, IntervalQuality.MINOR);
    }

    public static final ChordQuality minorMajorSeven(){
        return new ChordQuality("minor major 7", "-maj7")
                .third(IntervalQuality.MINOR)
                .fifth(IntervalQuality.PERFECT)
                .extensionTone(7, IntervalQuality.MAJOR);
    }

    public static final ChordQuality diminishedSeven(){
        return new ChordQuality("diminished 7", "dim7")
                .third(IntervalQuality.MINOR)
                .fifth(IntervalQuality.DIMINISHED)
                .extensionTone(6, IntervalQuality.MAJOR);
    }

    public static final ChordQuality minorSix(){
        return new ChordQuality("minor 6", "-6")
                .third(IntervalQuality.MINOR)
                .fifth( IntervalQuality.PERFECT)
                .extensionTone(6, IntervalQuality.MAJOR);
    }

    public static final ChordQuality majorSix(){
        return new ChordQuality("major 6", "maj6")
                .third(IntervalQuality.MAJOR)
                .fifth(IntervalQuality.PERFECT)
                .extensionTone(6, IntervalQuality.MAJOR);
    }

}
