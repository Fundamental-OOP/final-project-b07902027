package sdk.model;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static java.util.Arrays.stream;


public abstract class World{

    protected final Physic physic;
    protected final CollisionHandlerCollector handlerCollector;
    protected final BatchSpriteInitiator initiator;
    protected final List<Sprite> sprites = new CopyOnWriteArrayList<Sprite>();

    public World(Physic physic, CollisionHandlerCollector collector, BatchSpriteInitiator initiator, Sprite... sprites) {
        this.physic = physic;
        this.handlerCollector = collector;
        this.initiator = initiator;
        addSprites(sprites);
        this.initSprites();
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
        return this.handlerCollector;
    }

    public void update() {
        for (Sprite sprite: this.sprites) 
            physic.update(sprite);
        for (Sprite sprite: this.sprites)
            handlerCollector.handle(sprite, this.sprites);
        for (Sprite sprite: this.sprites)
            sprite.update();
    }

    public List<Sprite> getSprites(){
        return sprites;
    }

    public Sprite getSprite(SpriteIndexConvertable s){
        return sprites.get(s.getIdx());
    }

    public void initSprites(){
        this.initiator.init(sprites);
    }
}