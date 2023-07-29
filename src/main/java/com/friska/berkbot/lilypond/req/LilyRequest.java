package com.friska.berkbot.lilypond.req;

import net.dv8tion.jda.api.events.interaction.component.GenericComponentInteractionCreateEvent;
import org.jetbrains.annotations.Nullable;

import java.io.File;

public abstract class LilyRequest {

    @Nullable
    protected GenericComponentInteractionCreateEvent event = null;
    protected String lilycode;
    protected File image;
    public LilyRequest(String lilycode){
        this.lilycode = lilycode;
    }

    public String getLilycode() {
        return lilycode;
    }

    public boolean process(File file){
        this.image = file;
        if(event != null) event.getHook().deleteOriginal().queue();
        return true;
    }

    public <T extends GenericComponentInteractionCreateEvent> void deleteDeferredReply(T event){
        this.event = event;
    }
}
