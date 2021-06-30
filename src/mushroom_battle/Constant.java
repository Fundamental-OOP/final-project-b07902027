package mushroom_battle;

import java.awt.Color;

public final class Constant {

    private Constant(){}

    public final static int FONT_SIZE = 20;
    public final static String FONT_TYPE = "Verdana";

    public final static int FRAME_WIDTH = 1000;
    public final static int FRAME_HEIGHT = 600;

    public final static int MUSHROOM_X_SPEED = 4;
    public final static int MUSHROOM_Y_SPEED = -17;
    public final static int MUSHROOM_WIDTH = 40;
    public final static int MUSHROOM_HEIGHT = 40;

    public final static int KNIFE_WIDTH = 20;
    public final static int KNIFE_HEIGHT = 20;
    public final static int KNIFE_THROWING_SPEED = 23;
    public final static int KNIFE_DIRECTION_UPDATE_SPEED = 5;
    public final static int KNIFE_READY_MARK_RANGE = 40;
    public final static int KNIFE_READY_MARK_SIZE = 15;

    public final static int BOARD_WIDTH = 300;
    public final static int BOARD_HEIGHT = 100;
    public final static int GAMEOVER_X = 350;
    public final static int GAMEOVER_Y = 100;

    public final static Color PLAYER1_COLOR = new Color(186, 26, 26);
    public final static Color PLAYER2_COLOR = new Color(50, 168, 82);

    // specific initialization setting
    public final static class MUSHROOM1{
        public final static int INIT_X = 0;
        public final static int INIT_Y = FRAME_HEIGHT - GROUND.HEIGHT - MUSHROOM_HEIGHT;
        public final static int INIT_X_SPEED = MUSHROOM_X_SPEED;
        public final static int INIT_Y_SPEED = 0;
    };
    public final static class MUSHROOM2{
        public final static int INIT_X = FRAME_WIDTH - MUSHROOM_WIDTH;
        public final static int INIT_Y = FRAME_HEIGHT - GROUND.HEIGHT - MUSHROOM_HEIGHT;
        public final static int INIT_X_SPEED = -MUSHROOM_X_SPEED;
        public final static int INIT_Y_SPEED = 0;
    };
    public final static class KNIFE1{
        public final static int INIT_ANGLE = 0;
    }
    public final static class KNIFE2{
        public final static int INIT_ANGLE = 180;
    }
    public final static class GROUND{
        public final static int WIDTH = FRAME_WIDTH;
        public final static int HEIGHT = (int) FRAME_HEIGHT / 4;
        public final static int INIT_X = 0;
        public final static int INIT_Y = FRAME_HEIGHT - HEIGHT;
    };
    public final static class BOARD1{
        public final static int INIT_X = FRAME_WIDTH / 4 - BOARD_WIDTH / 2;
        public final static int INIT_Y = 100;
    }
    public final static class BOARD2{
        public final static int INIT_X = FRAME_WIDTH * 3/4 - BOARD_WIDTH / 2;
        public final static int INIT_Y = 100;
    }
}
