package jnotes.core.intervals;

import jnotes.debug.MissingJavadoc;

@MissingJavadoc
public enum IntervalQuality {
    MAJOR("Major"),
    MINOR("Minor"),
    DIMINISHED("Diminished"),
    AUGMENTED("Augmented"),
    PERFECT("Perfect"),

    //Theoretically possible intervals that is seldom used practically

    DOUBLE_DIMINISHED("Double Diminished"),
    DOUBLE_AUGMENTED("Double Augmented"),
    TRIPLE_DIMINISHED("Triple Diminished"),
    TRIPLE_AUGMENTED("Triple Augmented"),
    QUADRUPLE_DIMINISHED("Quadruple Diminished"),
    QUADRUPLE_AUGMENTED("Quadruple Augmented");

    public final String format;

    IntervalQuality(String format){
        this.format = format;
    }

}
