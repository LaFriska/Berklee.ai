package com.friska.jnotes.exceptions;

import org.jetbrains.annotations.NotNull;

public class NoteOctaveException extends JNoteException{

    public NoteOctaveException(@NotNull String msg){
        super("Failure in assigning or querying an octave value for a note: " + msg);
    }

}
