package mushroom_battle.model;

import javax.sql.PooledConnection;

import java.awt.Point;
import java.util.ArrayList;

public class KnifeDirection {

    public final static int UPDATE_SPEED = 1, MAX_ANGLE = 180;
    private int updateCounter = 0;
    private int angle, radius, step = 1;
    private Point currentDirection;
    private ArrayList<Point> directions;
    
    public KnifeDirection(int radius, int initAngle){
        this.radius = radius;
        createDirectionTable();
        setDirection(initAngle);
    }

    private void createDirectionTable(){
        directions = new ArrayList<Point>();
        int x, y;
        for (double theta = 0; theta <= MAX_ANGLE; theta++){
            x = (int) (Math.cos(Math.toRadians(theta)) * radius);
            y = (int) (Math.sin(Math.toRadians(theta)) * radius);
            directions.add(new Point(x, -y));
        }
    }

    public void setDirection(int angle){
        this.angle = angle;
        this.currentDirection= directions.get(angle);
    }

    private void setDirection(){
        this.currentDirection= directions.get(this.angle); 
    }

    public int getAngle(){
        return angle;
    }

    public int getX(){
        return currentDirection.x;
    }

    public int getY(){
        return currentDirection.y;
    }

    public void update(){
        updateCounter += 1;
        if (updateCounter <= UPDATE_SPEED)
            return;
        if (angle + step >= MAX_ANGLE || angle + step < 0)
            step = -step;
        angle = angle + step;
        setDirection();
        updateCounter = 0;
    }
}
