package com.friska.berkbot.trainer;

import com.friska.jnotes.core.LilyCode;
import com.friska.jnotes.core.notes.Alteration;
import com.friska.jnotes.core.notes.BaseNote;
import com.friska.jnotes.core.notes.Note;
import net.dv8tion.jda.api.EmbedBuilder;

import java.util.Random;

public abstract class TrainerQuestion implements LilyCode {

    protected final Random r = new Random();
    protected final int difficulty;

    protected final Note startingNote;

    protected TrainerQuestion(int diff){
        this.difficulty = diff;
        this.startingNote = getRandomStartingNote();
    }

    protected Note getRandomStartingNote(){

        int oct = r.nextInt(2) + 3;

        Note note = new Note(BaseNote.getNoteBaseFromSolfegge(r.nextInt(7) + 1),
                difficulty == 1 ? Alteration.get(r.nextInt(3) - 1) :
                        difficulty == 0 ? Alteration.NATURAL :Alteration.get(r.nextInt(5) - 2)
        );
        return note.setOctave(oct);
    }

    abstract EmbedBuilder getQuestion();
}
