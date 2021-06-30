package mushroom_battle.view;

import javax.swing.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import static java.util.Arrays.stream;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import sdk.view.Painter;
import sdk.view.View;
import sdk.view.Renderable;
import sdk.model.World;
import sdk.controller.Game;
import mushroom_battle.controller.MushroomBattleGame;


public class MushroomBattleView extends JFrame implements View{

    public static final int M1 = 1;
    public static final int M2 = 2;
    public final int frameWidth, frameHeight;
    private MushroomCanvas canvas;
    private MushroomBattleGame game;

    protected final List<Painter> painters = new CopyOnWriteArrayList<Painter>();

    public MushroomBattleView(int frameWidth, int frameHeight){
        super("Mushroom Battle");
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.setResizable(false);
        this.canvas = new MushroomCanvas();
    }

    @Override
    public void setGame(Game game){
        this.game = (MushroomBattleGame) game;
    }

    private void initAndShowGUI(){
        this.canvas.setLayout(null);
        this.setContentPane(this.canvas);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(frameWidth, frameHeight);
        this.setVisible(true);
        this.initController();
    }

    private void initController(){

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                switch (keyEvent.getKeyCode()) {
                    case KeyEvent.VK_SPACE:
                        game.pushButton(M1);
                        break;
                    case KeyEvent.VK_ENTER:
                        game.pushButton(M2);
                        break;
                }
            }
        });
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
            return frameWidth;
        }

        @Override
        public int getFrameHeight(){
            return frameHeight;
        }

        @Override
        public void render(World world){
            for (Painter painter: painters){
                painter.paint();
            }
            this.repaint();
        }

    }

}