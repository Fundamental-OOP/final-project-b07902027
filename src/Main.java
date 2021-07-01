import sdk.model.*;
import mushroom_battle.model.*;
import mushroom_battle.model.sprite.*;
import mushroom_battle.view.*;
import mushroom_battle.controller.*;
import mushroom_battle.view.painter.*;


import mushroom_battle.Constant;
import mushroom_battle.Constant.GOOMBA1;
import mushroom_battle.Constant.GOOMBA2;


public class Main{
    public static void main(String[] args){

        // model
        Goomba gb1 = new Goomba(Constant.GOOMBA_WIDTH, Constant.GOOMBA_HEIGHT, Constant.GOOMBA_THROWING_SPEED, Constant.GOOMBA_READY_MARK_RANGE, GOOMBA1.INIT_ANGLE, Constant.GOOMBA_DIRECTION_UPDATE_SPEED);
        Goomba gb2 = new Goomba(Constant.GOOMBA_WIDTH, Constant.GOOMBA_HEIGHT, Constant.GOOMBA_THROWING_SPEED, Constant.GOOMBA_READY_MARK_RANGE, GOOMBA2.INIT_ANGLE, Constant.GOOMBA_DIRECTION_UPDATE_SPEED);
        ScoreBoard scoreBoard1 = new ScoreBoard(Constant.BOARD1.INIT_X, Constant.BOARD1.INIT_Y, Constant.BOARD_WIDTH, Constant.BOARD_HEIGHT);
        ScoreBoard scoreBoard2 = new ScoreBoard(Constant.BOARD2.INIT_X, Constant.BOARD2.INIT_Y, Constant.BOARD_WIDTH, Constant.BOARD_HEIGHT);
        Mushroom m1 = new Mushroom(Constant.MUSHROOM_WIDTH, Constant.MUSHROOM_HEIGHT, scoreBoard1);
        Mushroom m2 = new Mushroom(Constant.MUSHROOM_WIDTH, Constant.MUSHROOM_HEIGHT, scoreBoard2);
        Ground ground = new Ground(Constant.GROUND.INIT_X, Constant.GROUND.INIT_Y, Constant.GROUND.WIDTH, Constant.GROUND.HEIGHT);
        Ground platform1 = new Ground(Constant.PLATFORM1_X, Constant.PLATFORM1_Y, Constant.PLATFORM1_WIDTH, Constant.PLATFORM_HEIGHT);
        Ground platform2 = new Ground(Constant.PLATFORM2_X, Constant.PLATFORM2_Y, Constant.PLATFORM2_WIDTH, Constant.PLATFORM_HEIGHT);
        Ground platform3 = new Ground(Constant.PLATFORM3_X, Constant.PLATFORM3_Y, Constant.PLATFORM3_WIDTH, Constant.PLATFORM_HEIGHT);
        CollisionHandlerCollector collector = new CollisionHandlerCollector(
            new GravityCollisionHandler(),
            new GoombaCollisionHandler(),
            new MushroomCollisionHandler()
        );
        Physic physic = new MushroomBattlePhysic(Constant.FRAME_WIDTH, Constant.FRAME_HEIGHT);
        BatchSpriteInitiator initiator = new MushroomBattleSpriteInitiator();
        MushroomBattleWorld world = new MushroomBattleWorld(physic, collector, initiator, 
            m1, m2, gb1, gb2, ground, platform1, platform2, platform3
        );

        // view
        MushroomBattleView view = new MushroomBattleView(Constant.FRAME_WIDTH, Constant.FRAME_HEIGHT); 

        // controller
        int fps = 60;
        int max_score = 5;
        MushroomBattleGame game = new MushroomBattleGame(world, view, fps, max_score);  

        // view.painter
        view.addPainters(
            new MushroomBattleImagePainter(view, gb1, "img/goomba.png"),
            new MushroomBattleImagePainter(view, gb2, "img/goomba.png"),
            new MushroomBattleImagePainter(view, m1, "img/mushroom1.png"),
            new MushroomBattleImagePainter(view, m2, "img/mushroom2.png"),
            new MushroomBattleImagePainter(view, ground, "img/ground.png"),
            new MushroomBattleImagePainter(view, platform1, "img/ground.png"),
            new MushroomBattleImagePainter(view, platform2, "img/ground.png"),
            new MushroomBattleImagePainter(view, platform3, "img/ground.png"),
            new GoombaMarkPainter(view, gb1, "img/goomba.png", Constant.GOOMBA_READY_MARK_SIZE),
            new GoombaMarkPainter(view, gb2, "img/goomba.png", Constant.GOOMBA_READY_MARK_SIZE),
            new ScoreBoardPainter(view, scoreBoard1, Constant.PLAYER1_COLOR),
            new ScoreBoardPainter(view, scoreBoard2, Constant.PLAYER2_COLOR),
            new GameOverPainter(view, game, Constant.GAMEOVER_X, Constant.GAMEOVER_Y, Constant.BOARD_WIDTH, Constant.BOARD_HEIGHT)
        );

        game.start();
    }
}
