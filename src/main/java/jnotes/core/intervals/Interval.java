package jnotes.core.intervals;

import jnotes.core.notes.Note;
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

        if(isOctaveAbstract){
            lower = note1;
            upper = note2;
        }else if(Note.getSemitonesNumber(note1.getOctaveValue(), note1.getValue()) < Note.getSemitonesNumber(note2.getOctaveValue(), note2.getValue())) {
            lower = note1;
            upper = note2;
        }else{
            lower = note2;
            upper = note1;
        }
        this.value = setValue();
        this.quality = setQuality();
    }

    private int setValue() {

        int value;

        if(isOctaveAbstract){
            int lowerNBValue = lower.getNoteBase().solfeggeValue;
            int upperNBValue = upper.getNoteBase().solfeggeValue;
            if(upperNBValue < lowerNBValue) upperNBValue = upperNBValue + 7;
            value = upperNBValue - lowerNBValue + 1;
            return value;
        }

        int upperBase = Note.getBaseNoteNumber(upper.getOctaveValue(), upper.getValue(), upper.getNoteBase());
        int lowerBase = Note.getBaseNoteNumber(lower.getOctaveValue(), lower.getValue(), lower.getNoteBase());

        return upperBase - lowerBase + 1;
    }

    private IntervalQuality setQuality() {

        int upperSem = getComparator(upper);
        int lowerSem = getComparator(lower);
        int diff = upperSem - lowerSem;

        switch(value){
            case 1 -> {return mapQuality(true, -4, diff);}
            case 2 -> {return mapQuality(false, -3, diff);}
            case 3 -> {return mapQuality(false, -1, diff);}
            case 4 -> {return mapQuality(true, 1, diff); }
            case 5 -> {return mapQuality(true, 3, diff); }
            case 6 -> {return mapQuality(false, 4, diff);}
            case 7 -> {return mapQuality(false, 6, diff);}
            default -> throw new IntervalException("Cannot process interval value of " + value + ".");
        }
    }

    private IntervalQuality mapQuality(boolean perfectable, int startingDiff, int diff){
        String exceptionMsg = "Cannot find quality of an interval" + diff + " semitones apart with notes " + lower.getSpelling() + " and " + upper.getSpelling() + ".";
        if(perfectable){
            switch (diff - startingDiff){
                case 0 -> {return IntervalQuality.QUADRUPLE_DIMINISHED;}
                case 1 -> {return IntervalQuality.TRIPLE_DIMINISHED;}
                case 2 -> {return IntervalQuality.DOUBLE_DIMINISHED;}
                case 3 -> {return IntervalQuality.DIMINISHED;}
                case 4 -> {return IntervalQuality.PERFECT;}
                case 5 -> {return IntervalQuality.AUGMENTED;}
                case 6 -> {return IntervalQuality.DOUBLE_AUGMENTED;}
                case 7 -> {return IntervalQuality.TRIPLE_AUGMENTED;}
                case 8 -> {return IntervalQuality.QUADRUPLE_AUGMENTED;}
                default -> throw new IntervalException(exceptionMsg);
            }
        }else{
            switch (diff - startingDiff){
                case 0 -> {return IntervalQuality.QUADRUPLE_DIMINISHED;}
                case 1 -> {return IntervalQuality.TRIPLE_DIMINISHED;}
                case 2 -> {return IntervalQuality.DOUBLE_DIMINISHED;}
                case 3 -> {return IntervalQuality.DIMINISHED;}
                case 4 -> {return IntervalQuality.MINOR;}
                case 5 -> {return IntervalQuality.MAJOR;}
                case 6 -> {return IntervalQuality.AUGMENTED;}
                case 7 -> {return IntervalQuality.DOUBLE_AUGMENTED;}
                case 8 -> {return IntervalQuality.TRIPLE_AUGMENTED;}
                case 9 -> {return IntervalQuality.QUADRUPLE_AUGMENTED;}
                default -> throw new IntervalException(exceptionMsg);
            }
        }
    }

    private int getComparator(Note note){
        return isOctaveAbstract ?
                note.getNoteBase().value + note.getAlteration().value
              : Note.getSemitonesNumber(note.getOctaveValue(), note.getValue());
    }

    public int getValue() {
        return value;
    }

    public IntervalQuality getQuality() {
        return quality;
    }
}
