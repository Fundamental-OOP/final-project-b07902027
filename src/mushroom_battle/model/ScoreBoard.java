package mushroom_battle.model;

public class ScoreBoard {

    private int score;

    public ScoreBoard(){
        this.score = 0;
    }

    @Override
    public String toString(){
        return String.valueOf(this.score);
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
