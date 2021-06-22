package sdk.controller;

import sdk.view.*;
import sdk.model.*;


public interface Painter{
    void paint(Renderable r);
    void setSprite(Sprite sprite);
    Sprite getSprite();
}