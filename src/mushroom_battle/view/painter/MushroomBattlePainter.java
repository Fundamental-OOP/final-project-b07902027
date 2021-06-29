package mushroom_battle.view.painter;

import java.awt.Rectangle;
import javax.swing.JPanel;

import sdk.model.*;
import sdk.view.*;


abstract public class MushroomBattlePainter extends Painter{

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

    public void paint(){
        this.unit.setLocation(spriteBody.x, spriteBody.y);
        this.unit.setSize(spriteBody.width, spriteBody.height);
        this.unit.setVisible(sprite.isVisible());
        // subclasses should override this method for more specific painting
    }
}