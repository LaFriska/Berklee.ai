package com.friska.jnotes.exceptions;

public abstract class JNoteException extends RuntimeException{
    public JNoteException(String msg){
        super(msg);
    }
}
