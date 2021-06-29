package mushroom_battle.view.painter;

import java.awt.Color;

import sdk.view.View;
import sdk.model.RectangleSprite;
import mushroom_battle.model.sprite.*;

public class MushroomPainter extends MushroomBattlePainter {

    private Mushroom mushroom;

    public MushroomPainter(View view, String imagePath, RectangleSprite sprite){
        super(view, imagePath, sprite);
        if (!(sprite instanceof Mushroom)){
            throw new RuntimeException("Invalid Sprite type for MushroomPainter: " + sprite.getName());
        }
        this.mushroom = (Mushroom) sprite;
    }

    @Override
    public void paint(){
        super.paint();
        if (mushroom.isDead()){
            this.unit.setBackground(Color.BLACK);
        } else if (mushroom.hasKnife()){
            this.unit.setBackground(Color.BLUE);
        } else {
            this.unit.setBackground(Color.CYAN);
        }
    }
}
