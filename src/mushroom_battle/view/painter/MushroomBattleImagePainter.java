package mushroom_battle.view.painter;

import javax.swing.JPanel;

import sdk.view.View;
import mushroom_battle.model.sprite.RectangleSprite;
import mushroom_battle.view.ImageJPanel;

public class MushroomBattleImagePainter extends MushroomBattlePainter {

    protected ImageJPanel image;

    public MushroomBattleImagePainter(View view, RectangleSprite sprite, String imagePath){
        super(view, sprite);
        this.image = (ImageJPanel) this.target;
        this.image.setImage(imagePath, sprite.width, sprite.height);
    }

    @Override
    protected JPanel createRectanglePanel(int x, int y, int width, int height){
        return new ImageJPanel();
    }
}