public class MushroomWorldPhysic extends Physic{

    public final static double initSpeed = 0.01;

    public MushroomWorldPhysic(View view){
        super(view);
    }

    public void initCoordinates(Sprite... sprites){
        if (sprites.length != 4){
            throw new RuntimeException("Invalid argument number for Physic.initAll !\n");
        }
        sprites[0].getCoordinate().reset(0, 0, 0, 0);
    }
    
}