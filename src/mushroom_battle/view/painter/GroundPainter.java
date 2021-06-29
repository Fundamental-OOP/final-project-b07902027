package mushroom_battle.view.painter;

import java.awt.Color;

import sdk.view.View;
import sdk.model.RectangleSprite;
import mushroom_battle.model.sprite.*;


public class GroundPainter extends MushroomBattlePainter{

    private Ground ground;

    public GroundPainter(View view, String imagePath, RectangleSprite sprite){
        super(view, imagePath, sprite);
        if (!(sprite instanceof Ground)){
            throw new RuntimeException("Invalid Sprite type for KnifePainter: " + sprite.getName());
        }
        this.ground = (Ground) sprite;
    }

    @Override
    public void paint(){
        super.paint();
        this.unit.setBackground(new Color(153, 102, 0));
    }
}