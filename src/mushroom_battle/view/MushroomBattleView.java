package mushroom_battle.view;

import sdk.view.*;


public class MushroomBattleView extends View{

    private final static int MAP_WIDTH = 500;
    private final static int MAP_HEIGHT = 400;
    Canvas canvas;

    public MushroomBattleView(){
        this.canvas = new Canvas();
    }

    public void launch(){

    }

    @Override
    public Renderable getRenderable(){
        return this.canvas;
    }

    public class Canvas implements Renderable{

        public int getWidth(){
            return MAP_WIDTH;
        }

        public int getHeight(){
            return MAP_HEIGHT;
        }

    }

}