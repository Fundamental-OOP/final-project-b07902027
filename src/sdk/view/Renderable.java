package sdk.view;

import sdk.model.World;

public interface Renderable{
    int getFrameHeight();
    int getFrameWidth();
    void render(World world);
}