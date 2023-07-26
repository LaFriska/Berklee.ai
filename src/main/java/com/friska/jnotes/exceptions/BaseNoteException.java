package com.friska.jnotes.exceptions;

public class BaseNoteException extends JNoteException{
    public BaseNoteException(String msg){
        super("An issue occurred processing a note base: " + msg);
    }
}
