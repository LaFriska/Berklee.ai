package jnotes.core.notes;

import jnotes.debug.MissingJavadoc;

@MissingJavadoc
public enum Alteration {
    SHARP(1, "♯"),
    FLAT(-1, "♭"),
    DOUBLE_SHARP(2, "\uD834\uDD2A"),
    DOUBLE_FLAT(-2, "\uD834\uDD2B"),
    NATURAL(0, "♮");

    public final int value;

    public final String symbol;

    Alteration(int value, String symbol) {
        this.value = value;
        this.symbol = symbol;
    }
}
