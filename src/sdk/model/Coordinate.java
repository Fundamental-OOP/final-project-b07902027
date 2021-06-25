package sdk.model;


public class Coordinate{

    protected int x, y, speedX, speedY;

    public Coordinate(){
        reset(0, 0, 0, 0);
    }

    public Coordinate(int x, int y, int speedX, int speedY){
        reset(x, y, speedX, speedY);
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setSpeedX(int speedX){
        this.speedX = speedX;
    }

    public void setSpeedY(int speedY){
        this.speedY = speedY;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getSpeedX(){
        return speedX;
    }

    public int getSpeedY(){
        return speedY;
    }

    public void reset(int x, int y, int speedX, int speedY){
        this.x = x;
        this.y = y;
        this.speedX = speedX;
        this.speedY = speedY;
    }
}