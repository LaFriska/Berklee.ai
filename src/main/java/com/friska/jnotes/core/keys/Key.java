package com.friska.jnotes.core.keys;

import com.friska.jnotes.core.notes.Note;

public class Key {

    private final Note root;
    private final KeyQuality quality;

    private final Note[] scaleDegrees;

    public Key(Note root, KeyQuality quality){
        this.root = root;
        this.quality = quality;
        this.scaleDegrees = initializeScaleDegree();
    }

    private Note[] initializeScaleDegree(){
        Note rootedRoot = root.createMutableClone().setOctave(1);
        Note[] result = new Note[quality.length() + 1];
        result[0] = rootedRoot;
        for(int i = 1; i < result.length; i++){
            result[i] = result[i - 1].getNoteAbove(quality.getNext());
            result[i - 1].abstractOctave();
        }
        result[result.length - 1].abstractOctave();
        return result;
    }

    public Note[] getScaleDegrees(){
        return scaleDegrees;
    }

    public KeyQuality getQuality() {
        return quality;
    }

    public Note getRoot() {
        return root;
    }
}
