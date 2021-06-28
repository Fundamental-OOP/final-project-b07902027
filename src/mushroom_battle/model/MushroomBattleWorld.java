package mushroom_battle.model;

import sdk.model.*;
import mushroom_battle.model.sprite.*;


public class MushroomBattleWorld extends World{

    public MushroomBattleWorld(Physic physic, CollisionHandlerCollector collector, BatchSpriteInitiator initiator, Sprite... sprites){
        super(physic, collector, initiator, sprites);
    }

    public Mushroom getMushroom(int mushroomIdx){
        return (mushroomIdx == 1) ? 
               (Mushroom) getSprite(SpriteEnum.MUSHROOM1) : 
               (Mushroom) getSprite(SpriteEnum.MUSHROOM2);
    }
}