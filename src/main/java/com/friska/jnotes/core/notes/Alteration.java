package com.friska.jnotes.core.notes;

import com.friska.jnotes.debug.MissingJavadoc;
import com.friska.jnotes.exceptions.AlterationException;

@MissingJavadoc
public enum Alteration {
    SHARP(1, "♯"),
    FLAT(-1, "♭"),
    DOUBLE_SHARP(2, "\uD834\uDD2A"),
    DOUBLE_FLAT(-2, "\uD834\uDD2B"),
    NATURAL(0, "♮");

    public final int value;

    public final String symbol;

    Alteration(int value, String symbol) {
        this.value = value;
        this.symbol = symbol;
    }

    public static Alteration get(int value){
        switch (value){
            case -2 -> {return DOUBLE_FLAT;}
            case -1 -> {return FLAT;}
            case 0 -> {return NATURAL;}
            case 1 -> {return SHARP;}
            case 2 -> {return DOUBLE_SHARP;}
            default -> throw new AlterationException("No such alteration.");
        }
    }
}
