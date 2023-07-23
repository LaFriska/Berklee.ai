package jnotes.core.notes;

import jnotes.debug.MissingJavadoc;
import jnotes.exceptions.BaseNoteException;

@MissingJavadoc
public enum BaseNote {

    C(1, 1),
    D(3, 2),
    E(5, 3),
    F(6, 4),
    G(8, 5),
    A(10, 6),
    B(12, 7);

    public final int value;

    public final int solfeggeValue;

    public static final Note[] BASE_NOTES = new Note[]{
            new Note(BaseNote.A, Alteration.NATURAL).setOctave(0),
            new Note(BaseNote.B, Alteration.NATURAL).setOctave(0),
            new Note(BaseNote.C, Alteration.NATURAL).setOctave(1),
            new Note(BaseNote.D, Alteration.NATURAL).setOctave(1),
            new Note(BaseNote.E, Alteration.NATURAL).setOctave(1),
            new Note(BaseNote.F, Alteration.NATURAL).setOctave(1),
            new Note(BaseNote.G, Alteration.NATURAL).setOctave(1),
            new Note(BaseNote.A, Alteration.NATURAL).setOctave(1),
            new Note(BaseNote.B, Alteration.NATURAL).setOctave(1),
            new Note(BaseNote.C, Alteration.NATURAL).setOctave(2),
            new Note(BaseNote.D, Alteration.NATURAL).setOctave(2),
            new Note(BaseNote.E, Alteration.NATURAL).setOctave(2),
            new Note(BaseNote.F, Alteration.NATURAL).setOctave(2),
            new Note(BaseNote.G, Alteration.NATURAL).setOctave(2),
            new Note(BaseNote.A, Alteration.NATURAL).setOctave(2),
            new Note(BaseNote.B, Alteration.NATURAL).setOctave(2),
            new Note(BaseNote.C, Alteration.NATURAL).setOctave(3),
            new Note(BaseNote.D, Alteration.NATURAL).setOctave(3),
            new Note(BaseNote.E, Alteration.NATURAL).setOctave(3),
            new Note(BaseNote.F, Alteration.NATURAL).setOctave(3),
            new Note(BaseNote.G, Alteration.NATURAL).setOctave(3),
            new Note(BaseNote.A, Alteration.NATURAL).setOctave(3),
            new Note(BaseNote.B, Alteration.NATURAL).setOctave(3),
            new Note(BaseNote.C, Alteration.NATURAL).setOctave(4),
            new Note(BaseNote.D, Alteration.NATURAL).setOctave(4),
            new Note(BaseNote.E, Alteration.NATURAL).setOctave(4),
            new Note(BaseNote.F, Alteration.NATURAL).setOctave(4),
            new Note(BaseNote.G, Alteration.NATURAL).setOctave(4),
            new Note(BaseNote.A, Alteration.NATURAL).setOctave(4),
            new Note(BaseNote.B, Alteration.NATURAL).setOctave(4),
            new Note(BaseNote.C, Alteration.NATURAL).setOctave(5),
            new Note(BaseNote.D, Alteration.NATURAL).setOctave(5),
            new Note(BaseNote.E, Alteration.NATURAL).setOctave(5),
            new Note(BaseNote.F, Alteration.NATURAL).setOctave(5),
            new Note(BaseNote.G, Alteration.NATURAL).setOctave(5),
            new Note(BaseNote.A, Alteration.NATURAL).setOctave(5),
            new Note(BaseNote.B, Alteration.NATURAL).setOctave(5),
            new Note(BaseNote.C, Alteration.NATURAL).setOctave(6),
            new Note(BaseNote.D, Alteration.NATURAL).setOctave(6),
            new Note(BaseNote.E, Alteration.NATURAL).setOctave(6),
            new Note(BaseNote.F, Alteration.NATURAL).setOctave(6),
            new Note(BaseNote.G, Alteration.NATURAL).setOctave(6),
            new Note(BaseNote.A, Alteration.NATURAL).setOctave(6),
            new Note(BaseNote.B, Alteration.NATURAL).setOctave(6),
            new Note(BaseNote.C, Alteration.NATURAL).setOctave(7),
            new Note(BaseNote.D, Alteration.NATURAL).setOctave(7),
            new Note(BaseNote.E, Alteration.NATURAL).setOctave(7),
            new Note(BaseNote.F, Alteration.NATURAL).setOctave(7),
            new Note(BaseNote.G, Alteration.NATURAL).setOctave(7),
            new Note(BaseNote.A, Alteration.NATURAL).setOctave(7),
            new Note(BaseNote.B, Alteration.NATURAL).setOctave(7),
            new Note(BaseNote.C, Alteration.NATURAL).setOctave(8),
    };

    public static Note get(int label){
        try {
            return BASE_NOTES[label - 1];
        }catch (ArrayIndexOutOfBoundsException e){
            throw new BaseNoteException("Invalid label number.");
        }
    }

    BaseNote(int value, int solfeggeValue) {
        this.value = value;
        this.solfeggeValue = solfeggeValue;
    }

    public static BaseNote getNoteBaseFromSolfegge(int solfeggeValue){
        switch (solfeggeValue){
            case 1 -> {return C;}
            case 2 -> {return D;}
            case 3 -> {return E;}
            case 4 -> {return F;}
            case 5 -> {return G;}
            case 6 -> {return A;}
            case 7 -> {return B;}
            default -> throw new BaseNoteException("Unknown solfegge value " + solfeggeValue +".");
        }
    }
}
