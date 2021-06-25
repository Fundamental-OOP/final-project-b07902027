package sdk.model;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import static java.util.Arrays.stream;


public abstract class World{

    protected final Physic physic;
    protected final List<Sprite> sprites = new CopyOnWriteArrayList<Sprite>();
    protected final CollisionHandler collisionHandler;

    public World(Physic physic, CollisionHandler collisionHandler, Sprite... sprites) {
        this.physic = physic;
        this.collisionHandler = collisionHandler;
        addSprites(sprites);
        this.initSprites(sprites);
    }

    public void addSprites(Sprite... sprites) {
        stream(sprites).forEach(this::addSprite);
    }

    public void addSprite(Sprite sprite) {
        sprites.add(sprite);
        sprite.setWorld(this);
    }

    public Physic getPhysic(){
        return this.physic;
    }

    public void update() {
        for (Sprite sprite : this.sprites) {
            sprite.update();
        }
    }

    public List<Sprite> getSprites(){
        return sprites;
    }

    protected abstract void initSprites(Sprite... sprites);
}