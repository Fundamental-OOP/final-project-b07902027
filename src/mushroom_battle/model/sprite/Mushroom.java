package mushroom_battle.model.sprite;

import mushroom_battle.model.KnifeOwner;

public class Mushroom extends ActiveSprite implements KnifeOwner{

    public final static int INIT_X_SPEED = 3;
    public final static int INIT_Y_SPEED = -15;
    public final static int WIDTH = 40, HEIGHT = 40;
    
    private boolean alive = true;
    private Knife knife;

    public Mushroom(){
        super("Mushroom", 0, 0, WIDTH, HEIGHT, INIT_X_SPEED, 0);
    }

    public Mushroom(int x, int y, int width, int height, int xSpeed, int ySpeed){
        super("Mushroom", x, y, width, height, xSpeed, ySpeed);
    }

    @Override
    public void update(){
    }

    @Override
    public void setKnife(Knife knife){
        this.knife = knife;
        knife.setOwner(this);
    }

    @Override
    public boolean hasKnife(){
        return this.knife != null;
        // return false;
    }

    @Override
    public Knife getKnife(){
        if (this.knife == null){
            throw new RuntimeException(getName() + " doesn't have knife but was required one.\n");
        }
        return this.knife;
    }

    @Override
    public void throwKnife(){
        this.knife.thrown();
        this.knife = null;
    }

    public void pushButton(){
        if (hasKnife()){
            throwKnife();
        } else {
            jump();
        }
    }

    public void jump(){
        if (!this.isFalling){
            this.isFalling = true;
            this.ySpeed = INIT_Y_SPEED;
        }
    }

    public void killed(){
        this.alive = false;
    }

    public boolean isDead(){
        return !this.alive;
    }
}