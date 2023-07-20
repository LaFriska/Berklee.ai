package jnotes.core.notes;

import jnotes.core.util.NoteUtils;
import jnotes.exceptions.NoteOctaveException;
import org.jetbrains.annotations.NotNull;

public class Note {

    private final NoteBase noteBase;
    private final Alteration alteration;

    private final int value;
    private int octaveValue = -1; //Abstract octave can be set to -1

    private final boolean immutable;

    protected Note(@NotNull NoteBase noteBase, Alteration alteration, boolean immutable){
        int value;
        this.noteBase = noteBase;
        if(alteration == null) this.alteration = Alteration.NATURAL;
        else this.alteration = alteration;
        //Modulo 12 to get note values to stay in GF(12)
        value = (noteBase.value + this.alteration.value) % 12;
        if(value <= 0) value = 12 + value;
        this.value = value;
        this.immutable = immutable;
    }

    /**
     * This object creates an abstraction for a musical note.
     * Data such as the spelling and pitch value are to be stored in this object.
     *
     * @param noteBase Base note without any accidentals.
     * @param alteration Alterations such as a sharp, double sharp or a flat to the base note.
     * **/
    public Note(@NotNull NoteBase noteBase, Alteration alteration){
        this(noteBase, alteration, false);
    }

    /**
     * This object creates an abstraction for a musical note.
     * Data such as the spelling and pitch value are to be stored in this object.
     *
     * @param noteBase Base note without any accidentals.
     * **/
    public Note(NoteBase noteBase){
        this(noteBase, Alteration.NATURAL);
    }

    /**
     * @return Returns the note base represented by an enum.
     * **/
    public NoteBase getNoteBase() {
        return noteBase;
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
    public boolean equalsEnharmonically(Note note){
        return note.getValue() == this.getValue();
    }

    /**
    * Returns a true if the note compared is, and spelled the same as the note this method is called from.
     * This means that the note base, and alteration should all be the equal for this method to
     * return true. For a method that returns true as long as the notes compared are
     * equal enharmonically, see the {@link Note#equalsEnharmonically} method.
    * */
    public boolean equals(Note note){
        return equalsEnharmonically(note)
                && note.getNoteBase() == this.getNoteBase()
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
        NoteUtils.checkOctaveRange(octaveValue, this.value);
        if(immutable) return this.createMutableClone().setOctave(octaveValue);
        this.octaveValue = octaveValue;
        return this;
    }

    /**
     * Creates a clone of a note that is immutable, so that certain parameters in the note can
     * be changed.
     * **/
    public Note createMutableClone(){
        return new Note(noteBase, alteration);
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
     * **/
    public String getSpelling(){
        StringBuilder spelling = new StringBuilder();
        spelling.append(noteBase.toString());
        if(alteration != Alteration.NATURAL) spelling.append(alteration.symbol);
        return spelling.toString();
    }
}

