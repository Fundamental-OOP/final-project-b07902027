package mushroom_battle.model.sprite;


public class Ground extends RectangleSprite{
    
    public Ground(int x, int y, int width, int height){
        super("Ground", x, y, width, height);
    }

    public Ground(int width, int height){
        super("Ground", 0, 0, width, height);
    }

    @Override
    public void update() {
        // Ground doesn't need any update
    }

}
