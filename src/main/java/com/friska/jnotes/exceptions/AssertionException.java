package com.friska.jnotes.exceptions;

public class AssertionException extends JNoteException{

    public AssertionException(String msg){
        super("An issue had occurred running an assertion: " + msg);
    }

}
