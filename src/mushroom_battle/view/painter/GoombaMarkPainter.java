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
        this.image = (ImageJPanel) this.target;
        this.image.setImage(imagePath, markSize, markSize);
        this.direction = goomba.getDirection();
        resetLocation();
        this.target.setSize(markSize, markSize);
    }

    @Override
    protected JPanel createRectanglePanel(int x, int y, int width, int height){
        return new ImageJPanel();
    }

    public void paint(){
        if (goomba.hasOwner()){
            this.target.setVisible(true);
            resetLocation();
        } else{
            this.target.setVisible(false);
        }
    }

    protected void resetLocation(){
        this.target.setLocation(goomba.x + goomba.getOwner().width / 2 + direction.getReadyX() - 4,
                              goomba.y + goomba.getOwner().height / 2 + direction.getReadyY());
    }

}