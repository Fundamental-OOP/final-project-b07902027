import java.util.ArrayList;


public class Main{
    public static void main(String[] args){
        Knife kf1 = new Knife();
        Knife kf2 = new Knife();
        Mushroom m1 = new Mushroom(kf1);
        Mushroom m2 = new Mushroom(kf2);
        int fps = 60;

        CollisionHandler collisionHandler = new MushroomWorldCollisionHandler();
        View view = new MushroomView();  // view
        Physic physic = new MushroomWorldPhysic(view);
        World world = new MushroomWorld(physic, collisionHandler, m1, m2, kf1, kf2);  // model
        Game game = new MushroomGame(world, view, fps);  // controller
        
        game.start();
    }
}
