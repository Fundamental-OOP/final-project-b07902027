package mushroom_battle.view.painter;

import java.awt.Color;

import sdk.view.View;
import sdk.model.RectangleSprite;
import mushroom_battle.model.sprite.*;

public class KnifePainter extends MushroomBattlePainter{

    private Knife knife;

    public KnifePainter(View view, String imagePath, RectangleSprite sprite){
        super(view, imagePath, sprite);
        if (!(sprite instanceof Knife)){
            throw new RuntimeException("Invalid Sprite type for KnifePainter: " + sprite.getName());
        }
        this.knife = (Knife) sprite;
    }

    @Override
    public void paint(){
        super.paint();
        this.unit.setBackground(Color.RED);
    }
}
