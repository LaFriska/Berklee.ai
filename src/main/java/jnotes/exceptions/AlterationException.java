package jnotes.exceptions;

public class AlterationException extends RuntimeException{

    public AlterationException(String msg){
        super("An issue had occurred processing an alteration: " + msg);
    }

}
