package sdk.model;


public class Coordinate{

    protected int x, y, speedX, speedY;

    public Coordinate(){
        this(0, 0, 0, 0);
    }

    public Coordinate(int x, int y, int speedX, int speedY){
        this.x = x;
        this.y = y;
        this.speedX = speedX;
        this.speedY = speedY;
    }

    public void resetX(int x){
        this.x = x;
    }

    public void resetY(int y){
        this.y = y;
    }

    public void resetSpeedX(int speedX){
        this.speedX = speedX;
    }

    public void resetSpeedY(int speedY){
        this.speedY = speedY;
    }

    public void reset(int x, int y, int speedX, int speedY){
        this.x = x;
        this.y = y;
        this.speedX = speedX;
        this.speedY = speedY;
    }
}