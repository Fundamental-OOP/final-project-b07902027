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

            if (otherSprite instanceof Ground){
                knifeHitGroundHandler(knife, (Ground) otherSprite);
            }
            else if (otherSprite instanceof Mushroom){
                knifePickedUpHandler(knife, (Mushroom) otherSprite);
                knifeKilledMushroomHandler(knife, (Mushroom) otherSprite);
            }
            // if knife collision with ground: setOwner = null
            // TODO: handle knife collision with mushroom
            //if (otherSprite instanceof Ground)
            //    handle(knife, (Ground) otherSprite);
        }
    }

    public void handle(ActiveSprite sprite, Ground ground){
        
    }

    private void knifeHitGroundHandler(Knife knife, Ground ground){
        if (!knife.isFalling && knife.getThrower() != null && ground.y - knife.height == knife.y){
            knife.setThrower(null);
            knife.xSpeed = 0;
            knife.ySpeed = 0;
            knife.isFalling = false;
        }
    }

    private void knifePickedUpHandler(Knife knife, Mushroom mushroom){
        if (knife.getOwner() == null &&
            knife.getThrower() == null &&
            !mushroom.hasKnife() &&
            knife.intersects(mushroom))
        {
            mushroom.setKnife(knife);
        }
    }

    private void knifeKilledMushroomHandler(Knife knife, Mushroom mushroom){
        if (knife.getThrower() != null &&
            knife.getThrower() != mushroom &&
            knife.intersects(mushroom))
        {
            mushroom.killed();
            knife.visible = false;
        }
    }
}