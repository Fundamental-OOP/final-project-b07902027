package mushroom_battle.view.painter;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import sdk.view.View;
import mushroom_battle.model.sprite.RectangleSprite;
import mushroom_battle.model.ScoreBoard;

public class ScoreBoardPainter extends MushroomBattlePainter{

    private ScoreBoard scoreBoard;
    private JLabel label;

    public ScoreBoardPainter(View view, RectangleSprite sprite, Color color){
        super(view, sprite);
        if (!(sprite instanceof ScoreBoard)){
            throw new RuntimeException("Invalid Sprite type for ScoreBoardPainter: " + sprite.getName());
        }
        this.scoreBoard = (ScoreBoard) sprite;
        this.label = new JLabel("Score: 0");
        this.label.setForeground(color);
        this.label.setFont(new Font("Verdana",1,20));
        this.target.add(label);
        this.target.setOpaque(false);
    }

    @Override
    public void paint(){
        super.paint();
        this.label.setText("Score: " + this.scoreBoard.toString());
    }
}

