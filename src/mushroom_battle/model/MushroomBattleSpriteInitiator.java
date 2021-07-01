package mushroom_battle.model;

import java.util.List;
import sdk.model.Sprite;
import sdk.model.SpriteInitiator;
import sdk.model.BatchSpriteInitiator;


public class MushroomBattleSpriteInitiator implements BatchSpriteInitiator{

    @Override
    public SpriteInitiator[] getSpriteInitiators(){
        return SpriteInitEnum.values();
    }

    @Override
    public void init(List<Sprite> sprites){
        for (SpriteInitiator spriteInitiator: getSpriteInitiators()){
            Sprite s = sprites.get(((SpriteInitEnum) spriteInitiator).getIdx());
            try{
                spriteInitiator.init(s);
            } catch (ClassCastException e){
                System.out.println("Please check if Sprites' order in Wolrd's constructor matches SpriteInitEnum's order.");
                throw e;
            }
        }
    }
}
