import java.util.ArrayList;


public class Main{
    public static void main(String[] args){
        Knife kf1 = new Knife();
        Knife kf2 = new Knife();
        Mushroom m1 = new Mushroom(kf1);
        Mushroom m2 = new Mushroom(kf2);
        int fps = 60;

        World world = new MushroomWorld(new Physic(), new MushroomWorldCollisionHandler(), m1, m2, kf1, kf2);  // model
        View view = new MushroomGameView(new Canvas());  // view
        Game game = new MushroomGame(world, view, fps);  // controller

        game.start();
        view.launch();
    }
}
