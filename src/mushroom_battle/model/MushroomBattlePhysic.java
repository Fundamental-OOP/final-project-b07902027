package mushroom_battle.model;

import sdk.view.*;
import sdk.model.*;


public class MushroomBattlePhysic extends Physic{

    public final static double initSpeed = 0.01;

    public MushroomBattlePhysic(View view){
        super(view);
    }

    @Override
    public void initCoordinates(Sprite... sprites){
        if (sprites.length != 4){
            throw new RuntimeException("Invalid argument number for Physic.initAll !\n");
        }
        sprites[0].getCoordinate().reset(0, 0, 0, 0);
    }
    
}