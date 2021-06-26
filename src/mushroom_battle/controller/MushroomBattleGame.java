package mushroom_battle.controller;

import sdk.model.World;
import sdk.view.View;
import mushroom_battle.model.MushroomBattleWorld;
import sdk.controller.Game;


public class MushroomBattleGame extends Game{
    public MushroomBattleGame(World world, View view, int fps){
        super(world, view, fps);
        view.setGame(this);
    }

    public void jump(int mushroomIdx){
        ((MushroomBattleWorld) this.world).getMushroom(mushroomIdx).jump();
    }
}