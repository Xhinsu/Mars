package org.example.DATA;

import java.util.Arrays;

public class Position {
    private int x;
    private int y;
    private CompassDirection facing; // this type can be whatever your direction enum is called
    private static Position instance;

    public Position(){
    }
    private Position(int x, int y, CompassDirection facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
        }

        public static Position getInstance(){
        if(instance == null){
            instance = new Position();
        } return  instance;
        }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public CompassDirection getFacing() {
        return facing;
    }

    public void setFacing(CompassDirection facing) {
        this.facing = facing;
    }

    @Override
    public String toString() {
        return  String.format("Current position is x:%d y:%d and %s ", this.getX(),this.y,this.getFacing());
    }

}
