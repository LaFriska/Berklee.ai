package com.friska.jnotes.core.keys;

import com.friska.jnotes.core.intervals.Interval;
import com.friska.jnotes.core.intervals.IntervalQuality;

public class KeyQualities {

    private static final Interval m = new Interval(2, IntervalQuality.MINOR);
    private static final Interval M = new Interval(2, IntervalQuality.MAJOR);
    private static final Interval A = new Interval(2, IntervalQuality.AUGMENTED);

    public static KeyQuality major(){
        return new KeyQuality("major", M, M, m, M, M, M);
    }

    public static KeyQuality naturalMinor(){
        return new KeyQuality("minor", M, m, M, M, m, M);
    }

    public static KeyQuality harmonicMinor(){
        return new KeyQuality("harmonic minor", M, m, M, M, m, A);
    }

    public static KeyQuality melodicMinor(){
        return new KeyQuality("melodic minor", M, m, M, M, M, M);
    }

    //Other modes

    public static KeyQuality mixolydian(){
        return new KeyQuality("mixolydian", M, M, m, M, M, m);
    }

    public static KeyQuality lydian(){
        return new KeyQuality("lydian", M, M, M, m, M, M);
    }

    public static KeyQuality dorian(){
        return new KeyQuality("dorian", M, m, M, M, M, m);
    }

    public static KeyQuality phrygian(){
        return new KeyQuality("phrygian", m, M, M, M, m, M);
    }

    public static KeyQuality locrian(){
        return new KeyQuality("locrian", m, M, M, m, M, M);
    }
}
