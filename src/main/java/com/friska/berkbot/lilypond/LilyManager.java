package com.friska.berkbot.lilypond;

import com.friska.berkbot.lilypond.req.LilyRequest;

import java.util.LinkedList;
import java.util.Queue;

public class LilyManager extends Thread {

    public static final LilyManager INSTANCE = new LilyManager();
    private final Queue<LilyRequest> lily_queue = new LinkedList<>();

    private boolean hasStartedThread = false;

    private LilyManager(){
        start();
    }

    public <T extends LilyRequest> void push(T request){
        lily_queue.add(request);
    }

    @Override
    public void run() {
        LilyProcessor lp = LilyProcessor.INSTANCE;
        while(true) {
            while (!lily_queue.isEmpty()) {
                if (lp.isFree()) {
                    lp.receiveRequest(lily_queue.poll());
                }
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
