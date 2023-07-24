package jnotes.core.intervals;

import jnotes.core.notes.BaseNote;
import jnotes.core.notes.Note;
import jnotes.debug.MissingJavadoc;
import jnotes.exceptions.IntervalException;
import org.jetbrains.annotations.NotNull;

public class IntervalCalculator {

    private final Note lower;
    private final Note upper;

    private final Interval interval;

    /**
     * This class finds the interval between two notes where their respective
     * octave values have been defined. Inputting notes with abstract octave values will
     * cause an exception to be thrown.
     *
     * @param lower Lower note of the two notes being compared. As the name suggests, the
     *              lower note must be enharmonically lower or equal to the upper note, or
     *              an exception will be thrown.
     * @param upper Upper note of the two notes being compared. Similarly to the lower note, the
     *              upper note should be enharmonically equal or higher than the lower note.
     * **/
    public IntervalCalculator(@NotNull Note lower, @NotNull Note upper){
        if(lower.isOctaveAbstract() || upper.isOctaveAbstract()) throw new IntervalException("Octaves cannot be abstract to process intervals");
        if(lower.getSemitonesNumber() > upper.getSemitonesNumber()) throw new IntervalException("Lower note cannot be higher than upper note.");
        this.lower = lower;
        this.upper = upper;
        int value = setValue();
        this.interval = new Interval(value, setQuality(value));
    }

    private int setValue() {
        return upper.getBaseNoteLabel() - lower.getBaseNoteLabel() + 1;
    }

    private IntervalQuality setQuality(int value) {
        //if(upperSem < lowerSem) upperSem = upperSem + 12;
        int diff = upper.getSemitonesNumber() - lower.getSemitonesNumber();

        switch(getModdedValue(value)){
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

    protected static int getModdedValue(int value){
        return (value - 1) % 7;
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

    @MissingJavadoc
    public int getDistance(){
        return getInterval().getDistance();
    }

    /**
     * @return Returns the interval value. For more information:
     * @see Interval
     * **/
    public int getValue() {
        return interval.getValue();
    }


    /**
     * @return Returns the interval quality. For more information:
     * @see Interval
     * **/
    public IntervalQuality getQuality() {
        return interval.getQuality();
    }

    /**
     * @return Returns the formatted name. For more information:
     * @see Interval
     * **/
    public String getFormattedName() {return interval.getFormattedName();}
    /**
     * @return Returns the calculated interval in its class form. For more information:
     * @see Interval
     * **/
    public Interval getInterval() {
        return interval;
    }

    /**
     * This toString() override simply returns the formatted name called from {@link IntervalCalculator#getFormattedName()}.
     * **/
    @Override
    public String toString() {
        return this.getFormattedName();
    }

    //---------------------------------------------STATIC--------------------------------------------------------//

    public static Note getNoteAbove(Note startingNote, Interval interval){
        //TODO add try catch incase note goes out of bound.
        if(startingNote.isOctaveAbstract()) throw new IntervalException("Octave must not be abstract for this method to run.");
        Note newBaseNote = BaseNote.get(startingNote.getBaseNoteLabel() + interval.getValue() - 1);
        int compare = new IntervalCalculator(startingNote, newBaseNote).getDistance();
        int diff = compare = interval.getDistance();

        return newBaseNote.getAltered(diff);
    }
}
