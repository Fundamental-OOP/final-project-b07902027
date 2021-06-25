package mushroom_battle.view;

import javax.swing.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import static java.util.Arrays.stream;

import java.awt.Color;

import sdk.view.Painter;
import sdk.view.View;
import sdk.view.Renderable;
import sdk.model.Sprite;
import sdk.model.World;


public class MushroomBattleView extends JFrame implements View{

    public static final int F_WIDTH = 800;
    public static final int F_HEIGHT = 500;
    private MushroomCanvas canvas;

    protected final List<Painter> painters = new CopyOnWriteArrayList<Painter>();

    public MushroomBattleView(){
        super("Mushroom Battle");
        this.canvas = new MushroomCanvas();
    }

    private void initAndShowGUI(){
        this.canvas.setLayout(null);
        this.canvas.setBackground(Color.LIGHT_GRAY);
        this.setContentPane(this.canvas);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(F_WIDTH, F_HEIGHT);
        this.setVisible(true);
    }

    @Override
    public void addPainters(Painter... painters) {
        stream(painters).forEach(this::addPainter);
    }

    @Override
    public void addPainter(Painter painter) {
        painters.add(painter);
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

    @Override 
    public void render(){
        for (Painter painter: this.painters){
            painter.paint();
        }
    }

    public class MushroomCanvas extends JPanel implements Renderable{

        public MushroomCanvas(){
            super();
        }

        @Override
        public int getFrameWidth(){
            return MushroomBattleView.F_WIDTH;
        }

        @Override
        public int getFrameHeight(){
            return MushroomBattleView.F_HEIGHT;
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