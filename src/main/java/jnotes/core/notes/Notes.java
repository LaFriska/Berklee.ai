package jnotes.core.notes;

/**
 *The Notes class contains static Note instantiations of every note spelling possible.
 *For the sake of convenience, it is adviced to directly use a method from this class instead of creating a note
 *instantiation. Please note that the notes in this class are immutable, meaning that data like octave value can 
 * not be defined directly. For mutable notes, either manually instantiate them, or call the {@link Note#createMutableClone} method.
 * **/
public class Notes {

    public static final Note C = new Note(BaseNote.C, Alteration.NATURAL, true);
    public static final Note D = new Note(BaseNote.D, Alteration.NATURAL, true);
    public static final Note E = new Note(BaseNote.E, Alteration.NATURAL, true);
    public static final Note F = new Note(BaseNote.F, Alteration.NATURAL, true);
    public static final Note G = new Note(BaseNote.G, Alteration.NATURAL, true);
    public static final Note A = new Note(BaseNote.A, Alteration.NATURAL, true);
    public static final Note B = new Note(BaseNote.B, Alteration.NATURAL, true);


    public static final Note C_SHARP = new Note(BaseNote.C, Alteration.SHARP, true);
    public static final Note D_SHARP = new Note(BaseNote.D, Alteration.SHARP, true);
    public static final Note E_SHARP = new Note(BaseNote.E, Alteration.SHARP, true);
    public static final Note F_SHARP = new Note(BaseNote.F, Alteration.SHARP, true);
    public static final Note G_SHARP = new Note(BaseNote.G, Alteration.SHARP, true);
    public static final Note A_SHARP = new Note(BaseNote.A, Alteration.SHARP, true);
    public static final Note B_SHARP = new Note(BaseNote.B, Alteration.SHARP, true);

    public static final Note C_FLAT = new Note(BaseNote.C, Alteration.FLAT, true);
    public static final Note D_FLAT = new Note(BaseNote.D, Alteration.FLAT, true);
    public static final Note E_FLAT = new Note(BaseNote.E, Alteration.FLAT, true);
    public static final Note F_FLAT = new Note(BaseNote.F, Alteration.FLAT, true);
    public static final Note G_FLAT = new Note(BaseNote.G, Alteration.FLAT, true);
    public static final Note A_FLAT = new Note(BaseNote.A, Alteration.FLAT, true);
    public static final Note B_FLAT = new Note(BaseNote.B, Alteration.FLAT, true);

    public static final Note C_DOUBLE_SHARP = new Note(BaseNote.C, Alteration.DOUBLE_SHARP, true);
    public static final Note D_DOUBLE_SHARP = new Note(BaseNote.D, Alteration.DOUBLE_SHARP, true);
    public static final Note E_DOUBLE_SHARP = new Note(BaseNote.E, Alteration.DOUBLE_SHARP, true);
    public static final Note F_DOUBLE_SHARP = new Note(BaseNote.F, Alteration.DOUBLE_SHARP, true);
    public static final Note G_DOUBLE_SHARP = new Note(BaseNote.G, Alteration.DOUBLE_SHARP, true);
    public static final Note A_DOUBLE_SHARP = new Note(BaseNote.A, Alteration.DOUBLE_SHARP, true);
    public static final Note B_DOUBLE_SHARP = new Note(BaseNote.B, Alteration.DOUBLE_SHARP, true);

    public static final Note C_DOUBLE_FLAT = new Note(BaseNote.C, Alteration.DOUBLE_FLAT, true);
    public static final Note D_DOUBLE_FLAT = new Note(BaseNote.D, Alteration.DOUBLE_FLAT, true);
    public static final Note E_DOUBLE_FLAT = new Note(BaseNote.E, Alteration.DOUBLE_FLAT, true);
    public static final Note F_DOUBLE_FLAT = new Note(BaseNote.F, Alteration.DOUBLE_FLAT, true);
    public static final Note G_DOUBLE_FLAT = new Note(BaseNote.G, Alteration.DOUBLE_FLAT, true);
    public static final Note A_DOUBLE_FLAT = new Note(BaseNote.A, Alteration.DOUBLE_FLAT, true);
    public static final Note B_DOUBLE_FLAT = new Note(BaseNote.B, Alteration.DOUBLE_FLAT, true);

}
