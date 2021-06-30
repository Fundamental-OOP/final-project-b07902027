package mushroom_battle.view.painter;

import java.awt.Color;

import sdk.view.View;
import sdk.model.RectangleSprite;
import mushroom_battle.model.sprite.*;

public class KnifePainter extends MushroomBattlePainter{

    public KnifePainter(View view, String imagePath, RectangleSprite sprite){
        super(view, sprite);
        if (!(sprite instanceof Knife)){
            throw new RuntimeException("Invalid Sprite type for KnifePainter: " + sprite.getName());
        }
        this.unit.setBackground(Color.RED);
    }

    @Override
    public void paint(){
        super.paint();
    }
}
