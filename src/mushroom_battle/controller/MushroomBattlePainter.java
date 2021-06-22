package mushroom_battle.controller;

import sdk.model.*;
import sdk.view.*;
import sdk.controller.*;


public class MushroomBattlePainter implements Painter{

    private Sprite sprite;
    String imagePath;

    public MushroomBattlePainter(String imagePath){
        this.imagePath = imagePath;
    }

    @Override
    public void setSprite(Sprite sprite){
        this.sprite = sprite;
    }

    @Override
    public Sprite getSprite(){
        return this.sprite;
    }

    @Override
    public void paint(Renderable r){

    }
}