package com.friska.berkbot.trainer;

import com.friska.berkbot.Main;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.jetbrains.annotations.NotNull;

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
                if(msg.contains("easy")) new IntervalIDQuestion(0).sendQuestion(event.getChannel().asTextChannel(), 0);
                if(msg.contains("med") || msg.contains("medium")) new IntervalIDQuestion(1).sendQuestion(event.getChannel().asTextChannel(), 1);
                if(msg.contains("hard") || msg.contains("difficult")) new IntervalIDQuestion(2).sendQuestion(event.getChannel().asTextChannel(), 2);
            }
            if(msgSplit.length < 5 && msg.contains("chord")){
                if(msg.contains("easy")) new ChordIDQuestion(0).sendQuestion(event.getChannel().asTextChannel(), 0);
                if(msg.contains("med") || msg.contains("medium")) new ChordIDQuestion(1).sendQuestion(event.getChannel().asTextChannel(), 1);
                if(msg.contains("hard") || msg.contains("difficult")) new ChordIDQuestion(2).sendQuestion(event.getChannel().asTextChannel(), 2);
            }
        }
    }

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        if(event.getMessage().getAuthor().getId().equals(Main.config.botid())){
            event.deferReply().setEphemeral(true).queue();
            Button button = event.getButton();
            String id = button.getId();
            TextChannel c = event.getChannel().asTextChannel();
            switch (id) {
                case "interval easy" -> new IntervalIDQuestion(0).sendQuestion(c, 0, event);
                case "interval med" -> new IntervalIDQuestion(1).sendQuestion(c, 1, event);
                case "interval hard" -> new IntervalIDQuestion(2).sendQuestion(c, 2, event);
                case "chord easy" -> new ChordIDQuestion(0).sendQuestion(c, 0, event);
                case "chord med" -> new ChordIDQuestion(1).sendQuestion(c, 1, event);
                case "chord hard" -> new ChordIDQuestion(2).sendQuestion(c, 2, event);
            }
        }
    }
}
