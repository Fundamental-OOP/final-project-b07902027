package mushroom_battle.model;

import sdk.model.*;


public class MushroomBattleWorld extends World{

    private Knife kf1, kf2;
    private Mushroom m1, m2;

    public MushroomBattleWorld(Physic physic, CollisionHandler collisionHandler, Sprite... sprites){
        super(physic, collisionHandler, sprites);
    }

    @Override
    protected void initSprites(Sprite... sprites){
        if (sprites.length != 4){
            throw new RuntimeException("Invalid argument number during MushroomBattleWorld's construction:" +
            " Mushroom Battle requires 4 sprites (kf1, kf2, mushroom1, mushroom2) respectively!\n");
        }
        try{
            this.kf1 = (Knife) sprites[0];
            this.kf2 = (Knife) sprites[1];
            this.m1 = (Mushroom) sprites[2];
            this.m2 = (Mushroom) sprites[3];
        } catch (ClassCastException e){
            throw new RuntimeException("Invalid argument number during MushroomBattleWorld's construction:" +
            " Mushroom Battle requires 4 sprites (kf1, kf2, mushroom1, mushroom2) respectively!\n");
        }
        
        this.initCoordinates();
    }

    protected void initCoordinates(){
        kf1.getCoordinate().reset(
            0, 
            physic.getBorderY() - kf1.getHeight() - m1.getHeight(), 
            Mushroom.INIT_SPEED, 
            0
        );

        kf2.getCoordinate().reset(
            physic.getBorderX() - kf2.getWidth(), 
            physic.getBorderY() - kf2.getHeight() - m2.getHeight(), 
            -Mushroom.INIT_SPEED, 
            0
        );

        m1.getCoordinate().reset(
            0, 
            physic.getBorderY() - m1.getHeight(), 
            Mushroom.INIT_SPEED, 
            0
        );

        m2.getCoordinate().reset(
            physic.getBorderX() - m2.getWidth(), 
            physic.getBorderY() - m2.getHeight(), 
            -Mushroom.INIT_SPEED, 
            0
        );
    }
}