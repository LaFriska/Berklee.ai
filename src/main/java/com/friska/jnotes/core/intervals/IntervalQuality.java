package com.friska.jnotes.core.intervals;

/**
 * This enumerator contains enum-represented descriptors and alterations of an interval.
 * Obscure and purely theoretical qualities are also included, such as the double/triple/quadruple altered
 * qualities. Even though quantuple altered qualities may be theoretically possible, they are excluded as it is
 * incredibly rare even in a purely theoretical context, and is practically useless, but would cause significant
 * complications to the JNotes library.
 *
 * @see Interval
 * **/
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
