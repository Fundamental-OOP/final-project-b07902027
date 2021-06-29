package sdk.controller;

import sdk.view.*;
import sdk.model.*;


public abstract class Game{

    protected int fps;
    protected long msDelta;
    protected boolean running = true;

    public Game(int fps){
        this.fps = fps;
        this.msDelta = (long) (1.0 / fps * 1000);
    }

    abstract public World getWorld();
    abstract public View getView();
    abstract protected void checkIfGameEnds();

    public void start() {
        new Thread(this::gameLoop).start();
        getView().launch();
    }

    public void stop(){
        this.running = false;
    }

    protected void gameLoop() {
        while (this.running) {
            getWorld().update();
            getView().render();
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
}