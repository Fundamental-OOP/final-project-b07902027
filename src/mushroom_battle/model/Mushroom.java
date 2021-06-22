package mushroom_battle.model;

import mushroom_battle.controller.*;
import sdk.model.*;


public class Mushroom extends Sprite {

    private Knife knife;

    public Mushroom(Knife knife){
        super(new MushroomBattlePainter("src/mushroom.png"));
        this.knife = knife;
    }
}