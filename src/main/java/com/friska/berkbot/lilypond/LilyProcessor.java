package com.friska.berkbot.lilypond;

import com.friska.berkbot.Main;
import com.friska.berkbot.lilypond.req.LilyRequest;

import java.io.*;

public class LilyProcessor{

    private final String PATH = Main.config.lilypond_path();
    private LilyRequest REQUEST = null;

    private boolean free = true;

    public static final LilyProcessor INSTANCE = new LilyProcessor();

    private LilyProcessor(){} //Private empty constructor to privatise instantiation

    public  <T extends LilyRequest> boolean receiveRequest(T request){
        busy();
        REQUEST = request;
        if(request == null){
            free();
            System.err.println("Lily: Cannot process null request.");
            return false;
        }
        try {
            File file = new File(PATH, "workspace.ly");
            if (!file.exists()){
                if(file.createNewFile()){
                    return receiveRequest(request.getLilyCode(), file);
                }else{
                    System.err.println("Lily: An issue occurred trying to create files in the lilypond workspace.");
                    free();
                    return false;
                }
            }else{
                return receiveRequest(request.getLilyCode(), file);
            }
        }catch (Exception e){
            System.err.println("Lily: Unable to process lilypond procedure.");
            e.printStackTrace();
            free();
            return false;
        }
    }

    private boolean receiveRequest(String lilycode, File file) throws IOException {
        ProcessBuilder builder = new ProcessBuilder();
        builder.directory(new File(Main.config.lilypond_path()));
        builder.command("lilypond", "-fpng", "-dresolution=300", "-dpreview", "workspace.ly");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(lilycode);
        bufferedWriter.close();

        Process process = builder.start();

        try(BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
        }

        File image = new File(PATH + "/" + "workspace.preview.png");
        if(REQUEST.process(image)){
            REQUEST = null;
            free();
            return true;
        }else{
            REQUEST = null;
            free();
            return false;
        }
    }

    public boolean isFree() {
        return free;
    }

    public void busy(){
        this.free = false;
    }
    public void free(){
        this.free = true;
    }
}
