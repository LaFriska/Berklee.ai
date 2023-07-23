package jnotes.exceptions;

public class BaseNoteException extends RuntimeException{
    public BaseNoteException(String msg){
        super("An issue occurred processing a note base: " + msg);
    }
}
