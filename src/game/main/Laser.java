package game.main;

import java.awt.*;

public class Laser extends GameObject {


    public Laser(int x, int y, ID id, Handler handler) {
        super(x, y, id, handler);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.cyan);

        g.fillRect( (int) x, (int) y, 11,11);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle( (int) x, (int) y,11,11);
    }
}
