package mushroom_battle.model;

import sdk.model.*;
import mushroom_battle.model.sprite.*;
import mushroom_battle.view.MushroomBattleView;


public class MushroomBattleWorld extends World{

    private Knife kf1, kf2;
    private Mushroom m1, m2;
    private Ground ground;

    public MushroomBattleWorld(Physic physic, CollisionHandler collisionHandler, Sprite... sprites){
        super(physic, collisionHandler, sprites);
    }

    public Mushroom getMushroom(int mushroomIdx){
        return (mushroomIdx == 1) ? m1 : m2;
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

        m1.setLocation(0, (int) (physic.getBorderY() - ground.getHeight() - m1.getHeight()));
        m1.setSpeed(Mushroom.INIT_X_SPEED, 0);

        m2.setLocation((int) (physic.getBorderX() - m2.getWidth()), 
                       (int) (physic.getBorderY() - ground.getHeight() - m2.getHeight()));
        m2.setSpeed(-Mushroom.INIT_X_SPEED, 0);

        kf1.setLocation(m1.x + 10, (int) (m1.y - kf1.getHeight()));
        kf1.setSpeed(Mushroom.INIT_X_SPEED, 0);

        kf2.setLocation(m2.x + 10, (int) (m2.y - kf2.getHeight()));
        kf2.setSpeed(-Mushroom.INIT_X_SPEED,  0);

        // TODO: Fix the 10
        ground.setBounds(0, physic.getBorderY() - (int) ground.getHeight(), 
                         MushroomBattleView.F_WIDTH,(int) (MushroomBattleView.F_HEIGHT / 4));

    }
}