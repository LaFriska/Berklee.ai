package com.friska.berkbot.lilypond;

import com.friska.berkbot.lilypond.req.LilyEmbedRequest;
import com.friska.berkbot.lilypond.req.LilyMessageRequest;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class LilyTest extends ListenerAdapter {
    //temporary class

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getMessage().getContentRaw().equals("lily")){
            LilyMessageRequest request = new LilyMessageRequest(event.getChannel().sendMessage("Test1"), "\\version \"2.24.1\"\n" +
                    "\n" +
                    "{ c' }");

            LilyMessageRequest request2 = new LilyMessageRequest(event.getChannel().sendMessage("Test2"), "\\version \"2.24.1\"\n" +
                    "\n" +
                    "{ d' }");

            LilyMessageRequest request3 = new LilyMessageRequest(event.getChannel().sendMessage("Test3"), "\\version \"2.24.1\"\n" +
                    "\n" +
                    "{ d' }");

            LilyMessageRequest request4 = new LilyMessageRequest(event.getChannel().sendMessage("Test4"), "\\version \"2.24.1\"\n" +
                    "\n" +
                    "{ d' }");

            LilyEmbedRequest requestEmb1 = new LilyEmbedRequest(event.getChannel().asTextChannel(), new EmbedBuilder().setColor(Color.BLUE).setDescription("Hello"), "\\version \"2.24.1\"\n" +
                    "\n" +
                    "{ g' }");

            LilyManager.INSTANCE.push(requestEmb1);
        }
    }
}
