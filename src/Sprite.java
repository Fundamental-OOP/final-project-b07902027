import java.awt.*;


public abstract class Sprite{

    protected Rectangle location;
    protected double speedX, speedY;
    protected World world;

    public void setWorld(World world){
        this.world = world;
        this.speedX = Physic.initSpeed;
        this.speedY = 0.0;
        this.location = new Rectangle();
    }

    public void update(){

    }

    public void render(Renderable r){

    }
}