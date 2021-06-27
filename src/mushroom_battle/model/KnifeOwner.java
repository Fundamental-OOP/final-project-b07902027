package mushroom_battle.model;

import mushroom_battle.model.sprite.Knife;

public interface KnifeOwner {
    void setKnife(Knife knife);
    boolean hasKnife();
    Knife getKnife();
    void throwKnife();
}
