package sdk.view;

import sdk.controller.*;
import sdk.model.*;


public abstract class View{

    protected Game game;

    public void setGame(Game game){
        this.game = game;
    }

    public void render(World world){
        world.render(this.getRenderable());
    }

    abstract public Renderable getRenderable();
    abstract public void launch();
}