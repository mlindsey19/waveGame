package game.main;

import java.awt.*;

public class FastEnemy extends GameObject {

    public FastEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id, handler);

        velocityX = 5;
        velocityY = 12;
    }

    @Override
    public void tick() {
        moveWithinWindow();

        handler.addObject(new Trail(x,y, ID.Trail, handler, Color.cyan, 16,16, 0.1f));

    }



    @Override
    public void render(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect(x,y, 16,16);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);
    }
}

