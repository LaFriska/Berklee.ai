package jnotes.exceptions;

public class IntervalException extends RuntimeException{

    public IntervalException(String msg){
        super("An issue had occurred relating to an interval: " + msg);
    }

}
