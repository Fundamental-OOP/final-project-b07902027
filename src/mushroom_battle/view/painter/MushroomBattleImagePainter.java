package mushroom_battle.view.painter;

import javax.swing.JPanel;

import sdk.view.View;
import sdk.model.RectangleSprite;
import mushroom_battle.view.ImageJPanel;

public class MushroomBattleImagePainter extends MushroomBattlePainter {

    protected ImageJPanel image;

    public MushroomBattleImagePainter(View view, RectangleSprite sprite, String imagePath){
        super(view, sprite);
        this.image = (ImageJPanel) this.unit;
        this.image.setImage(imagePath, sprite.width, sprite.height);
    }

    @Override
    protected JPanel createUnit(int x, int y, int width, int height){
        return new ImageJPanel();
    }
}