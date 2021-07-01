package sdk.model;
import java.util.List;

public interface BatchSpriteInitiator{
    SpriteInitiator[] getSpriteInitiators();
    void init(List<Sprite> sprites);
}