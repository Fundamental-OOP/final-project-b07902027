import java.util.ArrayList;

import sdk.model.*;
import sdk.view.*;
import sdk.controller.*;

import mushroom_battle.model.*;
import mushroom_battle.view.*;
import mushroom_battle.controller.*;


public class Main{
    public static void main(String[] args){
        Knife kf1 = new Knife();
        Knife kf2 = new Knife();
        Mushroom m1 = new Mushroom(kf1);
        Mushroom m2 = new Mushroom(kf2);

        CollisionHandler collisionHandler = new MushroomBattleCollisionHandler();
        View view = new MushroomBattleView();  // view
        Physic physic = new MushroomBattlePhysic(view);
        World world = new MushroomBattleWorld(physic, collisionHandler, m1, m2, kf1, kf2);  // model

        int fps = 60;
        Game game = new MushroomBattleGame(world, view, fps);  // controller
        
        game.start();
    }
}
