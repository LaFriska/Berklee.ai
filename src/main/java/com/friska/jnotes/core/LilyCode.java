package com.friska.jnotes.core;

import com.friska.berkbot.Main;
import com.friska.jnotes.core.notes.Note;

public interface LilyCode {
    String VERSION_TAG = "\\version \"" + Main.config.lily_version() +"\"" + "\n\n";
    String getLilyCode();

    default String getLilyFromNote(Note... notes){
        StringBuilder sb = new StringBuilder(VERSION_TAG);
        sb.append("{ <");
        for (Note note : notes) {
            sb.append(note.getLilyCode()).append(" ");
        }
        sb.append("> }");
        return sb.toString();
    }
}
