package mushroom_battle.model.sprite;

import sdk.model.Sprite;
import sdk.model.Coordinate;


public class Mushroom extends Sprite {

    public final static int INIT_SPEED = 1;
    private Knife knife;

    public Mushroom(Coordinate coordinate, Knife knife){
        super("Mushroom", coordinate, 40, 40);
        this.knife = knife;
    }

    public Mushroom(Coordinate coordinate, int width, int height, Knife knife){
        super("Mushroom", coordinate, width, height);
        this.knife = knife;
    }

    @Override
    public void update(){
        //System.out.printf("Mushroom update\n");
    }
}