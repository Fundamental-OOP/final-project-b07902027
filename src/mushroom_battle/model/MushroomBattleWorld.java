package mushroom_battle.model;

import sdk.model.*;
import mushroom_battle.model.sprite.*;


public class MushroomBattleWorld extends World{

    private Knife kf1, kf2;
    private Mushroom m1, m2;
    private Ground ground;

    public MushroomBattleWorld(Physic physic, CollisionHandler collisionHandler, Sprite... sprites){
        super(physic, collisionHandler, sprites);
    }

    @Override
    protected void initSprites(Sprite... sprites){
        try{
            this.kf1 = (Knife) sprites[0];
            this.kf2 = (Knife) sprites[1];
            this.m1 = (Mushroom) sprites[2];
            this.m2 = (Mushroom) sprites[3];
            this.ground = (Ground) sprites[4];
        } catch (ClassCastException e){
            throw new RuntimeException("Invalid argument number during MushroomBattleWorld's construction.");
        } catch (ArrayIndexOutOfBoundsException e){
            throw new RuntimeException("Invalid argument number during MushroomBattleWorld's construction.");
        }
        
        this.initCoordinates();
    }

    protected void initCoordinates(){

        m1.getCoordinate().reset(
            0, 
            physic.getBorderY() - ground.getHeight() - m1.getHeight(),
            Mushroom.INIT_SPEED,
            0
        );

        m2.getCoordinate().reset(
            physic.getBorderX() - m2.getWidth(), 
            physic.getBorderY() - ground.getHeight() - m2.getHeight(), 
            -Mushroom.INIT_SPEED, 
            0
        );

        kf1.getCoordinate().reset(
            m1.getCoordinate().getX() + 10,
            m1.getCoordinate().getY() - kf1.getHeight(),
            Mushroom.INIT_SPEED,
            0
        );

        kf2.getCoordinate().reset(
            m2.getCoordinate().getX() + 10,
            m2.getCoordinate().getY() - kf2.getHeight(),
            -Mushroom.INIT_SPEED, 
            0
        );

        ground.getCoordinate().reset(0, physic.getBorderY() - ground.getHeight(), 0, 0);
    }
}