package jnotes.core.util;

import jnotes.core.notes.NoteBase;
import jnotes.debug.MissingJavadoc;
import jnotes.exceptions.NoteOctaveException;

@MissingJavadoc
public class NoteUtils {

    public static int getSemitonesNumber(int octaveValue, int noteValue){
        checkOctaveRange(octaveValue, noteValue);
        return 3 + ((octaveValue - 1) * 12) + noteValue;
    }

    public static int getBaseNoteNumber(int octaveValue, int noteValue, NoteBase noteBase){
        checkOctaveRange(octaveValue, noteValue);
        return 2 + ((octaveValue - 1) * 7) + noteBase.solfeggeValue;
    }

    public static boolean checkOctaveRange(int octaveValue, int noteValue){

        int lowBound;
        int highBound;

        switch (noteValue) {
            case 10, 11, 12 -> {
                lowBound = 0;
                highBound = 7;
            }
            case 1 -> {
                lowBound = 1;
                highBound = 8;
            }
            default -> {
                lowBound = 1;
                highBound = 7;
            }
        }

        if(octaveValue < lowBound) throw new NoteOctaveException("Octave value for this note must be atleast " + lowBound + ".");
        if(octaveValue > highBound) throw new NoteOctaveException("Octave value for this note cannot exceed " + highBound + ".");

        return true;
    }
}
