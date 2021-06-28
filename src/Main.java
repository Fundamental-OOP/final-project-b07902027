import sdk.model.*;
import sdk.view.*;
import sdk.controller.*;
import mushroom_battle.model.*;
import mushroom_battle.model.sprite.*;
import mushroom_battle.view.*;
import mushroom_battle.controller.*;
import mushroom_battle.Constant;


public class Main{
    public static void main(String[] args){

        // TODO: modify coordinate, width, height initialization to Constructor
        

        // model
        Knife kf1 = new Knife(Constant.KNIFE_WIDTH, Constant.KNIFE_HEIGHT, Constant.KNIFE_THROWING_SPEED);
        Knife kf2 = new Knife(Constant.KNIFE_WIDTH, Constant.KNIFE_HEIGHT, Constant.KNIFE_THROWING_SPEED);
        Mushroom m1 = new Mushroom(Constant.MUSHROOM_WIDTH, Constant.MUSHROOM_HEIGHT);
        Mushroom m2 = new Mushroom(Constant.MUSHROOM_WIDTH, Constant.MUSHROOM_HEIGHT);
        m1.setKnife(kf1);
        m2.setKnife(kf2);
        Ground ground = new Ground(Constant.GROUND.INIT_X, Constant.GROUND.INIT_Y,
                                   Constant.GROUND.WIDTH, Constant.GROUND.HEIGHT);
                                   
        //Ground ground2 = new Ground(300, 275, 200, 50);
        CollisionHandlerCollector collector = new CollisionHandlerCollector(
            new GravityCollisionHandler(),
            new KnifeCollisionHandler()
        );
        Physic physic = new MushroomBattlePhysic(MushroomBattleView.F_WIDTH, MushroomBattleView.F_HEIGHT);
        BatchSpriteInitiator initiator = new MushroomBattleSpriteInitiator();
        World world = new MushroomBattleWorld(physic, collector, initiator, m1, m2, kf1, kf2, ground);

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
        int max_score = 5;
        Game game = new MushroomBattleGame(world, view, fps, max_score);  // controller
        game.start();
    }
}
