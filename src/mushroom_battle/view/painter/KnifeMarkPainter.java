package mushroom_battle.view.painter;

import javax.swing.JPanel;


import sdk.view.View;
import mushroom_battle.model.KnifeDirection;
import mushroom_battle.model.sprite.Knife;
import mushroom_battle.view.ImageJPanel;

public class KnifeMarkPainter extends MushroomBattlePainter{

    private final KnifeDirection direction;
    private final Knife knife;
    private ImageJPanel image;

    public KnifeMarkPainter(View view, Knife knife, String imagePath, int markSize){
        super(view, knife);
        this.knife = knife;
        this.image = (ImageJPanel) this.unit;
        this.image.setImage(imagePath, markSize, markSize);
        this.direction = knife.getDirection();
        resetLocation();
        this.unit.setSize(markSize, markSize);
    }

    @Override
    protected JPanel createUnit(int x, int y, int width, int height){
        return new ImageJPanel();
    }

    public void paint(){
        if (knife.hasOwner()){
            this.unit.setVisible(true);
            resetLocation();
        } else{
            this.unit.setVisible(false);
        }
    }

    protected void resetLocation(){
        this.unit.setLocation(knife.x + knife.getOwner().width / 2 + direction.getReadyX() - 4,
                              knife.y + knife.getOwner().height / 2 + direction.getReadyY());
    }

}