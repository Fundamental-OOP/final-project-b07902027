package mushroom_battle.model;

import sdk.model.SpriteIndexConvertable;
import sdk.model.SpriteInitiator;
import sdk.model.Sprite;
import mushroom_battle.model.sprite.*;
import mushroom_battle.Constant;

public enum SpriteInitEnum implements SpriteIndexConvertable, SpriteInitiator{

    MUSHROOM1(new SpriteInitiator(){
        @Override
        public void init(Sprite sprite){
            Mushroom m1 = (Mushroom) sprite;
            m1.setLocation(Constant.MUSHROOM1.INIT_X, Constant.MUSHROOM1.INIT_Y);
            m1.setSpeed(Constant.MUSHROOM1.INIT_X_SPEED, Constant.MUSHROOM1.INIT_Y_SPEED);
            m1.setAlive();
            m1.setKnife((Knife) m1.getWorld().getSprite(KNIFE1));
        }
    }),

    MUSHROOM2(new SpriteInitiator(){
        @Override
        public void init(Sprite sprite){
            Mushroom m2 = (Mushroom) sprite;
            m2.setLocation(Constant.MUSHROOM2.INIT_X, Constant.MUSHROOM2.INIT_Y);
            m2.setSpeed(Constant.MUSHROOM2.INIT_X_SPEED, Constant.MUSHROOM2.INIT_Y_SPEED);
            m2.setAlive();
            m2.setKnife((Knife) m2.getWorld().getSprite(KNIFE2));
        }
    }),

    KNIFE1(new SpriteInitiator(){
        @Override
        public void init(Sprite sprite){
            // it's owned by m1
        }
    }),

    KNIFE2(new SpriteInitiator(){
        @Override
        public void init(Sprite sprite){
            // it's owned by m2
        }
    }),

    GROUND(new SpriteInitiator(){
        @Override
        public void init(Sprite sprite){
            ((Ground) sprite).setLocation(Constant.GROUND.INIT_X, Constant.GROUND.INIT_Y);
        }
    });

    private SpriteInitiator initiator;

    SpriteInitEnum(SpriteInitiator initiator){
        this.initiator = initiator;
    }

    public int getIdx(){
        return ordinal();
    }

    public void init(Sprite sprite){
        this.initiator.init(sprite);
    }
}