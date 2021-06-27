package mushroom_battle.model.sprite;

import mushroom_battle.model.KnifeDirection;


public class Knife extends ActiveSprite{

    public final static int THROWING_RADIUS = 30;
    public final static int WIDTH = 20, HEIGHT = 20;
    private Mushroom owner, thrower;
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

    public Mushroom getOwner(){
        return this.owner;
    }

    public Mushroom getThrower(){
        return this.thrower;
    }

    public void setThrower(Mushroom thrower){
        this.thrower = thrower;
    }

    public void setOwner(Mushroom owner){
        this.owner = owner;
        if (owner != null)
            this.visible = false;
    }

    public void thrown(){
        this.thrower = this.owner;
        this.owner = null;
        this.isFalling = true;
        this.setLocation(thrower.x + (thrower.width - this.width) / 2, 
                         thrower.y + (thrower.height - this.height) / 2);
        this.setSpeed(throwingDirection.getX(), throwingDirection.getY());
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