package jnotes.core.notes;

public enum Alteration {
    SHARP(1), FLAT(-1), DOUBLE_SHARP(2), DOUBLE_FLAT(-2), NATURAL(0);

    public final int value;

    Alteration(int value) {
        this.value = value;
    }
}
