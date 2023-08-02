package com.friska.berkbot.trainer;

import com.friska.berkbot.Main;
import com.friska.berkbot.lilypond.LilyManager;
import com.friska.berkbot.lilypond.req.LilyEmbedRequest;
import com.friska.jnotes.core.LilyCode;
import com.friska.jnotes.core.intervals.Interval;
import com.friska.jnotes.core.intervals.IntervalQuality;
import com.friska.jnotes.core.notes.Alteration;
import com.friska.jnotes.core.notes.BaseNote;
import com.friska.jnotes.core.notes.Note;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.Random;

public class IntervalIDQuestion extends TrainerQuestion {

    private static final Interval[] easy = new Interval[]{
            new Interval(1, IntervalQuality.PERFECT),
            new Interval(2, IntervalQuality.MINOR),
            new Interval(2, IntervalQuality.MAJOR),
            new Interval(3, IntervalQuality.MINOR),
            new Interval(3, IntervalQuality.MAJOR),
            new Interval(4, IntervalQuality.PERFECT),
            new Interval(4, IntervalQuality.AUGMENTED),
            new Interval(5, IntervalQuality.DIMINISHED),
            new Interval(5, IntervalQuality.PERFECT),
            new Interval(6, IntervalQuality.MINOR),
            new Interval(6, IntervalQuality.MAJOR),
            new Interval(7, IntervalQuality.MINOR),
            new Interval(7, IntervalQuality.MAJOR)
    };
    private final Note upperNote;

    private final Interval interval;

    public IntervalIDQuestion(int difficulty){
        super(difficulty, "interval");
        this.interval = getRandomInterval();
        this.upperNote = startingNote.getNoteAbove(interval);
    }

    private Interval getRandomInterval(){
        if(difficulty == 0) {
            return easy[r.nextInt(easy.length)];
        }else if(difficulty == 1){
            Interval[] intervals = startingNote.getPossibleIntervalQualitiesAbove(r.nextInt(15) + 1,
                    IntervalQuality.DOUBLE_AUGMENTED,
                    IntervalQuality.TRIPLE_AUGMENTED,
                    IntervalQuality.QUADRUPLE_AUGMENTED,
                    IntervalQuality.DOUBLE_DIMINISHED,
                    IntervalQuality.TRIPLE_DIMINISHED,
                    IntervalQuality.QUADRUPLE_DIMINISHED
            );
            return intervals[r.nextInt(intervals.length)];
        }else{
            Interval[] intervals = startingNote.getPossibleIntervalQualitiesAbove(r.nextInt(15) + 1);
            return intervals[r.nextInt(intervals.length)];
        }
    }

    @Override
    public EmbedBuilder getQuestion(){
        EmbedBuilder eb = new EmbedBuilder();

        eb.setTitle("Interval Identification");

        StringBuilder sb = new StringBuilder();

        if(difficulty == 0) {
            eb.setColor(Color.GREEN);
            sb.append("Difficulty: Easy").append("\n\n");
            sb.append("What is the interval between ").append(startingNote.getSpelling()).append(" and ").append(upperNote.getSpelling()).append("?")
                .append("\n\n").append("Answer: ||").append(interval.getFormattedName()).append("||");
        } else if(difficulty == 1){
            eb.setColor(Color.ORANGE);
            sb.append("Difficulty: Medium").append("\n\n");
            sb.append("What is the interval between ").append(startingNote.getSpelling(true)).append(" and ").append(upperNote.getSpelling(true)).append("?")
                    .append("\n\n").append("Answer: ||").append(interval.getFormattedName()).append("||");
        }else{
            eb.setColor(Color.RED);
            sb.append("Difficulty: Hard").append("\n\n");
            sb.append("What is the interval between ").append(startingNote.getSpelling(true)).append(" and ").append(upperNote.getSpelling(true)).append("?")
                    .append("\n\n").append("Answer: ||").append(interval.getFormattedName()).append("||");
        }

        eb.setDescription(sb.toString());
        eb.setFooter(Main.config.copyright());
        return eb;
    }

    @Override
    public String getLilyCode(){
        return getLilyFromNote(startingNote, upperNote);
    }
}
