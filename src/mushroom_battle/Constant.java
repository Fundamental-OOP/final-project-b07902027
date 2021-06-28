package mushroom_battle;

public final class Constant {

    private Constant(){}

    public final static int FRAME_WIDTH = 800;
    public final static int FRAME_HEIGHT = 500;
    public final static int MUSHROOM_X_SPEED = 3;
    public final static int MUSHROOM_Y_SPEED = -15;
    public final static int MUSHROOM_WIDTH = 40;
    public final static int MUSHROOM_HEIGHT = 40;
    public final static int KNIFE_WIDTH = 20;
    public final static int KNIFE_HEIGHT = 20;
    public final static int KNIFE_THROWING_SPEED = 20;
    public final static int KNIFE_DIRECTION_UPDATE_SPEED = 3;

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
}
