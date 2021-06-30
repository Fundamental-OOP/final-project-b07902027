package mushroom_battle.model;

import java.util.List;
import sdk.model.CollisionHandler;
import mushroom_battle.model.sprite.*;
import sdk.model.Sprite;

public class MushroomCollisionHandler extends CollisionHandler{

    final static int SCHEDULING_IDX = 0;

    public MushroomCollisionHandler(){
        super(SCHEDULING_IDX);
    }

    public MushroomCollisionHandler(int level){
        super(level);
    }

    @Override
    public boolean shouldHandle(Sprite target){
        return target instanceof Mushroom;
    }

    @Override
    public void handle(Sprite target, List<Sprite> otherSprites){
        Mushroom mushroom = (Mushroom) target;
        if (mushroom.isFalling) return;
        for (Sprite otherSprite: otherSprites){
            if (otherSprite instanceof Ground && 
                isOnTheGround(mushroom, (Ground) otherSprite))
            {
                return;
            }
        }
        mushroom.isFalling = true;
    }

    public boolean isOnTheGround(Mushroom mushroom, Ground ground){
        return mushroom.intersects(ground.x, ground.y - 1, ground.width, ground.height);
    }
}
