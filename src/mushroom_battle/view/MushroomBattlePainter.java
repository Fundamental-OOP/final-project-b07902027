package mushroom_battle.view;

import java.awt.Color;

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
        unit = new JPanel();
        unit.setLocation(x, y);
        unit.setSize(width, height);
        return unit;
    }

    @Override
    public void paint(){

        if (this.sprite == null){
            throw new RuntimeException("Sprite not set in Painter before calling `paint`.");
        }
        // only when it's in development
        if (sprite.getName().equals("Knife")){
            this.unit.setBackground(Color.RED);
        } else if (sprite.getName().equals("Mushroom")) {
            this.unit.setBackground(Color.BLUE);
        } else if (sprite.getName().equals("Ground")){
            this.unit.setBackground(Color.GREEN);
        }
        this.unit.setLocation(coordinate.getX(), coordinate.getY());
        this.unit.setSize(sprite.getWidth(), sprite.getHeight());
        this.unit.setVisible(sprite.visible);
        // TODO: build special painter for each sprite
    }
}