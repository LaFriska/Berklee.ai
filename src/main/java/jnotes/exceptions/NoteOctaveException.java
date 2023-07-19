package jnotes.exceptions;

import org.jetbrains.annotations.NotNull;

public class NoteOctaveException extends RuntimeException{

    public NoteOctaveException(@NotNull String msg){
        super("Failure in assigning or querying an octave value for a note: " + msg);
    }

}
