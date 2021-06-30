package mushroom_battle.view.painter;

import javax.swing.JPanel;


import sdk.view.View;
import mushroom_battle.model.GoombaDirection;
import mushroom_battle.model.sprite.Goomba;
import mushroom_battle.view.ImageJPanel;

public class GoombaMarkPainter extends MushroomBattlePainter{

    private final GoombaDirection direction;
    private final Goomba goomba;
    private ImageJPanel image;

    public GoombaMarkPainter(View view, Goomba goomba, String imagePath, int markSize){
        super(view, goomba);
        this.goomba = goomba;
        this.image = (ImageJPanel) this.unit;
        this.image.setImage(imagePath, markSize, markSize);
        this.direction = goomba.getDirection();
        resetLocation();
        this.unit.setSize(markSize, markSize);
    }

    @Override
    protected JPanel createUnit(int x, int y, int width, int height){
        return new ImageJPanel();
    }

    public void paint(){
        if (goomba.hasOwner()){
            this.unit.setVisible(true);
            resetLocation();
        } else{
            this.unit.setVisible(false);
        }
    }

    protected void resetLocation(){
        this.unit.setLocation(goomba.x + goomba.getOwner().width / 2 + direction.getReadyX() - 4,
                              goomba.y + goomba.getOwner().height / 2 + direction.getReadyY());
    }

}