package mushroom_battle.view;

import java.awt.*;

import javax.swing.JPanel;

import sdk.model.*;
import sdk.view.*;


public class MushroomBattlePainter extends Painter{

    private Sprite sprite;
    String imagePath;

    JPanel canvas, unit;

    public MushroomBattlePainter(View view, String imagePath){
        super(view);
        this.imagePath = imagePath;
        this.unit = createUnit();
        ((JPanel) getRenderable()).add(unit);
    }

    private JPanel createUnit(){
        unit = new JPanel();
        unit.setBackground(Color.BLUE);
        unit.setLocation(0, 0);
        unit.setSize(50,50);
        return unit;
    }

    @Override
    public Sprite getSprite(){
        return this.sprite;
    }

    public void setSprite(Sprite sprite){
        this.sprite = sprite;
    }

    @Override
    public void paint(){

        if (this.sprite == null){
            throw new RuntimeException("Sprite not set in Painter before calling `paint`.");
        }

        // unit.setLocation(0, 0);
    }
}