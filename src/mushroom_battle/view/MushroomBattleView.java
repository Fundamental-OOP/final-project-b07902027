package mushroom_battle.view;

import javax.swing.*;

import sdk.view.*;
import sdk.controller.*;
import sdk.model.Sprite;
import sdk.model.World;


public class MushroomBattleView extends JFrame implements View{

    private static final int WIDTH = 700;
    private static final int HEIGHT = 400;
    private MushroomCanvas canvas;
    private Game game;

    public MushroomBattleView(){
        super("Mushroom Battle");
        this.canvas = new MushroomCanvas();
    }

    @Override
    public void setGame(Game game){
        this.game = game;
    }

    @Override
    public Game getGame(){
        return this.game;
    }

    private void initAndShowGUI(){
        this.canvas.setLayout(null);
        this.setContentPane(this.canvas);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setVisible(true);
    }

    @Override
    public void launch(){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                initAndShowGUI();
            }
        });
    }

    @Override
    public Renderable getRenderable(){
        return this.canvas;
    }

    public class MushroomCanvas extends JPanel implements Renderable{

        public MushroomCanvas(){
            super();
        }

        @Override
        public int getFrameWidth(){
            return MushroomBattleView.WIDTH;
        }

        @Override
        public int getFrameHeight(){
            return MushroomBattleView.HEIGHT;
        }

        @Override
        public void render(World world){
            for (Sprite sprite : world.getSprites()){
                sprite.getPainter().paint();
            }
            this.repaint();
        }

    }

}