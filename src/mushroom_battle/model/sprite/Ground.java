package mushroom_battle.model.sprite;

import sdk.model.Coordinate;
import sdk.model.Sprite;

public class Ground extends Sprite{
    
    public Ground(Coordinate coordinate, int width, int height){
        super("Ground", coordinate, width, height);
    }

    @Override
    public void update() {
    }

}
