package sdk.model;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import static java.util.Arrays.stream;


public abstract class World{

    protected final Physic physic;
    protected final List<Sprite> sprites = new CopyOnWriteArrayList<Sprite>();
    protected final CollisionHandlerCollector collisionHandlerCollector;

    public World(Physic physic, CollisionHandlerCollector collector, Sprite... sprites) {
        this.physic = physic;
        this.collisionHandlerCollector = collector;
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

    public CollisionHandlerCollector getCollisionHandlerCollector(){
        return this.collisionHandlerCollector;
    }

    public void update() {
        for (Sprite sprite: this.sprites) 
            physic.update(sprite);
        for (Sprite sprite: this.sprites)
            collisionHandlerCollector.handle(sprite, this.sprites);
        for (Sprite sprite: this.sprites)
            sprite.update();
    }

    public List<Sprite> getSprites(){
        return sprites;
    }

    protected abstract void initSprites(Sprite... sprites);
}