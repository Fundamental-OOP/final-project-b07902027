public abstract class Physic{

    int borderX, borderY;

    public Physic(View view){
        Renderable r = view.getRenderable();
        this.borderX = r.getWidth();
        this.borderY = r.getHeight();
    }

    public int getBorderX(){
        return this.borderX;
    }

    public int getBorderY(){
        return this.borderY;
    }

    abstract void initCoordinates(Sprite... sprites);
}