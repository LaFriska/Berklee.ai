package com.friska.berkbot.lilypond.req;

import com.friska.berkbot.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.interactions.components.ItemComponent;
import net.dv8tion.jda.api.requests.restaction.MessageCreateAction;
import net.dv8tion.jda.api.utils.FileUpload;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class LilyEmbedRequest extends LilyRequest{

    private EmbedBuilder embedBuilder;
    private ItemComponent[] components = null;

    TextChannel channel;

    public LilyEmbedRequest(TextChannel channel, EmbedBuilder embedBuilder, String lilycode){
        super(lilycode);
        this.embedBuilder = embedBuilder;
        this.channel = channel;
    }

    public LilyEmbedRequest addActionRow(@NotNull ItemComponent... components){
        this.components = components;
        return this;
    }

    @Override
    public boolean process(File file) {
        super.process(file);
        embedBuilder.setImage("attachment://workspace.preview.png");
        MessageCreateAction mca = channel.sendMessageEmbeds(embedBuilder.build()).addFiles(FileUpload.fromData(file));
        if(components != null) mca.addActionRow(components);
        mca.queue();
        return true;
    }
}
