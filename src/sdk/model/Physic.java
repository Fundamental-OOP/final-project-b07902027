package sdk.model;

import sdk.view.*;


public abstract class Physic{

    int borderX, borderY;

    public Physic(View view){
        Renderable r = view.getRenderable();
        this.borderX = r.getFrameWidth();
        this.borderY = r.getFrameHeight();
    }

    public int getBorderX(){
        return this.borderX;
    }

    public int getBorderY(){
        return this.borderY;
    }

    public abstract void initCoordinates(Sprite... sprites);
}