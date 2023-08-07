package com.friska.berkbot.trainer;

import com.friska.jnotes.core.chords.ChordQuality;
import com.friska.jnotes.core.keys.KeyQualities;
import com.friska.jnotes.core.keys.KeyQuality;
import com.friska.jnotes.core.notes.Alteration;
import com.friska.jnotes.core.notes.BaseNote;
import com.friska.jnotes.core.notes.Note;
import net.dv8tion.jda.api.EmbedBuilder;

public class ModeIDTrainer extends TrainerQuestion{

    //TODO
    protected ModeIDTrainer(int diff, String id) {
        super(diff, id);
    }

    private KeyQuality getRandomQuality(){
        if(difficulty == 0){
            switch (r.nextInt(5)){
                case 0 -> {return KeyQualities.major();}
                case 1 -> {return KeyQualities.minor();}
                case 2 -> {return KeyQualities.harmonicMinor();}
                case 3 -> {return KeyQualities.melodicMinor();}
                case 4 -> {return KeyQualities.dorian();}
            }
        }else{
            switch (r.nextInt(8)){
                case 0 -> {return KeyQualities.major();}
                case 1 -> {return KeyQualities.minor();}
                case 2 -> {return KeyQualities.harmonicMinor();}
                case 3 -> {return KeyQualities.melodicMinor();}
                case 4 -> {return KeyQualities.dorian();}
                case 5 -> {return KeyQualities.phrygian();}
                case 6 -> {return KeyQualities.mixolydian();}
                case 7 -> {return KeyQualities.lydian();}
            }
        }
        throw new RuntimeException();
    }

    @Override
    protected Note getRandomStartingNote() {
        return new Note(BaseNote.getNoteBaseFromSolfegge(r.nextInt(7) + 1),
                difficulty >= 1 ? Alteration.get(r.nextInt(3) - 1) : Alteration.NATURAL
        );
    }

    @Override
    EmbedBuilder getQuestion() {
        return null;
    }

    @Override
    public String getLilyCode() {
        return null;
    }
}
