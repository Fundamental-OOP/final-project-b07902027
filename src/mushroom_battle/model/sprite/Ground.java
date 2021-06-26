package mushroom_battle.model.sprite;

import sdk.model.RectangleSprite;
import mushroom_battle.view.MushroomBattleView;

public class Ground extends RectangleSprite{
    
    public Ground(int x, int y, int width, int height){
        super("Ground", x, y, width, height);
    }

    public Ground(){
        super("Ground", 0, 0, MushroomBattleView.F_WIDTH, (int) MushroomBattleView.F_HEIGHT / 4);
    }

    @Override
    public void update() {
        // Ground doesn't need any update
    }

}
