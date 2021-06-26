package sdk.model;

import sdk.view.*;

public abstract class Sprite{

    protected String name;
    protected int width, height;
    protected World world;
    protected final Coordinate coordinate;
    protected Painter painter;
    public boolean visible = true;

    public Sprite(String name, Coordinate coordinate, int width, int height){
        this.name = name;
        this.coordinate = coordinate;
        this.width = width;
        this.height = height;
    }

    public String getName(){
        return name;
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

    public void setPainter(Painter painter){
        this.painter = painter;
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    abstract public void update();
}