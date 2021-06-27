package mushroom_battle.model.sprite;

import mushroom_battle.model.KnifeDirection;


public class Knife extends ActiveSprite{

    public final static int THROWING_RADIUS = 30;
    public final static int WIDTH = 20, HEIGHT = 20;
    private Mushroom owner;
    private KnifeDirection throwingDirection;

    public Knife(int initAngle){
        super("Knife", 0, 0, WIDTH, HEIGHT, 0, 0);
        this.throwingDirection = new KnifeDirection(THROWING_RADIUS, initAngle);
    }

    public Knife(int x, int y, int width, int height, int xSpeed, int ySpeed, int initAngle){
        super("Knife", x, y, width, height, xSpeed, ySpeed);
        this.throwingDirection = new KnifeDirection(THROWING_RADIUS, initAngle);
    }

    public boolean hasOwner(){
        return this.owner != null;
    }

    public void setOwner(Mushroom owner){
        this.owner = owner;
        this.visible = false;
    }

    public void thrown(){
        this.isFalling = true;
        this.setLocation(owner.x + owner.width / 2, owner.y + owner.height / 2);
        this.setSpeed(throwingDirection.getX(), throwingDirection.getY());
        // this.owner = null;
        this.visible = true;
    }

    @Override
    public void update(){
        if (this.owner != null && !isFalling){
            setLocation(owner.x + 10, owner.y - this.height); // TODO: change format when following a mushroom
        }
        throwingDirection.update();
    }
}