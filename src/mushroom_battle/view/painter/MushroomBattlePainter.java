package mushroom_battle.view.painter;

import java.awt.Rectangle;
import javax.swing.JPanel;

import sdk.view.*;
import mushroom_battle.model.sprite.RectangleSprite;


abstract public class MushroomBattlePainter extends SpritePainter{

    Rectangle spriteBody;
    JPanel canvas, target;

    public MushroomBattlePainter(View view, RectangleSprite sprite){
        super(view, sprite);
        this.spriteBody = sprite;

        this.canvas = (JPanel) this.getRenderable();
        this.target = createRectanglePanel(spriteBody.x, spriteBody.y, spriteBody.width, spriteBody.height);
        this.canvas.add(target);
    }

    protected JPanel createRectanglePanel(int x, int y, int width, int height){
        JPanel secondaryPanel = new JPanel();
        secondaryPanel.setLocation(x, y);
        secondaryPanel.setSize(width, height);
        return secondaryPanel;
    }

    public void paint(){
        this.target.setLocation(spriteBody.x, spriteBody.y);
        this.target.setSize(spriteBody.width, spriteBody.height);
        this.target.setVisible(sprite.isVisible());
        // subclasses should override this method for more specific painting
    }
}