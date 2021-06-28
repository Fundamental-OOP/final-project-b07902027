package sdk.controller;

import sdk.view.*;
import sdk.model.*;


public abstract class Game{

    protected View view;
    protected World world;
    protected int fps;
    protected long msDelta;
    protected boolean running = true;


    public Game(World world, View view, int fps){
        this.world  = world;
        this.view = view;
        this.fps = fps;
        this.msDelta = (long) (1.0 / fps * 1000);
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
        while (this.running) {
            world.update();
            view.render();
            this.delay();
            this.checkIfGameEnds();
        }
    }

    protected void delay() {
        try {
            Thread.sleep(this.msDelta);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    abstract protected void checkIfGameEnds();
}