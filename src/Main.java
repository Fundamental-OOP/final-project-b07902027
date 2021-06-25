import sdk.model.*;
import sdk.view.*;
import sdk.controller.*;
import mushroom_battle.model.*;
import mushroom_battle.view.*;
import mushroom_battle.controller.*;


public class Main{
    public static void main(String[] args){

        // view
        View view = new MushroomBattleView();  

        // model
        Painter kf1Painter = new MushroomBattlePainter(view, "src/knife.png");
        Knife kf1 = new Knife(kf1Painter, new Coordinate());

        Painter kf2Painter = new MushroomBattlePainter(view, "src/knife.png");
        Knife kf2 = new Knife(kf2Painter, new Coordinate());

        Painter m1Painter = new MushroomBattlePainter(view, "src/mushroom.png");
        Mushroom m1 = new Mushroom(m1Painter, new Coordinate(), kf1);

        Painter m2Painter = new MushroomBattlePainter(view, "src/mushroom.png");
        Mushroom m2 = new Mushroom(m2Painter, new Coordinate(), kf2);

        CollisionHandler collisionHandler = new MushroomBattleCollisionHandler();
        Physic physic = new MushroomBattlePhysic(view);
        World world = new MushroomBattleWorld(physic, collisionHandler, m1, m2, kf1, kf2);

        // game
        int fps = 60;
        Game game = new MushroomBattleGame(world, view, fps);  // controller
        game.start();
    }
}
