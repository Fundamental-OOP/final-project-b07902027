package sdk.view;

import sdk.model.Sprite;


public abstract class Painter{

    protected final Renderable r;
    protected final Sprite sprite;

    public Painter(View view, Sprite sprite){
        this.r = view.getRenderable();
        this.sprite = sprite;
        sprite.setPainter(this);
    }

    public Renderable getRenderable(){
        return this.r;
    }

    public Sprite getSprite(){
        return this.sprite;
    }

    abstract public void paint(); // paint Sprite on Renderable class
}