package jnotes.core.notes;

import org.jetbrains.annotations.NotNull;

public class Note {

    private final NoteBase noteBase;
    private final Alteration alteration;

    private final int value;

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

    public Note(NoteBase noteBase){
        this(noteBase, Alteration.NATURAL);
    }

    public NoteBase getNoteBase() {
        return noteBase;
    }

    public Alteration getAlteration() {
        return alteration;
    }

    public int getValue() {
        return value;
    }

    public boolean equalsEnharmonically(Note note){
        return note.getValue() == this.getValue();
    }

    public boolean equals(Note note){
        return equalsEnharmonically(note)
                && note.getNoteBase() == this.getNoteBase()
                && note.getAlteration() == this.getAlteration();
    }

    public int getHertz(){
        //TODO
        return -1;
    }
}

