package com.friska.jnotes.core.intervals;

import com.friska.jnotes.core.ComparableElement;
import com.friska.jnotes.debug.MissingJavadoc;
import com.friska.jnotes.exceptions.IntervalException;
import org.jetbrains.annotations.NotNull;

public class Interval implements ComparableElement<Interval> {

    private final int value;
    private final IntervalQuality quality;
    private final String formattedName;

    /**
     * This class represents an abstract musical interval. In order to calculate the intervals between
     * two notes, see {@link IntervalCalculator}.
     *
     * @param value The value variable represents the numerical intervalic distance. For example, a
     *              unison interval will have a value of 1, a fifth will have a value of 5, and an octave
     *              will have a value of 8. Compound intervals may be represented by inputting a value beyond
     *              8.
     * <p>
     * @param quality The enumerated representation of the quality of an interval. The quality may be alterations
     *                like diminished or augmented, or harmonic descriptor like the major, minor or perfect. See
     *                {@link IntervalQuality} for a full list thereof.
     * **/
    public Interval(int value, @NotNull IntervalQuality quality){
        this.value = value;
        this.quality = quality;
        this.formattedName = formatName();
    }

    private String formatName(){

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

    /**
     * @return Returns a string of an appropriately formatted name of the interval.
     * **/
    public String getFormattedName(){
        return formattedName;
    }

    /**
     * @return Returns the interval value.
     * **/
    public int getValue() {
        return value;
    }

    /**
     * @return Returns the interval quality.
     * **/
    public IntervalQuality getQuality() {
        return quality;
    }


    /**
     * @return Returns the length of the interval in semitones. This method works for all intervals,
     * including compound intervals.
     * **/
    public int getDistance(){
        int valueCalc = this.value;
        int octaves = 0;
        while(valueCalc > 7){
            octaves++;
            valueCalc = valueCalc - 7;
        }
        octaves = octaves * 12;
        boolean perfectable = valueCalc == 1 || valueCalc == 4 || valueCalc == 5;
        valueCalc = getNonCompoundSemitones(perfectable, valueCalc);
        return octaves + valueCalc;
    }

    private int getNonCompoundSemitones(boolean perfectable, int value){
        switch (value){
            case 1 -> {value=0;}
            case 2 -> {value=2;}
            case 3 -> {value=4;}
            case 4 -> {value=5;}
            case 5 -> {value=7;}
            case 6 -> {value=9;}
            case 7 -> {value=11;}
            default -> throw new RuntimeException("Invalid input for value " + value + ".");
        }

        int alt = 0;

        switch (this.quality){
            case QUADRUPLE_AUGMENTED -> {alt = 4;}
            case TRIPLE_AUGMENTED -> {alt = 3;}
            case DOUBLE_AUGMENTED -> {alt = 2;}
            case AUGMENTED -> {alt = 1;}
            case MINOR -> {alt = -1;}
            case DIMINISHED -> {alt = perfectable ? -1 : -2;}
            case DOUBLE_DIMINISHED -> {alt = perfectable ? -2 : -3;}
            case TRIPLE_DIMINISHED -> {alt = perfectable ? -3 : -4;}
            case QUADRUPLE_DIMINISHED -> {alt = perfectable ? -4 : -5;}
        }
        return value + alt;
    }

    /**
     * Returns whether this interval is exactly equal to another interval. This means not only
     * do these intervals have to equal enharmonically, their interval quality as well as their
     * value must be equal. For example, an augmented fourth in this case will not return true
     * when compared with a diminished fifth, as though they are enharmonically equal, they are
     * not equal. This example however, will return true for {@link Interval#equalsEnharmonically(Interval)}.
     * **/
    @Override
    public boolean equals(Interval interval) {
        return this.value == interval.value && this.quality.equals(interval.quality);
    }

    /**
     * Returns true as long as this interval is enharmonically equal to the interval compared. For a more
     * accurate comparison, use {@link Interval#equals(Interval)}. This method compares the distance
     * value between the two intervals. Therefore, this method is slightly less efficient, and should be
     * considered before use in computationally intensive tasks.
     */
    @Override
    public boolean equalsEnharmonically(Interval interval) {
        return this.getDistance() == interval.getDistance();
    }
}
