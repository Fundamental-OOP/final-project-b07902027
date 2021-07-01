package mushroom_battle.model;

public interface Movable {
    void setSpeed(int xSpeed, int ySpeed);
    void setXSpeed(int xSpeed);
    void setYSpeed(int ySpeed);
    int getXSpeed();
    int getYSpeed();
}