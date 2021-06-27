package sdk.model;

import java.util.List;

public abstract class CollisionHandler implements Comparable<CollisionHandler>{

    protected int schedulingIndex;

    public CollisionHandler(int idx){
        this.schedulingIndex = idx;
    }

    @Override
    public int compareTo(CollisionHandler other){
        return this.schedulingIndex - other.schedulingIndex;
    }

    abstract public boolean shouldHandle(Sprite target);
    abstract public void handle(Sprite target, List<Sprite> otherSprites);
}