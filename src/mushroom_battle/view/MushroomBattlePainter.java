package mushroom_battle.view;

import java.awt.*;

import javax.swing.JPanel;

import sdk.model.*;
import sdk.view.*;


public class MushroomBattlePainter extends Painter{

    private final Coordinate coordinate;
    String imagePath;
    JPanel canvas, unit;

    public MushroomBattlePainter(View view, String imagePath, Sprite sprite){
        super(view, sprite);
        this.coordinate = sprite.getCoordinate();
        this.imagePath = imagePath;

        this.canvas = (JPanel) this.getRenderable();
        this.unit = createUnit(coordinate.getX(), coordinate.getY(), sprite.getWidth(), sprite.getHeight());
        this.canvas.add(unit);
    }

    private JPanel createUnit(int x, int y, int width, int height){
        System.out.printf("Create unit: %d, %d, %d, %d\n", x, y, width, height);
        unit = new JPanel();
        unit.setBackground(Color.BLUE);
        unit.setLocation(x, y);
        unit.setSize(width, height);
        return unit;
    }

    @Override
    public void paint(){

        if (this.sprite == null){
            throw new RuntimeException("Sprite not set in Painter before calling `paint`.");
        }
        if (sprite.getName().equals("Knife")){
            this.unit.setBackground(Color.RED);
        }
        this.unit.setLocation(coordinate.getX(), coordinate.getY());
        this.unit.setSize(sprite.getWidth(), sprite.getHeight());
    }
}