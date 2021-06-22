package sdk.model;

import java.awt.*;
import sdk.controller.*;
import sdk.view.*;


public abstract class Sprite{

    protected World world;
    protected Coordinate coordinate;
    protected Painter painter;

    public Sprite(Painter painter){
        this.coordinate = new Coordinate();
        this.painter = painter;
        this.painter.setSprite(this);
    }

    public void setWorld(World world){
        this.world = world;
    }

    public Coordinate getCoordinate(){
        return this.coordinate;
    }

    public Painter getPainter(){
        return this.painter;
    }

    public void update(){
        this.world.getPhysic();
    }

    public void render(Renderable r){
        this.painter.paint(r);
    }
}