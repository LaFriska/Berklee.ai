package com.friska.berkbot.lilypond.req;

import com.friska.jnotes.core.LilyCode;
import net.dv8tion.jda.api.requests.restaction.MessageCreateAction;
import net.dv8tion.jda.api.utils.FileUpload;

import java.io.File;

public class LilyMessageRequest extends LilyRequest{

    private final MessageCreateAction messageCreateAction;

    public <T extends LilyCode> LilyMessageRequest(MessageCreateAction messageCreateAction, T lilyObj){
        super(lilyObj);
        this.messageCreateAction = messageCreateAction;
    }

    @Override
    public boolean process(File file) {
        super.process(file);
        messageCreateAction.addFiles(FileUpload.fromData(image)).queue();
        return true;
    }
}
