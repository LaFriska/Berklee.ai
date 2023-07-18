package jnotes.core.notes;

import jnotes.debug.MissingJavadoc;
import org.jetbrains.annotations.NotNull;

public class Note {

    private final NoteBase noteBase;
    private final Alteration alteration;

    private final int value;

    /**
     * This object creates an abstraction for a musical note.
     * Data such as the spelling and pitch value are to be stored in this object.
     *
     * @param noteBase Base note without any accidentals.
     * @param alteration Alterations such as a sharp, double sharp or a flat to the base note.
     * **/
    public Note(@NotNull NoteBase noteBase, Alteration alteration){
        int value;
        this.noteBase = noteBase;
        if(alteration == null) this.alteration = Alteration.NATURAL;
        else this.alteration = alteration;
        //Modulo 12 to get note values to stay in GF(12)
        value = (noteBase.value + this.alteration.value) % 12;
        if(value <= 0) value = 12 + value;
        this.value = value;
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
     * checks whether or not the note values are equal. For a description of note values, see {@link Note#getValue}.
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

    @MissingJavadoc
    public int getHertz(){
        //TODO
        return -1;
    }
}

