import java.util.ArrayList;


public class World{

    private ArrayList<CollisionHandler> collisionHandlers;
    private Physic physic;
    private Mushroom m1, m2;
    private Knife kf1, kf2;

    public World(Physic physic, ArrayList<CollisionHandler> collisionHandlers, 
                 Mushroom m1, Mushroom m2, Knife kf1, Knife kf2){
        this.physic = physic;
        this.collisionHandlers = collisionHandlers;
        this.m1 = m1;
        this.m2 = m2;
        this.kf1 = kf1;
        this.kf2 = kf2;
    }
}