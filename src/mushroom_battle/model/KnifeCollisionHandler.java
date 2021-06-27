package mushroom_battle.model;

import java.util.List;

import mushroom_battle.model.sprite.*;
import sdk.model.*;

public class KnifeCollisionHandler extends CollisionHandler{

    final static int SCHEDULING_IDX = 1;

    public KnifeCollisionHandler(){
        super(SCHEDULING_IDX);
    }

    public KnifeCollisionHandler(int level){
        super(level);
    }

    @Override
    public boolean shouldHandle(Sprite target){
        return target instanceof Knife;
    }

    @Override
    public void handle(Sprite target, List<Sprite> otherSprites){
        Knife knife = (Knife) target;
        
        for (Sprite otherSprite: otherSprites){

            if (otherSprite instanceof Ground && 
                !knife.isFalling && 
                knife.getThrower() != null &&
                ((Ground) otherSprite).y - knife.height == knife.y)
            {
                knife.setThrower(null);
                knife.setLocation(knife.x, ((Ground) otherSprite).y - knife.height);
                knife.xSpeed = 0;
                knife.ySpeed = 0;
                knife.isFalling = false;
            }
            // if knife collision with ground: setOwner = null
            // TODO: handle knife collision with mushroom
            //if (otherSprite instanceof Ground)
            //    handle(knife, (Ground) otherSprite);
        }
    }

    public void handle(ActiveSprite sprite, Ground ground){
        
    }
}