import sdk.model.*;
import sdk.view.*;
import sdk.controller.*;
import mushroom_battle.model.*;
import mushroom_battle.view.*;
import mushroom_battle.controller.*;


public class Main{
    public static void main(String[] args){

    
        // model
        Knife kf1 = new Knife(new Coordinate());
        Knife kf2 = new Knife(new Coordinate());
        Mushroom m1 = new Mushroom(new Coordinate(), kf1);
        Mushroom m2 = new Mushroom(new Coordinate(), kf2);
        CollisionHandler collisionHandler = new MushroomBattleCollisionHandler();
        Physic physic = new MushroomBattlePhysic(MushroomBattleView.F_WIDTH, MushroomBattleView.F_HEIGHT);
        World world = new MushroomBattleWorld(physic, collisionHandler, kf1, kf2, m1, m2);


        // view
        View view = new MushroomBattleView(); 
        Painter kf1Painter = new MushroomBattlePainter(view, "src/knife.png", kf1);
        Painter kf2Painter = new MushroomBattlePainter(view, "src/knife.png", kf2);
        Painter m1Painter = new MushroomBattlePainter(view, "src/mushroom.png", m1);
        Painter m2Painter = new MushroomBattlePainter(view, "src/mushroom.png", m2);
        view.addPainters(kf1Painter, kf2Painter, m1Painter, m2Painter);

        // game
        int fps = 60;
        Game game = new MushroomBattleGame(world, view, fps);  // controller
        game.start();
    }
}
