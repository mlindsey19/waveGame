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

        //bound this player from
        x = Game.boundCheck(x, 0, Game.WIDTH-44);
        y = Game.boundCheck(y, 0, Game.HEIGHT-66);
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
