package mushroom_battle.model;

import sdk.model.*;
import mushroom_battle.model.sprite.*;


public class MushroomBattleWorld extends World{

    public MushroomBattleWorld(Physic physic, CollisionHandlerCollector collector, BatchSpriteInitiator initiator, Sprite... sprites){
        super(physic, collector, initiator, sprites);
    }

    public Mushroom getMushroom(int mushroomIdx){
        return (mushroomIdx == 1) ? 
               (Mushroom) getSprite(SpriteInitEnum.MUSHROOM1) : 
               (Mushroom) getSprite(SpriteInitEnum.MUSHROOM2);
    }

    @Override 
    public void update(){
        super.update();
        if (getMushroom(1).isDead()){
            getMushroom(2).scoreBoard.increase();
            initSprites();
        } else if (getMushroom(2).isDead()){
            getMushroom(1).scoreBoard.increase();
            initSprites();
        }
    }
}