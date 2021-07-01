package sdk.model;

import sdk.view.*;

public interface Sprite{
    void setWorld(World world);
    void setPainter(Painter painter);
    String getName();
    World getWorld();
    Painter getPainter();
    void update();
    boolean isVisible();
}