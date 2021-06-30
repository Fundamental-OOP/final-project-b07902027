package mushroom_battle.model;

import java.util.List;

import mushroom_battle.model.sprite.*;
import sdk.model.*;

public class GoombaCollisionHandler extends CollisionHandler{

    final static int SCHEDULING_IDX = 2;

    public GoombaCollisionHandler(){
        super(SCHEDULING_IDX);
    }

    public GoombaCollisionHandler(int level){
        super(level);
    }

    @Override
    public boolean shouldHandle(Sprite target){
        return target instanceof Goomba;
    }

    @Override
    public void handle(Sprite target, List<Sprite> otherSprites){
        Goomba goomba = (Goomba) target;
        
        for (Sprite otherSprite: otherSprites){

            if (otherSprite instanceof Ground){
                goombaHitGroundHandler(goomba, (Ground) otherSprite);
            }
            else if (otherSprite instanceof Mushroom){
                goombaPickedUpHandler(goomba, (Mushroom) otherSprite);
                goombaKilledMushroomHandler(goomba, (Mushroom) otherSprite);
            }
        }
    }

    private void goombaHitGroundHandler(Goomba goomba, Ground ground){
        if (!goomba.isFalling && goomba.getThrower() != null && 
            goomba.y + goomba.height == ground.y)
        {
            goomba.setThrower(null);
            goomba.xSpeed = 0;
            goomba.ySpeed = 0;
        }
    }

    private void goombaPickedUpHandler(Goomba goomba, Mushroom mushroom){
        if (goomba.getOwner() == null &&
            goomba.getThrower() == null &&
            !mushroom.hasGoomba() &&
            goomba.intersects(mushroom))
        {
            mushroom.setGoomba(goomba);
        }
    }

    private void goombaKilledMushroomHandler(Goomba goomba, Mushroom mushroom){
        if (goomba.getThrower() != null &&
            goomba.getThrower() != mushroom &&
            goomba.intersects(mushroom))
        {
            mushroom.killed();
            goomba.visible = false;
        }
    }
}