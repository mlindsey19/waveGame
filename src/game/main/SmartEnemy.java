package game.main;

import java.awt.*;

public class SmartEnemy extends GameObject {

    private GameObject player;


    public SmartEnemy(int x, int y, ID id, Handler handler) {
        super(x,y,id,handler);
        player = handler.objects.getFirst(); //currently player will always be the first object

    }
    @Override
    public Rectangle getBounds(){
        return new Rectangle( (int) x, (int) y,16,16);
    }
    @Override
    public void tick() {
        moveWithinWindow(); //

        double xDistSquared = ( x - player.getX() ) * ( x - player.getX() );
        double yDistSquared = ( y - player.getY() ) * ( y - player.getY() );
        double diffX = x - player.getX() - 8;
        double diffY = y - player.getY() - 8;
        double distance = Math.sqrt( xDistSquared + yDistSquared );

        velocityX = (float) (( -1.0 / distance ) * diffX);
        velocityY = (float) (( -1.0 / distance ) * diffY);

        handler.addObject(new Trail(  (int) x,  (int) y, ID.Trail, handler, Color.green, 16,16, 0.1f));

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect( (int) x, (int) y, 16,16);

    }
}
