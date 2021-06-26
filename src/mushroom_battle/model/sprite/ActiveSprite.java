package mushroom_battle.model.sprite;

import sdk.model.RectangleSprite;
import mushroom_battle.model.GravityApplicable;

public abstract class ActiveSprite extends RectangleSprite implements GravityApplicable{

    public boolean isFalling = false;
    public int xSpeed, ySpeed;

    public ActiveSprite(String name, int x, int y, int width, int height, int xSpeed, int ySpeed){
        super(name, x, y, width, height);
        setSpeed(xSpeed, ySpeed);
    }

    @Override  
    public void setSpeed(int xSpeed, int ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public void setXSpeed(int xSpeed){
        this.xSpeed = xSpeed;
    }

    @Override
    public void setYSpeed(int ySpeed){
        this.ySpeed = ySpeed;
    }
    
    @Override
    public int getXSpeed(){
        return this.xSpeed;
    }

    @Override
    public int getYSpeed(){
        return this.ySpeed;
    }

    @Override
    public boolean isFalling(){
        return this.isFalling;
    }
}
