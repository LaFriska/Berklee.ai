package com.friska.jnotes.core.keys;

import com.friska.jnotes.core.LilyCode;
import com.friska.jnotes.core.intervals.Interval;
import com.friska.jnotes.core.notes.Note;
import com.friska.jnotes.exceptions.IntervalException;

public class Key implements LilyCode {

    private final Note root;
    private final KeyQuality quality;

    private int lilyCodeOctave = 4;
    private final Note[] scaleDegrees;

    public Key(Note root, KeyQuality quality){
        this.root = root;
        this.quality = quality;
        this.scaleDegrees = initializeScaleDegree();
    }

    public Key setLilypondOctave(int octave){
        lilyCodeOctave = octave;
        return this;
    }

    private Note[] initializeScaleDegree(){
        Note rootedRoot = root.createMutableClone().setOctave(1);
        Note[] result = new Note[quality.length() + 1];
        result[0] = rootedRoot;
        Interval curr;
        for(int i = 1; i < result.length; i++){
            curr = quality.getNext();
            result[i] = result[i - 1].getNoteAbove(curr);
            result[i - 1].abstractOctave();
        }
        result[result.length - 1].abstractOctave();
        return result;
    }

    private Note[] getDegreesWithOctave(int octaveValue){
        Note[] result = new Note[scaleDegrees.length];
        result[0] = scaleDegrees[0].createMutableClone().setOctave(octaveValue);
        for (int i = 1; i < result.length; i++) {
            if(scaleDegrees[i].getBaseNote().solfeggeValue < scaleDegrees[i-1].getBaseNote().solfeggeValue) octaveValue++;
            result[i] = scaleDegrees[i].createMutableClone().setOctave(octaveValue);
        }
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

    @Override
    public String getLilyCode() {
        StringBuilder sb = new StringBuilder(VERSION_TAG);
        sb.append("{ \\omit Score.TimeSignature \\hide Stem \\cadenzaOn ");
        Note[] notes = getDegreesWithOctave(lilyCodeOctave);
        for (Note scaleDegree : notes) {
            sb.append(scaleDegree.getLilyCode()).append(" ");
        }
        sb.append("}");
        return sb.toString();
    }
}
