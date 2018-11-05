package game.main;

import java.awt.*;

public class SmartEnemy extends GameObject {

    private GameObject player;

    public SmartEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id, handler);

        player = handler.objects.getFirst();

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
