package jnotes.core.notes;

import jnotes.debug.MissingJavadoc;

/**
 *The Notes class contains static Note instantiations of every note spelling possible.
 *For the sake of convenience, it is adviced to directly use a method from this class instead of creating a note
 *instantiation. Please note that the notes in this class are immutable, meaning that data like octave value can 
 * not be defined directly. For mutable notes, either manually instantiate them, or call the {@link Note#createMutableClone} method.
 * **/
public class Notes {

    public static final Note C = new Note(NoteBase.C, Alteration.NATURAL, true);
    public static final Note D = new Note(NoteBase.D, Alteration.NATURAL, true);
    public static final Note E = new Note(NoteBase.E, Alteration.NATURAL, true);
    public static final Note F = new Note(NoteBase.F, Alteration.NATURAL, true);
    public static final Note G = new Note(NoteBase.G, Alteration.NATURAL, true);
    public static final Note A = new Note(NoteBase.A, Alteration.NATURAL, true);
    public static final Note B = new Note(NoteBase.B, Alteration.NATURAL, true);


    public static final Note C_SHARP = new Note(NoteBase.C, Alteration.SHARP, true);
    public static final Note D_SHARP = new Note(NoteBase.D, Alteration.SHARP, true);
    public static final Note E_SHARP = new Note(NoteBase.E, Alteration.SHARP, true);
    public static final Note F_SHARP = new Note(NoteBase.F, Alteration.SHARP, true);
    public static final Note G_SHARP = new Note(NoteBase.G, Alteration.SHARP, true);
    public static final Note A_SHARP = new Note(NoteBase.A, Alteration.SHARP, true);
    public static final Note B_SHARP = new Note(NoteBase.B, Alteration.SHARP, true);

    public static final Note C_FLAT = new Note(NoteBase.C, Alteration.FLAT, true);
    public static final Note D_FLAT = new Note(NoteBase.D, Alteration.FLAT, true);
    public static final Note E_FLAT = new Note(NoteBase.E, Alteration.FLAT, true);
    public static final Note F_FLAT = new Note(NoteBase.F, Alteration.FLAT, true);
    public static final Note G_FLAT = new Note(NoteBase.G, Alteration.FLAT, true);
    public static final Note A_FLAT = new Note(NoteBase.A, Alteration.FLAT, true);
    public static final Note B_FLAT = new Note(NoteBase.B, Alteration.FLAT, true);

    public static final Note C_DOUBLE_SHARP = new Note(NoteBase.C, Alteration.DOUBLE_SHARP, true);
    public static final Note D_DOUBLE_SHARP = new Note(NoteBase.D, Alteration.DOUBLE_SHARP, true);
    public static final Note E_DOUBLE_SHARP = new Note(NoteBase.E, Alteration.DOUBLE_SHARP, true);
    public static final Note F_DOUBLE_SHARP = new Note(NoteBase.F, Alteration.DOUBLE_SHARP, true);
    public static final Note G_DOUBLE_SHARP = new Note(NoteBase.G, Alteration.DOUBLE_SHARP, true);
    public static final Note A_DOUBLE_SHARP = new Note(NoteBase.A, Alteration.DOUBLE_SHARP, true);
    public static final Note B_DOUBLE_SHARP = new Note(NoteBase.B, Alteration.DOUBLE_SHARP, true);

    public static final Note C_DOUBLE_FLAT = new Note(NoteBase.C, Alteration.DOUBLE_FLAT, true);
    public static final Note D_DOUBLE_FLAT = new Note(NoteBase.D, Alteration.DOUBLE_FLAT, true);
    public static final Note E_DOUBLE_FLAT = new Note(NoteBase.E, Alteration.DOUBLE_FLAT, true);
    public static final Note F_DOUBLE_FLAT = new Note(NoteBase.F, Alteration.DOUBLE_FLAT, true);
    public static final Note G_DOUBLE_FLAT = new Note(NoteBase.G, Alteration.DOUBLE_FLAT, true);
    public static final Note A_DOUBLE_FLAT = new Note(NoteBase.A, Alteration.DOUBLE_FLAT, true);
    public static final Note B_DOUBLE_FLAT = new Note(NoteBase.B, Alteration.DOUBLE_FLAT, true);

}
