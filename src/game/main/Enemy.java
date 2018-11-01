package game.main;

import java.awt.*;

public class Enemy extends GameObject {

    Handler handler;

    public Enemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        velocityX = 5;
        velocityY = 5;

    }
    @Override
    public Rectangle getBounds(){
        return new Rectangle(x,y,16,16);
    }
    @Override
    public void tick() {
        x += velocityX;
        y += velocityY;

        //set bounds and reverse direction at bound
        if(y <= 0 || y >= Game.HEIGHT - 48) velocityY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 32) velocityX *= -1;

        handler.addObject(new Trail(x,y, ID.Trail, handler, Color.red, 16,16, 0.1f));

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x,y, 16,16);

    }
}
