package jnotes.core.intervals;

import jnotes.exceptions.IntervalException;
import org.jetbrains.annotations.NotNull;

public class Interval {

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
}
