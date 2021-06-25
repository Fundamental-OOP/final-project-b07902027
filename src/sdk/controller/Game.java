package sdk.controller;

import sdk.view.*;
import sdk.model.*;


public class Game{

    protected View view;
    protected World world;
    protected int fps;
    protected long msDelta;
    protected boolean running;


    public Game(World world, View view, int fps){
        this.world  = world;
        this.view = view;
        this.fps = fps;
        this.msDelta = (long) (1 / fps * 1000);
    }

    public void setView(View view){
        this.view = view;
    }

    public World getWorld(){
        return this.world;
    }

    public View getView(){
        return this.view;
    }

    public void start() {
        new Thread(this::gameLoop).start();
        this.view.launch();
    }

    public void stop(){
        this.running = false;
    }

    protected void gameLoop() {
        this.running = true;
        while (this.running) {
            world.update();
            view.render();
            this.delay();
        }
        System.out.println("Game Finished");
    }

    protected void delay() {
        try {
            Thread.sleep(this.msDelta);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}