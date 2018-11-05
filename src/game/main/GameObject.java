package game.main;

import java.awt.*;

public abstract class GameObject {


    protected int x, y;
    protected ID id;
    protected int velocityX, velocityY;
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
