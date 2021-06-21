public class MushroomWorldPainter implements Painter{

    private Sprite sprite;
    String imagePath;

    public MushroomWorldPainter(String imagePath){
        this.imagePath = imagePath;
    }

    @Override
    public void setSprite(Sprite sprite){
        this.sprite = sprite;
    }

    @Override
    public Sprite getSprite(){
        return this.sprite;
    }

    @Override
    public void paint(Renderable r){

    }
}