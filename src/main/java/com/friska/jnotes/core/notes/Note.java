package com.friska.jnotes.core.notes;

import com.friska.jnotes.core.ComparableElement;
import com.friska.jnotes.core.LilyCode;
import com.friska.jnotes.core.intervals.Interval;
import com.friska.jnotes.core.intervals.IntervalCalculator;
import com.friska.jnotes.core.intervals.IntervalQuality;
import com.friska.jnotes.exceptions.AlterationException;
import com.friska.jnotes.exceptions.BaseNoteException;
import com.friska.jnotes.exceptions.IntervalException;
import com.friska.jnotes.exceptions.NoteOctaveException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class Note implements ComparableElement<Note>, LilyCode {

    private final BaseNote baseNote;
    private Alteration alteration;

    private final int value;
    private int octaveValue = -1; //Abstract octave can be set to -1

    private final boolean immutable;

    protected Note(@NotNull BaseNote baseNote, Alteration alteration, boolean immutable){
        int value;
        this.baseNote = baseNote;
        if(alteration == null) this.alteration = Alteration.NATURAL;
        else this.alteration = alteration;
        //Modulo 12 to get note values to stay in GF(12)
        value = (baseNote.value + this.alteration.value) % 12;
        if(value <= 0) value = 12 + value;
        this.value = value;
        this.immutable = immutable;
    }

    /**
     * This object creates an abstraction for a musical note.
     * Data such as the spelling and pitch value are to be stored in this object.
     *
     * @param baseNote Base note without any accidentals.
     * @param alteration Alterations such as a sharp, double sharp or a flat to the base note.
     * **/
    public Note(@NotNull BaseNote baseNote, Alteration alteration){
        this(baseNote, alteration, false);
    }

    /**
     * This object creates an abstraction for a musical note.
     * Data such as the spelling and pitch value are to be stored in this object.
     *
     * @param baseNote Base note without any accidentals.
     * **/
    public Note(BaseNote baseNote){
        this(baseNote, Alteration.NATURAL);
    }

    /**
     * Returns the position of the note on the piano. Inputting a note without a defined octave
     * value will cause an exception.
     * **/
    public int getSemitonesNumber(){
        if(isOctaveAbstract()) throw new NoteOctaveException("Cannot get semitone number of a note without a defined octave number.");
        checkOctaveRange(octaveValue, baseNote.value);
        return 3 + ((octaveValue - 1) * 12) + (baseNote.value + alteration.value);
    }

    /**
     * Returns the white note position of the base note on the piano. Inputting a note without a defined octave
     * value will cause an exception.
     * **/
    public int getBaseNoteLabel(){
        if(isOctaveAbstract()) throw new BaseNoteException("Cannot find base note label of a note with abstract octave.");
        return (7 * (getOctaveValue() - 1)) + baseNote.solfeggeValue + 2;
    }

    /**
     * Ensures that the range of the octave is appropriate for the
     * note value given. If otherwise, an exception will be thrown.
     *
     * @return Returns true when no exceptions are thrown.
     * **/
    public static boolean checkOctaveRange(int octaveValue, int noteBaseValue){

        int lowBound;
        int highBound;

        switch (noteBaseValue) {
            case 10, 12 -> {
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

    /**
     * @return Returns the note base represented by an enum.
     * **/
    public BaseNote getBaseNote() {
        return baseNote;
    }

    /**
     * @return Returns the alteration (accidental) represented by an enum.
     * **/
    public Alteration getAlteration() {
        return alteration;
    }

    /**
     * Returns the note value. A note value is an integer within the domain of 0 < X <= 12
     * being able to map all 12 musical notes on the keyboard from 1 to 12 in ascending order
     * starting from C. For example, D# and Eb are both identified as note value 3.
     * **/
    public int getValue() {
        return value;
    }

    /**
     * Returns true if the note compared is enharmonically the same as the note this method is called from.
     * This means that as long as the pitch value of the notes are equal
     * (assuming that they are in the same octave) then this method returns true. This method simply
     * checks whether the note values are equal. For a description of note values, see {@link Note#getValue}.
     * For a method that returns true only if the notes are spelled the same, see the {@link Note#equals} method.
     * */
    @Override
    public boolean equalsEnharmonically(Note note){
        return note.getValue() == this.getValue();
    }

    /**
    * Returns a true if the note compared is, and spelled the same as the note this method is called from.
     * This means that the note base, and alteration should all be the equal for this method to
     * return true. For a method that returns true as long as the notes compared are
     * equal enharmonically, see the {@link Note#equalsEnharmonically} method.
    * */
    @Override
    public boolean equals(Note note){
        return equalsEnharmonically(note)
                && note.getBaseNote() == this.getBaseNote()
                && note.getAlteration() == this.getAlteration();
    }

    public Note abstractOctave(){
        this.octaveValue = -1;
        return this;
    }

    /**
     * Defines the octave for this note. Upon instantiation, the octave value is by default
     * set to -1, meaning that is abstract. This method however, sets the note to a specific octave
     * and thus, a specific pitch. To re-abstract the octave value, call {@link Note#abstractOctave()}.
     * Calling this method enables the {@link Note#getHertz()} method to return the Hertz pitch value of
     * the note.
     * <p>
     * @param octaveValue To set an octave, enter an integer value as such in the standard note notation. For example, if
     * this note is C, entering 3 into this method will make it a C3. Entering an integer outside the musical pitch range will cause an exception.
     * **/
    public Note setOctave(int octaveValue){
        checkOctaveRange(octaveValue, baseNote.value);
        if(immutable) return this.createMutableClone().setOctave(octaveValue);
        this.octaveValue = octaveValue;
        return this;
    }

    /**
     * Creates a clone of a note that is immutable, so that certain parameters in the note can
     * be changed.
     * **/
    public Note createMutableClone(){
        return isOctaveAbstract() ? new Note(baseNote, alteration) : new Note(baseNote, alteration).setOctave(octaveValue);
    }

    /**
     * Returns the octave value, when undefined, it is abstract and thus would return -1.
     * For a full explanation of the octave value, see {@link Note#setOctave}.
     * **/
    public int getOctaveValue() {
        return octaveValue;
    }

    /**
     * Returns whether the octave is abstract, i.e. if the octave value had not yet been defined.
     * **/
    public boolean isOctaveAbstract(){
        return octaveValue == -1;
    }

    /**
     * Returns the specific pitch in Hertz of the note. An exception will be thrown if the octave is not defined;
     * thus, the {@link Note#setOctave} method must be called before calling this method.
     * <p>
     * This method uses the octave value and note value of the note to calculate the number of semitones above
     * the theoretical C0 note, which is represented by a Hertz constant of approximately 16.35. This constant is used
     * in an exponential equation where ever 12 semitones (i.e. an octave) the Hertz value doubles.
     * **/
    public float getHertz(){
        if(octaveValue == -1) throw new NoteOctaveException("Cannot return Hertz value of a note with an abstract octave number.");
        return (float) (16.351597831287414 * Math.pow(2, (float) (octaveValue * 12 + (getValue() - 1)) / 12));
    }

    /**
     * Returns a string with the correct chord spelling.
     * 
     * @param includeOctave If true, the note spelling will include the octave
     *                      value at the end. For example, a note spelling with an octave 
     *                      value would be C7, while one without would be just C.
     * **/
    public String getSpelling(boolean includeOctave){
        if(includeOctave && isOctaveAbstract()) return getSpelling();
        StringBuilder spelling = new StringBuilder();
        spelling.append(baseNote.toString());
        if(alteration != Alteration.NATURAL) spelling.append(alteration.symbol);
        if(includeOctave) spelling.append(octaveValue);
        return spelling.toString();
    }

    /**
     * Returns a string with the correct chord spelling without an octave value. 
     * 
     * @see Note#getSpelling(boolean) 
     * **/
    public String getSpelling(){
        return getSpelling(false);
    }

    /**
     * Alters this note by a set integer. If the total alteration exceeds a double flat or a double sharp,
     * an exception will be thrown.
     *
     * @return Returns a copy of the same note with the new alteration.
     * @param alterationValue Offset of the alteration, a positive number indicates an alteration upwards, while
     *                        a negative number indicates an alteration downwards. For example, if the note originally
     *                        has an alteration of a single flat, a -1 alteration parsed into this parameter will cause
     *                        the alteration to change to a double flat.
     * **/
    public Note getAltered(int alterationValue){
        alterationValue = this.alteration.value + alterationValue;
        if(alterationValue < -2 || alterationValue > 2) throw new AlterationException("Alteration " + alterationValue +  " out of bound.");
        else return this.createMutableClone().alter(alterationValue);
    }

    private Note alter(int value){
        this.alteration = Alteration.get(value);
        return this;
    }

    /**
     * Returns the note above of the given interval object. This method will only work if the octave is not abstract, and
     * it will throw an exception if otherwise. If the interval above the note requires a note with more than two flats or sharps
     * (e.g. a minor third above G double flat would be B triple flat), an exception will be thrown and should be caught accordingly
     * when trying to use this method iteratively. It is also adviced to use {@link Note#getPossibleIntervalQualitiesAbove(int, IntervalQuality...)}
     * to find possible intervals above this note before calling this method in order to prevent this issue.
     * **/
    public Note getNoteAbove(Interval interval){
        if(this.isOctaveAbstract()) throw new IntervalException("Octave must not be abstract for this method to run.");
        Note newBaseNote = BaseNote.get(this.getBaseNoteLabel() + interval.getValue() - 1);
        int diff;
        try {
            int compare = new IntervalCalculator(this, newBaseNote).getDistance();
            diff = interval.getDistance() - compare;
        }catch (IntervalException e){
            int compare = new IntervalCalculator(newBaseNote, this).getDistance();
            diff = compare - interval.getDistance();
        }
        try {
            return newBaseNote.getAltered(diff);
        }catch (AlterationException e){
            throw new IntervalException("Cannot find " + interval.getFormattedName() + " above " + this.getSpelling() +", as this would require more than two sharps or flats on the note.");
        }
    }

    /**
     * Given a interval value, this method finds the possible interval qualities in the context of the interval
     * being used to find the note above the note this method is called from. This method is designed to be used
     * together with {@link Note#getNoteAbove(Interval)} in order to fix the issue of notes being able to get as
     * many flats and sharps as accidentals as possible.
     * **/
    public Interval[] getPossibleIntervalQualitiesAbove(int intervalValue, IntervalQuality... omitted){


        ArrayList<Interval> IQArrayList = new ArrayList<>();

        for(int i = -2; i <= 2; i++){
            IntervalCalculator interval = getIntervalInstance(intervalValue, i);
            if(interval != null && doesNotHaveOmitted(interval.getInterval(), omitted)) IQArrayList.add(interval.getInterval());
        }

        Interval[] intervals = new Interval[IQArrayList.size()];
        for (int i = 0; i < IQArrayList.size(); i++) {
            intervals[i] = IQArrayList.get(i);
        }

        return intervals;

    }

    private boolean doesNotHaveOmitted(Interval interval, IntervalQuality... omitted){
        for (IntervalQuality intervalQuality : omitted) {
            if(interval.getQuality().equals(intervalQuality)) return false;
        }
        return true;
    }

    @Nullable
    private IntervalCalculator getIntervalInstance(int value, int alteration){
        try {
            return new IntervalCalculator(this, BaseNote.get(getBaseNoteLabel() + value - 1).alter(alteration));
        }catch (BaseNoteException | IntervalException e){
            return null;
        }
    }

    @Override
    public String toString() {
        return getSpelling();
    }

    /**
     * Gets the Lilypond format of this note.
     * **/
    @Override
    public String getLilyCode(){
        int oct;
        if(isOctaveAbstract()) oct = 3;
        else oct = getOctaveValue();
        String base = this.baseNote.toString().toLowerCase();
        String alt;
        switch (alteration){
            case FLAT -> alt = "es";
            case SHARP -> alt = "is";
            case DOUBLE_FLAT -> alt = "eses";
            case DOUBLE_SHARP -> alt = "isis";
            default -> alt = "";
        }

        String octaveAlt;

        switch (oct){
            case 0 -> octaveAlt = ",,,";
            case 1 -> octaveAlt = ",,";
            case 2 -> octaveAlt = ",";
            case 4 -> octaveAlt = "'";
            case 5 -> octaveAlt = "''";
            case 6 -> octaveAlt = "'''";
            case 7 -> octaveAlt = "''''";
            case 8 -> octaveAlt = "'''''";
            default -> octaveAlt = "";
        }

        return base + alt + octaveAlt;

    }
}

