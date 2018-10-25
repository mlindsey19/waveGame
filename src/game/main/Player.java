package game.main;

import java.awt.*;
//9
// make empty methods before going to 10
public class Player extends GameObject {

    public Player(int x, int y, ID id) {
        super(x, y, id);

       // velocityX = 5;

    }

    @Override
    public void tick() {
        x += velocityX;
        y += velocityY;
    }

    @Override
    public void render(Graphics g) {
        //18
        //show adding a player object
        //goto Game.game and add handler.addObject
        if (id == ID.Player)
            g.setColor(Color.magenta);
        if(id == ID.Enemy)
            g.setColor(Color.blue);
        g.fillRect(x, y, 44,44);
    }
}
