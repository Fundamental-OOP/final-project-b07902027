package mushroom_battle.model;

import mushroom_battle.model.sprite.RectangleSprite;
import mushroom_battle.model.sprite.Mushroom;

public class ScoreBoard extends RectangleSprite{

    private int score;
    private Mushroom mushroom;

    public ScoreBoard(int x, int y, int width, int height){
        super("ScoreBoard", x, y, width, height);
        this.score = 0;
    }

    @Override
    public void update(){
        // ScoreBoard doesn't need update
    }

    @Override
    public String toString(){
        return String.valueOf(this.score);
    }

    public void setMushroom(Mushroom mushroom){
        this.mushroom = mushroom;
    }

    public Mushroom getMushroom(){
        return this.mushroom;
    }

    public int getScore(){
        return this.score;
    }

    public void increase(){
        this.score += 1;
    }

    public void reset(){
        this.score = 0;
    }
}
