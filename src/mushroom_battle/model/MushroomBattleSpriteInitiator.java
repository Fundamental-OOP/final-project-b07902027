package mushroom_battle.model;

import java.util.List;
import sdk.model.Sprite;
import sdk.model.BatchSpriteInitiator;


public class MushroomBattleSpriteInitiator implements BatchSpriteInitiator{

    @Override
    public void init(List<Sprite> sprites){
        SpriteInitEnum[] spriteEnums = SpriteInitEnum.values();
        for (SpriteInitEnum spriteEnum: spriteEnums){
            Sprite s = sprites.get(spriteEnum.getIdx());
            try{
                spriteEnum.init(s);
            } catch (ClassCastException e){
                System.out.println("Please check if Sprites' order in Wolrd's constructor matches SpriteInitEnum's order.");
                throw e;
            }
        }
    }
}
