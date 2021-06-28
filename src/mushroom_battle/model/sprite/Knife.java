package mushroom_battle.model.sprite;

import mushroom_battle.model.KnifeDirection;


public class Knife extends ActiveSprite{

    private Mushroom owner, thrower;
    private KnifeDirection throwingDirection;

    public Knife(int width, int height, int throwingRadius){
        super("Knife", 0, 0, width, height, 0, 0);
        this.throwingDirection = new KnifeDirection(throwingRadius, 0);
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

    @Override
    public void update(){
        if (this.owner != null && !isFalling){
            setLocation(owner.x + 10, owner.y - this.height); // TODO: change format when following a mushroom
        }
        throwingDirection.update();
    }
}