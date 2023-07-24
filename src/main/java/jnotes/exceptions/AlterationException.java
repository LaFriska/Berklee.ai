package jnotes.exceptions;

public class AlterationException extends JNoteException{

    public AlterationException(String msg){
        super("An issue had occurred processing an alteration: " + msg);
    }

}
