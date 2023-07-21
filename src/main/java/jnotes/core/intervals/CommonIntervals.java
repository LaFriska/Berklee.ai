package jnotes.core.intervals;

import jnotes.debug.MissingJavadoc;

@MissingJavadoc
public enum CommonIntervals {

    UNISON("Unison"),
    AUGMENTED_UNISON("Augmented Unison"),
    DIMINISHED_SECOND("Diminished 2nd"),
    MINOR_SECOND("Minor 2nd"),
    MAJOR_SECOND("Major 2nd"),
    AUGMENTED_SECOND("Augmented 2nd"),
    DIMINISHED_THIRD("Diminished 3rd"),
    MINOR_THIRD("Minor 3rd"),
    MAJOR_THIRD("Major 3rd"),
    AUGMENTED_THIRD("Augmented 3rd"),
    DIMINISHED_FOURTH("Diminished 4th"),
    PERFECT_FOURTH("Perfect 4th"),
    AUGMENTED_FOURTH("Augmented 4th"),
    DIMINISHED_FIFTH("Diminished 5th"),
    PERFECT_FIFTH("Perfect 5th"),
    AUGMENTED_FIFTH("Augmented 5th"),
    DIMINISHED_SIXTH("Diminished 6th"),
    MINOR_SIXTH("Minor 6th"),
    MAJOR_SIXTH("Major 6th"),
    AUGMENTED_SIXTH("Augmented 6th"),
    DIMINISHED_SEVENTH("Diminished 7th"),
    MINOR_SEVENTH("Minor 7th"),
    MAJOR_SEVENTH("Major 7th"),
    AUGMENTED_SEVENTH("Augmented 7th"),
    DIMINISHED_OCTAVE("Diminished Octave"),
    OCTAVE("Octave"),
    AUGMENTED_OCTAVE("Augmented Octave")

    ;
    public final String formattedName;
    CommonIntervals(String formattedName){
        this.formattedName = formattedName;
    }

}
