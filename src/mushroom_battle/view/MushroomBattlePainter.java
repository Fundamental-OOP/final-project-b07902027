package mushroom_battle.view;

import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JPanel;

import sdk.model.*;
import sdk.view.*;


public class MushroomBattlePainter extends Painter{

    Rectangle spriteBody;
    String imagePath;
    JPanel canvas, unit;

    public MushroomBattlePainter(View view, String imagePath, RectangleSprite sprite){
        super(view, sprite);
        this.spriteBody = sprite;
        this.imagePath = imagePath;

        this.canvas = (JPanel) this.getRenderable();
        this.unit = createUnit(spriteBody.x, spriteBody.y, spriteBody.width, spriteBody.height);
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
        
        this.unit.setLocation(spriteBody.x, spriteBody.y);
        this.unit.setSize(spriteBody.width, spriteBody.height);
        this.unit.setVisible(sprite.isVisible());
        // TODO: build special painter for each sprite
    }
}