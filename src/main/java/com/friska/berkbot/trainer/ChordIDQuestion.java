package com.friska.berkbot.trainer;

import com.friska.berkbot.Main;
import com.friska.jnotes.core.chords.Chord;
import com.friska.jnotes.core.chords.ChordQualities;
import com.friska.jnotes.core.chords.ChordQuality;
import com.friska.jnotes.core.chords.CompiledChord;
import com.friska.jnotes.core.chords.enums.Tension;
import com.friska.jnotes.core.notes.Alteration;
import com.friska.jnotes.core.notes.BaseNote;
import com.friska.jnotes.core.notes.Note;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class ChordIDQuestion extends TrainerQuestion{

    private Chord chord;
    private CompiledChord compiledChord;

    protected ChordIDQuestion(int diff) {
        super(diff, "chord");
        this.chord = getRandomChord();
        this.compiledChord = chord.compile();
    }

    private Chord getRandomChord(){
        ChordQuality quality = getRandomQuality();
        String notation = quality.getQualityNotation();
        Chord chord = new Chord(startingNote, quality);
        if(notation.equals("-7") && r.nextInt(2) == 1){
            chord.b5();
        }
        if(difficulty >= 1 &&  (quality.getQualityName().equals("major") ||
                                notation.equals("maj7") ||
                                notation.equals("dom7")
        )){
            if(r.nextInt(101) <= 15) chord.sus4();
            if(r.nextInt(101) <= 15) chord.sus2();
        }

        if(difficulty >= 1){
            Tension[] tension = getRandomTension(quality);
            chord.tensions(tension);
        }

        return chord;
    }

    private ChordQuality getRandomQuality(){
        if(difficulty == 0){
            switch (r.nextInt(8)){
                case 0 -> {return ChordQualities.maj();}
                case 1 -> {return ChordQualities.min();}
                case 2 -> {return ChordQualities.dim();}
                case 3 -> {return ChordQualities.aug();}
                case 4 -> {return ChordQualities.dom7();}
                case 5 -> {return ChordQualities.maj7();}
                case 6,7 -> {return ChordQualities.min7();}
            }
        }else{
            switch (r.nextInt(13)){
                case 0 -> {return ChordQualities.maj();}
                case 1 -> {return ChordQualities.min();}
                case 2 -> {return ChordQualities.dim();}
                case 3 -> {return ChordQualities.aug();}
                case 4 -> {return ChordQualities.dom7();}
                case 5 -> {return ChordQualities.maj7();}
                case 6,12 -> {return ChordQualities.min7();}
                case 7 -> {return ChordQualities.aug7();}
                case 8 -> {return ChordQualities.dim7();}
                case 9 -> {return ChordQualities.minMaj7();}
                case 10 -> {return ChordQualities.maj6();}
                case 11 -> {return ChordQualities.min6();}
            }
        }
        throw new RuntimeException();
    }

    @Override
    protected Note getRandomStartingNote() {
        int oct = r.nextInt(2) + 3;

        Note note = new Note(BaseNote.getNoteBaseFromSolfegge(r.nextInt(7) + 1),
                difficulty >= 1 ? Alteration.get(r.nextInt(3) - 1) : Alteration.NATURAL
        );
        return note.setOctave(oct);
    }

    private Tension[] getRandomTension(ChordQuality quality){
        Tension[] ninths;
        Tension[] elevenths;
        Tension[] thirteenths;
        int nums = 0;
        if(difficulty == 1){

            if(r.nextInt(100) <= 29) nums++;

            ninths = new Tension[]{
                    Tension.T9,
                    Tension.Tb9
            };
            elevenths = new Tension[]{
                    Tension.T11
            };
            thirteenths = new Tension[]{
                    Tension.T13
            };

        }else{

            int nextI = r.nextInt(100);

            if(nextI <= 75) nums++;
            if(nextI <= 50) nums++;
            if(nextI <= 25) nums++;

            ninths = new Tension[]{
                    Tension.T9,
                    Tension.Tb9,
                    Tension.Ts9
            };
            elevenths = new Tension[]{
                    Tension.T11,
                    Tension.Ts11
            };
            thirteenths = new Tension[]{
                    Tension.T13,
                    Tension.Tb13
            };
        }

        Tension[] res = new Tension[nums];
        for (int i = 0; i < res.length; i++) {
            if(i == 0) res[i] = ninths[r.nextInt(ninths.length)];
            if(i == 1) res[i] = elevenths[r.nextInt(elevenths.length)];
            if(i == 2) res[i] = thirteenths[r.nextInt(thirteenths.length)];
        }
        return res;
    }

    @Override
    public EmbedBuilder getQuestion() {
        EmbedBuilder eb = new EmbedBuilder();

        eb.setTitle("Chord Identification");

        StringBuilder sb = new StringBuilder();

        if(difficulty == 0) {
            eb.setColor(Color.GREEN);
            sb.append("Difficulty: Easy").append("\n\n");
        } else if(difficulty == 1){
            eb.setColor(Color.ORANGE);
            sb.append("Difficulty: Medium").append("\n\n");
        }else{
            eb.setColor(Color.RED);
            sb.append("Difficulty: Hard").append("\n\n");
        }

        sb.append("What is the chord shown below?");
        sb.append("\n\n");
        sb.append("Answer: ||").append(compiledChord.spelling()).append("||");

        eb.setDescription(sb.toString());
        eb.setFooter(Main.config.copyright());
        return eb;
    }

    @Override
    public String getLilyCode() {
        return compiledChord.getLilyCode();
    }
}
