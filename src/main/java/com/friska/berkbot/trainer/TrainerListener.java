package com.friska.berkbot.trainer;

import com.friska.berkbot.Main;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class TrainerListener extends ListenerAdapter {

    protected boolean checkPrefix(MessageReceivedEvent event){
        if(event.getAuthor().isBot() || event.getAuthor().isSystem()) return false;
        return event.getMessage().getContentRaw().contains(Main.config.prefix()) || event.getMessage().getContentRaw().contains(Main.config.prefix2());
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        assert Main.config != null;
        if(checkPrefix(event)){
            String msg = event.getMessage().getContentRaw();
            String[] msgSplit = msg.split(" ");
            if(msgSplit.length < 5 && msg.contains("interval")){
                if(msg.contains("easy")) sendEasyIntervalQuestion(event.getChannel().asTextChannel());
                if(msg.contains("med") || msg.contains("medium")) sendMediumIntervalQuestion(event.getChannel().asTextChannel());
                if(msg.contains("hard") || msg.contains("difficult")) sendHardIntervalQuestion(event.getChannel().asTextChannel());
            }
        }
    }

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        if(event.getMessage().getAuthor().getId().equals(Main.config.botid())){
            Button button = event.getButton();
            String id = button.getId();
            if(button.getId().equals("interval easy")) {
                sendEasyIntervalQuestion(event.getChannel().asTextChannel());
                event.deferEdit().queue();
            }else if(button.getId().equals("interval med")) {
                sendMediumIntervalQuestion(event.getChannel().asTextChannel());
                event.deferEdit().queue();
            }else if(button.getId().equals("interval hard")) {
                sendHardIntervalQuestion(event.getChannel().asTextChannel());
                event.deferEdit().queue();
            }
        }
    }

    private void sendEasyIntervalQuestion(TextChannel channel){
        channel
                .sendMessageEmbeds(new IntervalQuestion(0).getQuestion().build())
                .addActionRow(Button.secondary("interval easy", "Next"),
                        Button.secondary("interval med", "Medium"),
                        Button.secondary("interval hard", "Hard"))
                .queue();
    }

    private void sendMediumIntervalQuestion(TextChannel channel){
        channel
                .sendMessageEmbeds(new IntervalQuestion(1).getQuestion().build())
                .addActionRow(Button.secondary("interval easy", "Easy"),
                        Button.secondary("interval med", "Next"),
                        Button.secondary("interval hard", "Hard"))
                .queue();
    }

    private void sendHardIntervalQuestion(TextChannel channel){
        channel
                .sendMessageEmbeds(new IntervalQuestion(2).getQuestion().build())
                .addActionRow(Button.secondary("interval easy", "Easy"),
                        Button.secondary("interval med", "Medium"),
                        Button.secondary("interval hard", "Next"))
                .queue();
    }
}