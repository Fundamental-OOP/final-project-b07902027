package mushroom_battle.model;

import java.util.List;
import sdk.model.Sprite;
import sdk.model.BatchSpriteInitiator;


public class MushroomBattleSpriteInitiator implements BatchSpriteInitiator{

    @Override
    public void init(List<Sprite> sprites){
        SpriteEnum[] spriteEnums = SpriteEnum.values();
        for (SpriteEnum spriteEnum: spriteEnums){
            Sprite s = sprites.get(spriteEnum.getIdx());
            try{
                spriteEnum.init(s);
            } catch (ClassCastException e){
                System.out.println("Please check if Sprites' order in Wolrd's constructor matches SpriteEnum's order.");
                throw e;
            }
        }
    }
}
