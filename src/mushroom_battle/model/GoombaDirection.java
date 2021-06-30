package mushroom_battle.model;

import java.awt.Point;
import java.util.ArrayList;

public class GoombaDirection {

    public final static int MAX_ANGLE = 180;
    private int angle, radius, readyRadius;
    private int updateSpeed = 1;
    private Point currentDirection, currentReadyDirection;
    private ArrayList<Point> directions, readyDirections;
    
    public GoombaDirection(int radius, int readyRadius, int initAngle, int updateSpeed){
        this.radius = radius;
        this.readyRadius = readyRadius;
        this.updateSpeed = updateSpeed;
        createDirectionTable();
        setDirection(initAngle);
    }

    private void createDirectionTable(){
        directions = new ArrayList<Point>();
        readyDirections = new ArrayList<Point>();
        double cosineTheta, sineTheta;
        for (double theta = 0; theta <= MAX_ANGLE; theta++){
            cosineTheta = Math.cos(Math.toRadians(theta));
            sineTheta = Math.sin(Math.toRadians(theta));
            directions.add(new Point(
                (int) (radius * cosineTheta), (int) - (radius * sineTheta)
            ));
            readyDirections.add(new Point(
                (int) (readyRadius * cosineTheta), (int) -(readyRadius * sineTheta)
            ));
        }
    }

    public void setDirection(int angle){
        this.angle = angle;
        setDirection();
    }

    private void setDirection(){
        this.currentDirection = directions.get(this.angle);
        this.currentReadyDirection = readyDirections.get(this.angle);
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

    public int getReadyX(){
        return currentReadyDirection.x;
    }

    public int getReadyY(){
        return currentReadyDirection.y;
    }

    public void update(){
        if (angle + updateSpeed > MAX_ANGLE || angle + updateSpeed < 0)
            updateSpeed = -updateSpeed;
        angle = angle + updateSpeed;
        setDirection();
    }
}
