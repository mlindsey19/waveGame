package game.main;

import java.awt.*;

public class HUD {

    public static int health = 100;

    public void tick(){
        health--;

        health = Game.boundCheck(health, 0,100);
    }

    public void render(Graphics g){


        g.setColor(Color.gray);
        g.fillRect(15,15, 200, 32);
        g.setColor(Color.GREEN);
        g.fillRect(15,15, ( health * 2 ), 32);
        g.setColor(Color.white);
        g.drawRect(15,15,200,32);

    }

}
