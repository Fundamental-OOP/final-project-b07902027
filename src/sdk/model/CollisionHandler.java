package sdk.model;

import java.util.List;

public interface CollisionHandler{
    void handle(Sprite from, Sprite to);
    void handle(Sprite sprite, List<Sprite> sprites);
}