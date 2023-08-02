package com.friska.berkbot.trainer;

import com.friska.berkbot.Main;
import com.friska.berkbot.lilypond.LilyManager;
import com.friska.berkbot.lilypond.req.LilyEmbedRequest;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TrainerListener extends ListenerAdapter {

    protected boolean checkPrefix(MessageReceivedEvent event){
        if(event.getAuthor().isBot() || event.getAuthor().isSystem()) return false;
        return event.getMessage().getContentRaw().contains(Main.config.prefix()) || event.getMessage().getContentRaw().contains(Main.config.prefix2());
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        assert Main.config != null;
        if(checkPrefix(event)){
            String msg = event.getMessage().getContentRaw();
            String[] msgSplit = msg.split(" ");
            if(msgSplit.length < 5 && msg.contains("interval")){
                if(msg.contains("easy")) sendQuestion(event.getChannel().asTextChannel(), 0);
                if(msg.contains("med") || msg.contains("medium")) sendQuestion(event.getChannel().asTextChannel(), 1);
                if(msg.contains("hard") || msg.contains("difficult")) sendQuestion(event.getChannel().asTextChannel(), 2);
            }
        }
    }

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        if(event.getMessage().getAuthor().getId().equals(Main.config.botid())){
            Button button = event.getButton();
            String id = button.getId();
            TextChannel c = event.getChannel().asTextChannel();
            if(button.getId().equals("interval easy")) {
                event.deferReply().setEphemeral(true).queue();
                sendQuestion(c, 0, event);
            }else if(button.getId().equals("interval med")) {
                event.deferReply().setEphemeral(true).queue();
                sendQuestion(c, 1, event);
            }else if(button.getId().equals("interval hard")) {
                event.deferReply().setEphemeral(true).queue();
                sendQuestion(c, 2, event);
            }
        }
    }

    private void sendQuestion(TextChannel channel, int difficulty){
        sendQuestion(channel, difficulty, null);
    }

    private void sendQuestion(TextChannel channel, int difficulty, @Nullable ButtonInteractionEvent event){
        IntervalIDQuestion question = new IntervalIDQuestion(difficulty);

        LilyEmbedRequest request = new LilyEmbedRequest(channel, question.getQuestion(), question)
                .addActionRow(Button.secondary("interval easy", difficulty == 0 ? "Next" : "Easy"),
                        Button.secondary("interval med", difficulty == 1 ? "Next" : "Medium"),
                        Button.secondary("interval hard", difficulty == 2 ? "Next" : "Hard"));
        if(event != null) request.deleteDeferredReply(event);
        LilyManager.INSTANCE.push(request);
    }
}
