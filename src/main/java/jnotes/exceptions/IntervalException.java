package jnotes.exceptions;

public class IntervalException extends JNoteException{

    public IntervalException(String msg){
        super("An issue had occurred relating to an interval: " + msg);
    }

}
