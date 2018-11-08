package game.main;

import java.awt.*;

public abstract class GameObject {


    protected float x, y;
    protected ID id;
    protected float velocityX, velocityY;
    protected Handler handler;


    public GameObject(int x, int y, ID id, Handler handler){
        this.x = x;
        this.y = y;
        this.id = id;
        this.handler = handler;
    }


    public abstract void tick();
    public abstract  void render(Graphics g);
    public abstract Rectangle getBounds();

    public void moveWithinWindow(){
        x += velocityX;
        y += velocityY;

        //set bounds and reverse direction at bound
        if(y <= 0 || y >= Game.HEIGHT - 48) velocityY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 32) velocityX *= -1;
    }



    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public float getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(float velocityX) {
        this.velocityX = velocityX;
    }

    public float getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(float velocityY) {
        this.velocityY = velocityY;
    }
}
