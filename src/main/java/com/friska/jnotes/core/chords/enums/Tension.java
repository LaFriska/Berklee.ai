package com.friska.jnotes.core.chords.enums;

import com.friska.jnotes.core.intervals.Interval;
import com.friska.jnotes.core.intervals.IntervalQuality;
import com.friska.jnotes.debug.MissingJavadoc;
import org.jetbrains.annotations.NotNull;

@MissingJavadoc
public enum Tension {

    T9("9", 9, IntervalQuality.MAJOR),
    Tb9("♭9", 9, IntervalQuality.MINOR),
    Ts9("♯9", 9, IntervalQuality.AUGMENTED),

    T11("11", 11, IntervalQuality.PERFECT),
    Tb11("♭11", 11, IntervalQuality.DIMINISHED),
    Ts11("♯11", 11, IntervalQuality.AUGMENTED),

    T13("13", 13, IntervalQuality.MAJOR),
    Tb13("♭13", 13, IntervalQuality.MINOR),
    Ts13("♯13", 13, IntervalQuality.AUGMENTED),

    Tmaj7("maj7", 7, IntervalQuality.MAJOR),
    Tb5("♭5", 5, IntervalQuality.DIMINISHED),
    Ts5("♯5", 5, IntervalQuality.AUGMENTED)

    ;
    public final String notation;
    public final Interval interval;
    Tension(String notation, int intervalValue, @NotNull IntervalQuality quality){
        this.notation = notation;
        this.interval = new Interval(intervalValue, quality);
    }
}
