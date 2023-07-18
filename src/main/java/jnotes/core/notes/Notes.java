package jnotes.core.notes;

import jnotes.debug.MissingJavadoc;

/**
 *The Notes class contains static Note instantiations of every note spelling possible.
 *For the sake of convenience, it is adviced to directly use a method from this class instead of creating a note
 *instantiation.
 * **/
public class Notes {

    public static final Note C = new Note(NoteBase.C);
    public static final Note D = new Note(NoteBase.D);
    public static final Note E = new Note(NoteBase.E);
    public static final Note F = new Note(NoteBase.F);
    public static final Note G = new Note(NoteBase.G);
    public static final Note A = new Note(NoteBase.A);
    public static final Note B = new Note(NoteBase.B);


    public static final Note C_SHARP = new Note(NoteBase.C, Alteration.SHARP);
    public static final Note D_SHARP = new Note(NoteBase.D, Alteration.SHARP);
    public static final Note E_SHARP = new Note(NoteBase.E, Alteration.SHARP);
    public static final Note F_SHARP = new Note(NoteBase.F, Alteration.SHARP);
    public static final Note G_SHARP = new Note(NoteBase.G, Alteration.SHARP);
    public static final Note A_SHARP = new Note(NoteBase.A, Alteration.SHARP);
    public static final Note B_SHARP = new Note(NoteBase.B, Alteration.SHARP);

    public static final Note C_FLAT = new Note(NoteBase.C, Alteration.FLAT);
    public static final Note D_FLAT = new Note(NoteBase.D, Alteration.FLAT);
    public static final Note E_FLAT = new Note(NoteBase.E, Alteration.FLAT);
    public static final Note F_FLAT = new Note(NoteBase.F, Alteration.FLAT);
    public static final Note G_FLAT = new Note(NoteBase.G, Alteration.FLAT);
    public static final Note A_FLAT = new Note(NoteBase.A, Alteration.FLAT);
    public static final Note B_FLAT = new Note(NoteBase.B, Alteration.FLAT);

    public static final Note C_DOUBLE_SHARP = new Note(NoteBase.C, Alteration.DOUBLE_SHARP);
    public static final Note D_DOUBLE_SHARP = new Note(NoteBase.D, Alteration.DOUBLE_SHARP);
    public static final Note E_DOUBLE_SHARP = new Note(NoteBase.E, Alteration.DOUBLE_SHARP);
    public static final Note F_DOUBLE_SHARP = new Note(NoteBase.F, Alteration.DOUBLE_SHARP);
    public static final Note G_DOUBLE_SHARP = new Note(NoteBase.G, Alteration.DOUBLE_SHARP);
    public static final Note A_DOUBLE_SHARP = new Note(NoteBase.A, Alteration.DOUBLE_SHARP);
    public static final Note B_DOUBLE_SHARP = new Note(NoteBase.B, Alteration.DOUBLE_SHARP);

    public static final Note C_DOUBLE_FLAT = new Note(NoteBase.C, Alteration.DOUBLE_FLAT);
    public static final Note D_DOUBLE_FLAT = new Note(NoteBase.D, Alteration.DOUBLE_FLAT);
    public static final Note E_DOUBLE_FLAT = new Note(NoteBase.E, Alteration.DOUBLE_FLAT);
    public static final Note F_DOUBLE_FLAT = new Note(NoteBase.F, Alteration.DOUBLE_FLAT);
    public static final Note G_DOUBLE_FLAT = new Note(NoteBase.G, Alteration.DOUBLE_FLAT);
    public static final Note A_DOUBLE_FLAT = new Note(NoteBase.A, Alteration.DOUBLE_FLAT);
    public static final Note B_DOUBLE_FLAT = new Note(NoteBase.B, Alteration.DOUBLE_FLAT);

}
