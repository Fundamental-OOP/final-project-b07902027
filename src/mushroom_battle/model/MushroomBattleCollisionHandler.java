package mushroom_battle.model;

import java.util.List;

import mushroom_battle.model.sprite.Ground;
import sdk.model.*;

public class MushroomBattleCollisionHandler implements CollisionHandler{

    @Override
    public void handle(Sprite from, Sprite to){
        if (from instanceof GravityApplicable && to instanceof Ground){
            //if (fromCoordinate.getX() + from.getWidth() > to.){

            //}
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