package mushroom_battle.view.painter;

import java.awt.Color;

import sdk.view.View;
import mushroom_battle.model.KnifeDirection;
import mushroom_battle.model.sprite.Knife;

public class KnifeMarkPainter extends MushroomBattlePainter{

    private final KnifeDirection direction;
    private final Knife knife;

    public KnifeMarkPainter(View view, Knife knife, Color color, int markSize){
        super(view, knife);
        this.knife = knife;
        this.direction = knife.getDirection();
        resetLocation();
        this.unit.setSize(markSize, markSize);
        this.unit.setBackground(color);
        this.unit.setVisible(true);
    }

    public void paint(){
        if (knife.hasOwner()){
            this.unit.setVisible(true);
            resetLocation();
        } else{
            this.unit.setVisible(false);
        }
    }

    protected void resetLocation(){
        this.unit.setLocation(knife.x + knife.getOwner().width / 2 + direction.getReadyX(), 
                              knife.y + knife.getOwner().height / 2 + direction.getReadyY());
    }

}