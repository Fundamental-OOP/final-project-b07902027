package mushroom_battle.model;

import sdk.model.*;


public class Knife extends Sprite {

    public Knife(Coordinate coordinate){
        super("Knife", coordinate, 20, 20);
    }

    public Knife(Coordinate coordinate, int width, int height){
        super("Knife", coordinate, width, height);
    }

    @Override
    public void update(){
        //System.out.printf("Knife update\n");
    }
}