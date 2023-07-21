package jnotes.core.intervals;

import jnotes.core.notes.Note;
import jnotes.debug.MissingJavadoc;
import jnotes.exceptions.IntervalException;

@MissingJavadoc
public class Interval {

    private final Note lower;
    private final Note upper;

    private int value;
    private IntervalQuality quality;
    private String formattedName;

    public Interval(Note lower, Note upper){
        if(lower.isOctaveAbstract() || upper.isOctaveAbstract()) throw new IntervalException("Octaves cannot be abstract to process intervals");
        if(lower.getSemitonesNumber() > upper.getSemitonesNumber()) throw new IntervalException("Lower note cannot be higher than upper note.");
        this.lower = lower;
        this.upper = upper;
        this.value = setValue();
        this.quality = setQuality();
        this.formattedName = setFormattedName();
    }

    private int setValue() {
        return upper.getBaseNoteNumber() - lower.getBaseNoteNumber() + 1;
    }

    private IntervalQuality setQuality() {
        //if(upperSem < lowerSem) upperSem = upperSem + 12;
        int diff = upper.getSemitonesNumber() - lower.getSemitonesNumber();

        switch((value - 1) % 7){
            case 0 -> {return mapQuality(true, -4, diff);}
            case 1 -> {return mapQuality(false, -3, diff);}
            case 2 -> {return mapQuality(false, -1, diff);}
            case 3 -> {return mapQuality(true, 1, diff); }
            case 4 -> {return mapQuality(true, 3, diff); }
            case 5 -> {return mapQuality(false, 4, diff);}
            case 6 -> {return mapQuality(false, 6, diff);}
            default -> throw new IntervalException("Cannot process interval value of " + value + ".");
        }
    }

    private IntervalQuality mapQuality(boolean perfectable, int startingDiff, int diff){
        String exceptionMsg = "Cannot find quality of an interval " + diff + " semitones apart with notes " + lower.getSpelling() + " and " + upper.getSpelling() + ".";
        if(perfectable){
            switch ((diff - startingDiff) % 12){
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
            //System.out.println(diff + "|" + startingDiff);
            switch ((diff - startingDiff) % 12){
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

    private String setFormattedName(){

        String formattedValue;
        int mod = value % 10;
        boolean omitQuality = false;

        if(value == 1){
            formattedValue = "Unison";
            if(quality == IntervalQuality.PERFECT) omitQuality = true;
        }else if(value == 8) {
            formattedValue = "Octave";
            if (quality == IntervalQuality.PERFECT) omitQuality = true;
        }else if (value == 3){
            formattedValue = value + "rd";
        }else if(value == 11 || value == 12 || mod == 0 || mod == 4 || mod == 5 || mod == 6 || mod == 7 || mod == 8 || mod == 9 || mod == 3){
            formattedValue = value + "th";
        } else if(mod == 1){
            formattedValue = value + "st";
        }else if(mod == 2){
            formattedValue = value + "nd";
        }else throw new IntervalException("Cannot set formatted name for interval value " + value + ".");

        return omitQuality ? formattedValue : quality.format + " " + formattedValue;
    }
    public int getValue() {
        return value;
    }

    public IntervalQuality getQuality() {
        return quality;
    }

    public String getFormattedName() {
        return formattedName;
    }

    @Override
    public String toString() {
        return this.getFormattedName();
    }
}
