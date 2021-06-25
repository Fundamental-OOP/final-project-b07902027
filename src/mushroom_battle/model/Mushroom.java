package mushroom_battle.model;

import sdk.view.Painter;
import sdk.model.Sprite;
import sdk.model.Coordinate;


public class Mushroom extends Sprite {

    private Knife knife;

    public Mushroom(Painter painter, Coordinate coordinate, Knife knife){
        super(painter, coordinate);
        this.knife = knife;
    }

    @Override
    public void update(){
        //System.out.printf("Mushroom update\n");
    }
}