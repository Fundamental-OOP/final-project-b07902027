package sdk.view;

import sdk.controller.Game;

import java.util.List;


public interface View{
    void setGame(Game game);
    void addPainters(Painter... painters);
    void addPainter(Painter painter);
    List<Painter> getPainters();
    Renderable getRenderable();
    public void launch();
    default void render(){
        for (Painter painter: getPainters()){
            painter.paint();
        }
    }
}