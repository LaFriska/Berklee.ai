package com.friska.berkbot.lilypond;

import com.friska.berkbot.lilypond.req.LilyRequest;

import java.util.LinkedList;
import java.util.Queue;

public class LilyManager extends Thread {

    public static final LilyManager INSTANCE = new LilyManager();
    private final Queue<LilyRequest> lily_queue = new LinkedList<>();

    private <T extends LilyRequest> void addRequest(T request){
        lily_queue.add(request);
        if(lily_queue.size() == 1) start();
    }

    @Override
    public void run() {
        LilyProcessor lp = LilyProcessor.INSTANCE;
        while(!lily_queue.isEmpty()) {
            if (lp.isFree()) {
                lp.receiveRequest(lily_queue.poll());
            }
        }
    }
}
