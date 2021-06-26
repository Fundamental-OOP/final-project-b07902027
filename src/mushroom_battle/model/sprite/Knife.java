package mushroom_battle.model.sprite;


public class Knife extends ActiveSprite{

    public final static int WIDTH = 20, HEIGHT = 20;

    public Knife(){
        super("Knife", 0, 0, WIDTH, HEIGHT, 0, 0);
    }

    public Knife(int x, int y, int width, int height, int xSpeed, int ySpeed){
        super("Knife", x, y, width, height, xSpeed, ySpeed);
    }

    @Override
    public void update(){
    }
}