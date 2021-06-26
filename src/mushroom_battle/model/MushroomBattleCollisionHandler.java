package mushroom_battle.model;

import java.util.List;
import java.awt.Rectangle;

import mushroom_battle.model.sprite.*;
import sdk.model.*;

public class MushroomBattleCollisionHandler implements CollisionHandler{

    @Override
    public void handle(Sprite from, Sprite to){
        if (from instanceof ActiveSprite && to instanceof Ground){
            ActiveSprite fromSprite = (ActiveSprite) from;
            RectangleSprite toSprite = (RectangleSprite) to;
            if (fromSprite.intersects(toSprite) && fromSprite.ySpeed > 0){
                fromSprite.isFalling = false;
                fromSprite.setLocation(fromSprite.x, toSprite.y - fromSprite.height);
            }
        }
    }

    @Override
    public void handle(Sprite sprite, List<Sprite> sprites){
        for (Sprite otherSprite: sprites){
            if (sprite != otherSprite)
                handle(sprite, otherSprite);
        }
    }
}