package sdk.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollisionHandlerCollector {

    private List<CollisionHandler> handlers;
    
    public CollisionHandlerCollector(CollisionHandler... handlers){
        this.handlers = Arrays.asList(handlers);
        Collections.sort(this.handlers);
    }

    public void addHandler(CollisionHandler handler){
        this.handlers.add(handler);
        Collections.sort(this.handlers);
    }

    public void handle(Sprite target, List<Sprite> sprites){
        for (CollisionHandler handler: handlers){
            if (handler.shouldHandle(target))
                handler.handle(target, sprites);
        }
    }
}
