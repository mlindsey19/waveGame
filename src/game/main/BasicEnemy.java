package game.main;

import java.awt.*;

public class BasicEnemy extends GameObject {


    public BasicEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id, handler);


        velocityX = 5;
        velocityY = 5;

    }
    @Override
    public Rectangle getBounds(){
        return new Rectangle(x,y,16,16);
    }
    @Override
    public void tick() {
        moveWithinWindow();

        handler.addObject(new Trail(x,y, ID.Trail, handler, Color.red, 16,16, 0.1f));

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x,y, 16,16);

    }
}
