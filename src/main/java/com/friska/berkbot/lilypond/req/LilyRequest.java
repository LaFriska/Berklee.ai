package com.friska.berkbot.lilypond.req;

import java.io.File;

public abstract class LilyRequest {

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
        return true;
    }
}
