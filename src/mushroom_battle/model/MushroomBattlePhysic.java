package mushroom_battle.model;

import sdk.model.*;


public class MushroomBattlePhysic extends Physic{

    public MushroomBattlePhysic(int borderX, int borderY){
        super(borderX, borderY);
    }

    @Override
    public void update(Sprite sprite){
        Coordinate coordinate = sprite.getCoordinate();
        if (coordinate.getX() + coordinate.getXSpeed() + sprite.getWidth() >= getBorderX()){
            coordinate.setX(getBorderX() - sprite.getWidth());
            coordinate.setXSpeed( -coordinate.getXSpeed());
        } else if(coordinate.getX() + coordinate.getXSpeed() < 0){
            coordinate.setX(0);
            coordinate.setXSpeed( -coordinate.getXSpeed());
        } else{
            coordinate.setX(coordinate.getX() + coordinate.getXSpeed());
        }
    }
}