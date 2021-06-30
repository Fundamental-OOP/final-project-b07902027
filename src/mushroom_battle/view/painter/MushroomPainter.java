package mushroom_battle.view.painter;

import sdk.view.View;
import sdk.model.RectangleSprite;
import mushroom_battle.model.sprite.*;

public class MushroomPainter extends MushroomBattleImagePainter {

    public MushroomPainter(View view, RectangleSprite sprite, String imagePath){
        super(view, sprite, imagePath);
        if (!(sprite instanceof Mushroom)){
            throw new RuntimeException("Invalid Sprite type for MushroomPainter: " + sprite.getName());
        }
    }
}