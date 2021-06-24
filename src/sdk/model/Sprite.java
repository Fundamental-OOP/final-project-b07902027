package sdk.model;

import sdk.view.*;

public abstract class Sprite{

    protected World world;
    protected Coordinate coordinate;
    protected Painter painter;

    public Sprite(Painter painter, Coordinate coordinate){
        this.coordinate = coordinate;
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

    abstract public void update();
}