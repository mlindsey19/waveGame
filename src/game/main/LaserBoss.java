package game.main;

import java.awt.*;

public class LaserBoss extends GameObject {


    private int moveToCenter = 80;

    public LaserBoss(int x, int y, ID id, Handler handler) {
        super(x, y, id, handler);
    }

    @Override
    public void tick() {
        if (moveToCenter <= 0){
            moveWithinWindow();
            moveToCenter--;
        }

        moveWithinCenter();

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.cyan);

        g.fillRect( (int) x, (int) y, 66,66);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle( (int) x, (int) y,66,66);
    }

    private void moveWithinCenter(){
        int topCenter, bottomCenter, leftCenter, rightCenter;

        topCenter = ( Game.HEIGHT / 2 ) - 80;
        bottomCenter = ( Game.HEIGHT / 2 ) + 80;
        leftCenter = ( Game.WIDTH / 2 ) - 80;
        rightCenter = ( Game.WIDTH / 2 ) + 80;

        if( y <= bottomCenter || y >= topCenter ) velocityY *= -1;
        if( x <= leftCenter || x >= rightCenter ) velocityX *= -1;
    }

}
