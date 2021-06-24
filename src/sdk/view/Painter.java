package sdk.view;

import sdk.model.Sprite;


public abstract class Painter{

    protected Renderable r;

    public Painter(View view){
        this.r = view.getRenderable();
    }

    public Renderable getRenderable(){
        return this.r;
    }

    abstract public void setSprite(Sprite sprite);
    abstract public Sprite getSprite();
    abstract public void paint(); // paint Sprite on Renderable class
}