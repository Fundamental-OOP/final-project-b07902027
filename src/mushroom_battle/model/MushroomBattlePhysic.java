package mushroom_battle.model;

import sdk.model.*;
import mushroom_battle.model.sprite.ActiveSprite;


public class MushroomBattlePhysic extends Physic{

    final static int GRAVITY = +1;

    public MushroomBattlePhysic(int borderX, int borderY){
        super(borderX, borderY);
    }
    
    @Override
    public void update(Sprite sprite){
        if (sprite instanceof ActiveSprite){
            updateCoordinate((ActiveSprite) sprite);
        }
    }

    private void updateCoordinate(ActiveSprite sprite){

        // x sprite
        if (sprite.x + sprite.getXSpeed() + sprite.width >= borderX){
            sprite.setLocation(borderX - sprite.width, sprite.y);
            sprite.setXSpeed(-sprite.getXSpeed());
        } else if(sprite.x + sprite.getXSpeed() < 0){
            sprite.x = 0;
            sprite.setXSpeed( -sprite.getXSpeed());
        } else{
            sprite.x = sprite.x + sprite.getXSpeed();
        }

        // y sprite
        // TODO: slow down y updating
        if (sprite.isFalling()){
            sprite.y = sprite.y + sprite.getYSpeed();
            sprite.setYSpeed(sprite.getYSpeed() + GRAVITY);
        }
    }
}