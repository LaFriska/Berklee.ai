package com.friska.berkbot.lilypond.req;

import com.friska.berkbot.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.interactions.components.ItemComponent;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class LilyRequestEmbed extends LilyRequest{

    private EmbedBuilder embedBuilder;
    private ItemComponent[] components = null;

    TextChannel channel;

    public LilyRequestEmbed(TextChannel channel, EmbedBuilder embedBuilder, String lilycode){
        super(lilycode);
        this.embedBuilder = embedBuilder;
        this.channel = channel;
    }

    public LilyRequestEmbed addActionRow(@NotNull ItemComponent... components){
        this.components = components;
        return this;
    }

    @Override
    public boolean process(File file) {
        super.process(file);
        embedBuilder.setImage("attachment:/" + Main.config.lilypond_path() +"/" + "workspace.preview.png");
        channel.sendMessageEmbeds(embedBuilder.build()).addActionRow(components).queue();
        return true;
    }
}
