package sdk.model;


public abstract class Physic{

    int borderX, borderY;

    public Physic(int borderX, int borderY){
        this.borderX = borderX;
        this.borderY = borderY;
    }

    public int getBorderX(){
        return this.borderX;
    }

    public int getBorderY(){
        return this.borderY;
    }

    abstract public void update(Sprite sprite);
}