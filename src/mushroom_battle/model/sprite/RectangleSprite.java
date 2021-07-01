package mushroom_battle.model.sprite;

import sdk.model.World;
import sdk.model.Sprite;
import sdk.view.Painter;

public abstract class RectangleSprite extends java.awt.Rectangle implements Sprite{

    protected String name;
    protected World world;
    protected Painter painter;
    public boolean visible = true;

    public RectangleSprite(String name, int x, int y, int width, int height){
        super(x, y, width, height);
        this.name = name;
    }
    
    @Override
    public void setWorld(World world){
        this.world = world;
    }

    @Override
    public void setPainter(Painter painter){
        this.painter = painter;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override 
    public World getWorld(){
        return this.world;
    }

    @Override
    public Painter getPainter(){
        return this.painter;
    }

    @Override
    public boolean isVisible() {
        return this.visible;
    }
}
