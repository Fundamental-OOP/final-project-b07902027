package mushroom_battle.model.sprite;


public class Mushroom extends ActiveSprite{

    public final static int INIT_X_SPEED = 2;
    public final static int INIT_Y_SPEED = -15;
    public final static int WIDTH = 40, HEIGHT = 40;

    private Knife knife;

    public Mushroom(Knife knife){
        super("Mushroom", 0, 0, WIDTH, HEIGHT, INIT_X_SPEED, 0);
        this.knife = knife;
    }

    public Mushroom(int x, int y, int width, int height, int xSpeed, int ySpeed, Knife knife){
        super("Mushroom", x, y, width, height, xSpeed, ySpeed);
        this.knife = knife;
    }

    @Override
    public void update(){
    }

    public void pushButton(){
        if (hasKnife()){
            throwKnife();
        } else {
            jump();
        }
    }

    public boolean hasKnife(){
        // TODO: return this.knife == null;
        return false;
    }

    public void jump(){
        if (!this.isFalling){
            this.isFalling = true;
            this.ySpeed = INIT_Y_SPEED;
        }
    }

    public void throwKnife(){

    }
}