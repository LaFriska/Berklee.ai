package com.friska.jnotes.core;

import com.friska.berkbot.Main;
import com.friska.jnotes.core.notes.Note;

public interface LilyCode {

    String VERS = Main.config.lily_version();
    String getLilyCode();

    default String getLilyFromNote(Note... notes){
        StringBuilder sb = new StringBuilder();
        sb.append("\\version \"").append(VERS).append("\"").append("\n\n").append("{ <");
        for (Note note : notes) {
            sb.append(note.getLilyCode()).append(" ");
        }
        sb.append("> }");
        return sb.toString();
    }
}
