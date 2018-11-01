package game.main;

import java.awt.*;
//9
// make empty methods before going to 10
public class Player extends GameObject {

    Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

       // velocityX = 5;

    }
@Override
    public Rectangle getBounds(){
        return new Rectangle(x,y,44,44);
    }



    @Override
    public void tick() {
        x += velocityX;
        y += velocityY;

        //bound this player from
        x = Game.boundCheck(x, 0, Game.WIDTH-44);
        y = Game.boundCheck(y, 0, Game.HEIGHT-66);

        collision();
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

    private void collision(){
        for (int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Enemy){
                if(getBounds().intersects(tempObject.getBounds()))
                    HUD.health -= 2;
            }
        }
    }
}

