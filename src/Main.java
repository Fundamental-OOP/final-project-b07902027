import sdk.model.*;
import sdk.view.*;
import sdk.controller.*;
import mushroom_battle.model.*;
import mushroom_battle.model.sprite.*;
import mushroom_battle.view.*;
import mushroom_battle.controller.*;


public class Main{
    public static void main(String[] args){

    
        // model
        Knife kf1 = new Knife();
        Knife kf2 = new Knife();
        Mushroom m1 = new Mushroom(kf1);
        Mushroom m2 = new Mushroom(kf2);
        Ground ground = new Ground();
        //Ground ground2 = new Ground(300, 275, 200, 50);
        CollisionHandler collisionHandler = new MushroomBattleCollisionHandler();
        Physic physic = new MushroomBattlePhysic(MushroomBattleView.F_WIDTH, MushroomBattleView.F_HEIGHT);
        World world = new MushroomBattleWorld(physic, collisionHandler, kf1, kf2, m1, m2, ground);

        // view
        View view = new MushroomBattleView(); 
        Painter kf1Painter = new MushroomBattlePainter(view, "src/knife.png", kf1);
        Painter kf2Painter = new MushroomBattlePainter(view, "src/knife.png", kf2);
        Painter m1Painter = new MushroomBattlePainter(view, "src/mushroom.png", m1);
        Painter m2Painter = new MushroomBattlePainter(view, "src/mushroom.png", m2);
        Painter groundPainter = new MushroomBattlePainter(view, "src/ground.png", ground);
        // Painter ground2Painter = new MushroomBattlePainter(view, "src/ground2.png", ground2);
        view.addPainters(kf1Painter, kf2Painter, m1Painter, m2Painter, groundPainter);

        // game
        int fps = 60;
        Game game = new MushroomBattleGame(world, view, fps);  // controller
        game.start();
    }
}
