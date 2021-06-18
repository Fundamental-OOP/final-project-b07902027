import java.util.ArrayList;


public class Main{
    public static void main(String[] args){
        Knife kf1 = new Knife();
        Knife kf2 = new Knife();
        Mushroom m1 = new Mushroom(kf1);
        Mushroom m2 = new Mushroom(kf2);
        ArrayList<CollisionHandler> collisionHandlers = new ArrayList<CollisionHandler>();
        collisionHandlers.add(new KnifeMushroomCollisionHandler());
        World world = new World(new Physic(), collisionHandlers, m1, m2, kf1, kf2);  // model
        Game game = new Game(world);  // controller
        View view = new View(game);  // view
        game.start();
        view.launch();
    }
}
