package com.friska.berkbot.trainer;

import com.friska.berkbot.lilypond.LilyManager;
import com.friska.berkbot.lilypond.req.LilyEmbedRequest;
import com.friska.jnotes.core.LilyCode;
import com.friska.jnotes.core.notes.Alteration;
import com.friska.jnotes.core.notes.BaseNote;
import com.friska.jnotes.core.notes.Note;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public abstract class TrainerQuestion implements LilyCode {

    protected final String id;
    protected final Random r = new Random();
    protected final int difficulty;

    protected final Note startingNote;

    protected TrainerQuestion(int diff, String id){
        this.difficulty = diff;
        this.startingNote = getRandomStartingNote();
        this.id = id;
    }

    protected Note getRandomStartingNote(){

        int oct = r.nextInt(2) + 3;

        Note note = new Note(BaseNote.getNoteBaseFromSolfegge(r.nextInt(7) + 1),
                difficulty == 1 ? Alteration.get(r.nextInt(3) - 1) :
                        difficulty == 0 ? Alteration.NATURAL :Alteration.get(r.nextInt(5) - 2)
        );
        return note.setOctave(oct);
    }

    public void sendQuestion(TextChannel channel, int difficulty){
        sendQuestion(channel, difficulty, null);
    }

    public void sendQuestion(TextChannel channel, int difficulty, @Nullable ButtonInteractionEvent event){

        LilyEmbedRequest request = new LilyEmbedRequest(channel, getQuestion(), this)
                .addActionRow(net.dv8tion.jda.api.interactions.components.buttons.Button.secondary(id + " easy", difficulty == 0 ? "Next" : "Easy"),
                        net.dv8tion.jda.api.interactions.components.buttons.Button.secondary(id + " med", difficulty == 1 ? "Next" : "Medium"),
                        Button.secondary(id + " hard", difficulty == 2 ? "Next" : "Hard"));
        if(event != null) request.deleteDeferredReply(event);
        LilyManager.INSTANCE.push(request);
    }

    abstract EmbedBuilder getQuestion();
}
