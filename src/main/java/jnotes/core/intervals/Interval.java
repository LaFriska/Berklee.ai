package jnotes.core.intervals;

import jnotes.core.notes.Note;
import jnotes.core.util.NoteUtils;
import jnotes.debug.MissingJavadoc;
import jnotes.exceptions.IntervalException;

@MissingJavadoc
public class Interval {

    private final boolean isOctaveAbstract;

    private final Note lower;
    private final Note upper;

    private int value;
    private IntervalQuality quality;

    public Interval(Note note1, Note note2){
        if(note1.isOctaveAbstract() != note2.isOctaveAbstract()) throw new IntervalException("One note has abstract octave while the other has not. Make the octave value for the notes are either both defined or both abstract.");
        isOctaveAbstract = note1.isOctaveAbstract();

        float comparator1 = isOctaveAbstract ? note1.getOctaveValue() : NoteUtils.getSemitonesNumber(note1.getOctaveValue(), note1.getValue());
        float comparator2 = isOctaveAbstract ? note2.getOctaveValue() : NoteUtils.getSemitonesNumber(note2.getOctaveValue(), note2.getValue());

        if(comparator1 < comparator2) {
            lower = note1;
            upper = note2;
        }else{
            lower = note2;
            upper = note1;
        }
    }

    public void setValue() {

        if(isOctaveAbstract){
            int lowerNBValue = lower.getNoteBase().solfeggeValue;
            int upperNBValue = upper.getNoteBase().solfeggeValue;
            if(upperNBValue < lowerNBValue) upperNBValue = upperNBValue + 12;
            this.value = upperNBValue - lowerNBValue + 1;
        }

    }
}
