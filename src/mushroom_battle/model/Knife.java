package mushroom_battle.model;

import sdk.model.*;
import sdk.view.View;
import mushroom_battle.view.MushroomBattlePainter;


public class Knife extends Sprite {
    

    public Knife(View view, String imagePath){
        super(new MushroomBattlePainter(view, imagePath), new Coordinate());
    }

    @Override
    public void update(){
        //System.out.printf("Knife update\n");
    }
}