package jnotes.core.notes;

import jnotes.debug.MissingJavadoc;

@MissingJavadoc
public enum NoteBase{

    C(1, 1),
    D(3, 2),
    E(5, 3),
    F(6, 4),
    G(8, 5),
    A(10, 6),
    B(12, 7);

    public final int value;

    public final int solfeggeValue;

    NoteBase(int value, int solfeggeValue) {
        this.value = value;
        this.solfeggeValue = solfeggeValue;
    }
}
