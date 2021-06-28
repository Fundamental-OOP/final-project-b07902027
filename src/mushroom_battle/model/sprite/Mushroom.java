package mushroom_battle.model.sprite;

import mushroom_battle.Constant;
import mushroom_battle.model.KnifeOwner;

public class Mushroom extends ActiveSprite implements KnifeOwner{
    
    private boolean alive = true;
    private Knife knife;

    public Mushroom(int width, int height){
        super("Mushroom", 0, 0, width, height, 0, 0);
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
            this.ySpeed = Constant.MUSHROOM_Y_SPEED;
        }
    }

    public void killed(){
        this.alive = false;
    }

    public boolean isDead(){
        return !this.alive;
    }
}