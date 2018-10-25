package game.main;

import java.awt.*;

public class Enemy extends GameObject {

    public Enemy(int x, int y, ID id) {
        super(x, y, id);

        velocityX = 5;
        velocityY = 5;

    }

    @Override
    public void tick() {
        x += velocityX;
        y += velocityY;

        //set bounds and reverse direction at bound
        if(y <= 0 || y >= Game.HEIGHT - 48) velocityY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 32) velocityX *= -1;

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x,y, 16,16);

    }
}
