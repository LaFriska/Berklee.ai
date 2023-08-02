package com.friska.jnotes.exceptions;

public class ChordException extends RuntimeException{
    public ChordException(String msg){
        super("An issue occurred processing a chord: " + msg);
    }
}
