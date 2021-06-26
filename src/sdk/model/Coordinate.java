package sdk.model;


public class Coordinate{

    protected int x, y, XSpeed, YSpeed;

    public Coordinate(){
        reset(0, 0, 0, 0);
    }

    public Coordinate(int x, int y, int XSpeed, int YSpeed){
        reset(x, y, XSpeed, YSpeed);
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setXSpeed(int XSpeed){
        this.XSpeed = XSpeed;
    }

    public void setYSpeed(int YSpeed){
        this.YSpeed = YSpeed;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getXSpeed(){
        return XSpeed;
    }

    public int getYSpeed(){
        return YSpeed;
    }

    public void reset(int x, int y, int XSpeed, int YSpeed){
        this.x = x;
        this.y = y;
        this.XSpeed = XSpeed;
        this.YSpeed = YSpeed;
    }
}