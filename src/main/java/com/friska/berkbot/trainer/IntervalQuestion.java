package com.friska.berkbot.trainer;

import com.friska.berkbot.Main;
import com.friska.jnotes.core.intervals.Interval;
import com.friska.jnotes.core.intervals.IntervalQuality;
import com.friska.jnotes.core.notes.Alteration;
import com.friska.jnotes.core.notes.BaseNote;
import com.friska.jnotes.core.notes.Note;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;
import java.util.Random;

public class IntervalQuestion {

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

    private static final Interval[] medium = new Interval[]{
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

    private final int difficulty;

    private final Note startingNote;
    private final Note upperNote;

    private final Interval interval;

    public IntervalQuestion(int difficulty){
        this.difficulty = difficulty;
        this.startingNote = getRandomStartingNote();
        this.interval = getRandomInterval();
        this.upperNote = startingNote.getNoteAbove(interval);
    }

    private Note getRandomStartingNote(){
        Random r = new Random();

        int oct = r.nextInt(2) + 3;
        Note note = new Note(BaseNote.getNoteBaseFromSolfegge(r.nextInt(7) + 1),
               difficulty == 1 ? Alteration.get(r.nextInt(3) - 1) : Alteration.NATURAL);
        return note.setOctave(oct);
    }

    private Interval getRandomInterval(){
        //TODO add switch statement for difficulty
        Random r = new Random();
        return easy[r.nextInt(easy.length)];
    }

    public EmbedBuilder getQuestion(){
        //TODO add switch statement for difficulty
        EmbedBuilder eb = new EmbedBuilder();

        eb.setTitle("Interval Question");
        eb.setColor(Color.GREEN);

        StringBuilder sb = new StringBuilder();
        sb.append("What is the interval between ").append(startingNote.getSpelling()).append(" and ").append(upperNote.getSpelling()).append("?")
                .append("\n\n").append("Answer: ||").append(interval.getFormattedName()).append("||");

        eb.setDescription(sb.toString());
        eb.setFooter(Main.config.copyright());
        return eb;
    }
}
