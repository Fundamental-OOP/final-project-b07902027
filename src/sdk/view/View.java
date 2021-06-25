package sdk.view;


public interface View{
    void addPainters(Painter... painters);
    void addPainter(Painter painter);
    Renderable getRenderable();
    public void launch();
    void render();
}