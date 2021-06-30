package mushroom_battle.model;

import mushroom_battle.model.sprite.Goomba;

public interface GoombaOwner {
    void setGoomba(Goomba goomba);
    boolean hasGoomba();
    Goomba getGoomba();
    void throwGoomba();
}
