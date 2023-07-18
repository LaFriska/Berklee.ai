package jnotes.core.notes;

import jnotes.debug.MissingJavadoc;

@MissingJavadoc
public enum Alteration {
    SHARP(1), FLAT(-1), DOUBLE_SHARP(2), DOUBLE_FLAT(-2), NATURAL(0);

    public final int value;

    Alteration(int value) {
        this.value = value;
    }
}
