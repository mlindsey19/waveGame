package game.main;

import java.awt.*;
//4
public abstract class GameObject {

    //5  goto
    protected int x, y;
    protected ID id;
    protected int velocityX, velocityY;

    //7
    //  constructor
    public GameObject(int x, int y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }

    //8
    //goto player class
    public abstract void tick();
    public abstract  void render(Graphics g);

    //10
    //add getters and setters
    //got to handler

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

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public int getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(int velocityX) {
        this.velocityX = velocityX;
    }

    public int getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }
}
