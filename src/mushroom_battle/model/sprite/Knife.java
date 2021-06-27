package mushroom_battle.model.sprite;

import mushroom_battle.model.KnifeOwner;
import sdk.model.Sprite;


public class Knife extends ActiveSprite{

    public final static int WIDTH = 20, HEIGHT = 20;
    private KnifeOwner owner;

    public Knife(){
        super("Knife", 0, 0, WIDTH, HEIGHT, 0, 0);
    }

    public Knife(int x, int y, int width, int height, int xSpeed, int ySpeed){
        super("Knife", x, y, width, height, xSpeed, ySpeed);
    }

    public boolean hasOwner(){
        return this.owner != null;
    }

    public void setOwner(KnifeOwner owner){
        this.owner = owner;
        this.visible = false;
    }

    public void thrown(){
        // TODO: set knife's initial coordinate here
        this.owner = null;
        this.visible = true;
    }

    @Override
    public void update(){
    }
}