package com.friska.jnotes.core.chords.enums;

import com.friska.jnotes.debug.MissingJavadoc;

@MissingJavadoc
public enum Sus {

    SUS4("sus4"),
    SUS2("sus2");

    public final String notation;

    Sus(String notation){
        this.notation = notation;
    }

}
