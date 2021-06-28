package mushroom_battle.controller;

import sdk.model.World;
import sdk.view.View;
import mushroom_battle.model.MushroomBattleWorld;
import sdk.controller.Game;


public class MushroomBattleGame extends Game{

    private int maxScore;
    private MushroomBattleWorld mushroomWolrd;

    public MushroomBattleGame(World world, View view, int fps, int maxScore){
        super(world, view, fps);
        this.mushroomWolrd = (MushroomBattleWorld) world; // TODO: use sprites[WORLD] to get world
        this.maxScore = maxScore;
        view.setGame(this);
    }

    public void pushButton(int mushroomIdx){
        ((MushroomBattleWorld) this.world).getMushroom(mushroomIdx).pushButton();
    }

    @Override
    public void checkIfGameEnds(){
        // TODO
    }
}