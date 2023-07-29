package com.friska.berkbot.lilypond.req;

import net.dv8tion.jda.api.requests.restaction.MessageCreateAction;
import net.dv8tion.jda.api.utils.FileUpload;

import java.io.File;

public class LilyRequestMessage extends LilyRequest{

    private MessageCreateAction messageCreateAction;

    public LilyRequestMessage(MessageCreateAction messageCreateAction, String lilycode){
        super(lilycode);
        this.messageCreateAction = messageCreateAction;
    }

    @Override
    public boolean process(File file) {
        super.process(file);
        messageCreateAction.addFiles(FileUpload.fromData(image)).queue();
        return true;
    }
}
