package mushroom_battle.controller;

import sdk.model.World;
import sdk.view.View;


import mushroom_battle.model.MushroomBattleWorld;
import mushroom_battle.view.MushroomBattleView;
import sdk.controller.Game;


public class MushroomBattleGame extends Game{

    private int maxScore;
    private MushroomBattleWorld world;
    private MushroomBattleView view;
    public final static int NO_WINNER = -1;
    private int winnerIdx = NO_WINNER;

    public MushroomBattleGame(MushroomBattleWorld world, MushroomBattleView view, int fps, int maxScore){
        super(fps);
        this.world = world;
        this.view = view;
        this.maxScore = maxScore;
        view.setGame(this);
    }

    @Override
    public World getWorld(){
        return this.world;
    }

    @Override
    public View getView(){
        return this.view;
    }

    @Override
    public void checkIfGameEnds(){
        if (world.getMushroom(1).getScore() >= maxScore){
            this.running = false;
            this.winnerIdx = 1;
        } else if (world.getMushroom(2).getScore() >= maxScore){
            this.running = false;
            this.winnerIdx = 2;
        }
    }

    public int getWinnerIdx(){
        if (this.winnerIdx == NO_WINNER){
            throw new RuntimeException("Requesting winner index before endgame.");
        }
        return this.winnerIdx;
    }

    public void pushButton(int mushroomIdx){
        ((MushroomBattleWorld) this.world).getMushroom(mushroomIdx).pushButton();
    }
}