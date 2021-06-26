package sdk.view;

import sdk.controller.Game;


public interface View{
    void setGame(Game game);
    void addPainters(Painter... painters);
    void addPainter(Painter painter);
    Renderable getRenderable();
    public void launch();
    void render();
}