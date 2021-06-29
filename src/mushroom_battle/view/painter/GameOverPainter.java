package mushroom_battle.view.painter;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import mushroom_battle.Constant;
import sdk.view.Painter;
import sdk.view.Renderable;
import sdk.view.View;
import mushroom_battle.controller.MushroomBattleGame;


public class GameOverPainter implements Painter{

    protected int x, y, width, height;
    protected MushroomBattleGame game;
    protected final Renderable r;
    protected final JPanel unit;
    protected final JLabel label;

    public GameOverPainter(View view, MushroomBattleGame game, int x, int y, int width, int height, Color color){
        this.r = view.getRenderable();
        this.game = game;
        this.unit = createUnit(x, y, width, height);
        ((JPanel) r).add(unit);
        this.label = new JLabel("TEST");
        this.label.setFont(new Font(Constant.FONT_TYPE, 1, Constant.FONT_SIZE));
        this.unit.add(label);
        this.unit.setOpaque(false);
    }

    @Override
    public Renderable getRenderable(){
        return this.r;
    }

    @Override
    public void paint(){
        if (!game.isRunning()){
            this.unit.setVisible(true);
            this.label.setText("Player " + game.getWinnerIdx() + " WINS!");
            this.label.setForeground((game.getWinnerIdx() == 1) ? Constant.PLAYER1_COLOR : Constant.PLAYER2_COLOR);
        } else{
            this.unit.setVisible(false);
        }
    }

    private JPanel createUnit(int x, int y, int width, int height){
        JPanel secondaryPanel = new JPanel();
        secondaryPanel.setLocation(x, y);
        secondaryPanel.setSize(width, height);
        return secondaryPanel;
    }
}