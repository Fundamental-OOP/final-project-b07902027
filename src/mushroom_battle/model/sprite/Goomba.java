package mushroom_battle.model.sprite;

import mushroom_battle.model.GoombaDirection;


public class Goomba extends ActiveSprite{

    private Mushroom owner, thrower;
    private GoombaDirection throwingDirection;

    public Goomba(int width, int height, int throwingRadius, int readyMarkRadius, int initAngle, int angleSpeed){
        super("Goomba", 0, 0, width, height, 0, 0);
        this.throwingDirection = new GoombaDirection(throwingRadius, readyMarkRadius, initAngle, angleSpeed);
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
        if (owner != null){
            this.thrower = null;
            this.visible = false;
            this.isFalling = false;
        }
    }

    public void setAngle(int angle){
        this.throwingDirection.setDirection(angle);
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

    public GoombaDirection getDirection(){
        return this.throwingDirection;
    }

    @Override
    public void update(){
        if (this.owner != null && !isFalling){
            setLocation(owner.x, owner.y);
        }
        throwingDirection.update();
    }
}