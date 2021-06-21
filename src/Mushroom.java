public class Mushroom extends Sprite {

    private Knife knife;

    public Mushroom(Knife knife){
        super(new MushroomWorldPainter("src/mushroom.png"));
        this.knife = knife;
    }
}