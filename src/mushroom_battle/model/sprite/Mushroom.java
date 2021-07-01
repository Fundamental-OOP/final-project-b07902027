package mushroom_battle.model.sprite;

import mushroom_battle.Constant;
import mushroom_battle.model.ScoreBoard;

public class Mushroom extends ActiveSprite{
    
    private boolean alive = true;
    private Goomba goomba;
    public final ScoreBoard scoreBoard;

    public Mushroom(int width, int height, ScoreBoard scoreBoard){
        super("Mushroom", 0, 0, width, height, 0, 0);
        this.scoreBoard = scoreBoard;
        this.scoreBoard.setMushroom(this);
    }

    @Override
    public void update(){
    }

    @Override
    public void setGoomba(Goomba goomba){
        this.goomba = goomba;
        goomba.setOwner(this);
    }

    @Override
    public boolean hasGoomba(){
        return this.goomba != null;
        // return false;
    }

    @Override
    public Goomba getGoomba(){
        if (this.goomba == null){
            throw new RuntimeException(getName() + " doesn't have goomba but was required one.\n");
        }
        return this.goomba;
    }

    @Override
    public void throwGoomba(){
        this.goomba.thrown();
        this.goomba = null;
    }

    public int getScore(){
        return scoreBoard.getScore();
    }

    public void pushButton(){
        if (hasGoomba()){
            throwGoomba();
        } else {
            jump();
        }
    }

    public void jump(){
        if (!this.isFalling){
            this.isFalling = true;
            this.ySpeed = Constant.MUSHROOM_Y_SPEED;
        }
    }

    public void killed(){
        this.alive = false;
    }

    public boolean isDead(){
        return !this.alive;
    }

    public void setAlive(){
        this.alive = true;
    }
}