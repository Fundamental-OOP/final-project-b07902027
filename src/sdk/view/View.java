package sdk.view;

import sdk.controller.*;
import sdk.model.*;


public interface View{

    void setGame(Game game);
    Game getGame();
    Renderable getRenderable();
    void launch();

    default void render(World world){
        this.getRenderable().render(world);
    }
}