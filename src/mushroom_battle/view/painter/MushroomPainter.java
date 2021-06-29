package mushroom_battle.view.painter;

import java.awt.Color;

import sdk.view.View;
import sdk.model.RectangleSprite;
import mushroom_battle.model.sprite.*;

public class MushroomPainter extends MushroomBattlePainter {

    private Mushroom mushroom;
    private Color color;

    public MushroomPainter(View view, String imagePath, RectangleSprite sprite, Color color){
        super(view, sprite);
        if (!(sprite instanceof Mushroom)){
            throw new RuntimeException("Invalid Sprite type for MushroomPainter: " + sprite.getName());
        }
        this.mushroom = (Mushroom) sprite;
        this.color = color;
    }

    @Override
    public void paint(){
        super.paint();
        if (mushroom.isDead()){
            this.unit.setBackground(Color.BLACK);
        } else if (mushroom.hasKnife()){
            this.unit.setBackground(color);
        } else {
            this.unit.setBackground(color.darker().darker());
        }
    }
}
