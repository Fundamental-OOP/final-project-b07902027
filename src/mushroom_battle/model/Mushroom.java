package mushroom_battle.model;

import mushroom_battle.view.MushroomBattlePainter;
import sdk.view.View;
import sdk.model.Sprite;
import sdk.model.Coordinate;


public class Mushroom extends Sprite {

    private Knife knife;

    public Mushroom(View view, String imagePath, Knife knife){
        super(new MushroomBattlePainter(view, imagePath), new Coordinate());
        this.knife = knife;
    }

    @Override
    public void update(){
        //System.out.printf("Mushroom update\n");
    }
}