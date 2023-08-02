package com.friska.berkbot.lilypond.req;

import com.friska.jnotes.core.LilyCode;
import net.dv8tion.jda.api.events.interaction.component.GenericComponentInteractionCreateEvent;
import org.jetbrains.annotations.Nullable;

import java.io.File;

public abstract class LilyRequest implements LilyCode {

    @Nullable
    protected GenericComponentInteractionCreateEvent event = null;
    protected String lilycode;
    protected File image;
    public <T extends LilyCode> LilyRequest(T lilyObj){
        this.lilycode = lilyObj.getLilyCode();
    }

    @Override
    public String getLilyCode() {
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
