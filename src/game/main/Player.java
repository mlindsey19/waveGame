package game.main;

import java.awt.*;
//9
// make empty methods before going to 10
public class Player extends GameObject {

    public float getVelLeft() {
        return velLeft;
    }

    public void setVelLeft(float velLeft) {
        this.velLeft = velLeft;
    }

    public float getVelRight() {
        return velRight;
    }

    public void setVelRight(float velRight) {
        this.velRight = velRight;
    }

    public float getVelUp() {
        return velUp;
    }

    public void setVelUp(float velUp) {
        this.velUp = velUp;
    }

    public float getVelDown() {
        return velDown;
    }

    public void setVelDown(float velDown) {
        this.velDown = velDown;
    }

    private float velLeft, velRight, velUp, velDown;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id, handler);


    }
    @Override
    public Rectangle getBounds(){
        return new Rectangle( (int) x, (int) y,44,44);
    }



    @Override
    public void tick() {
        velocityX = velLeft + velRight;
        velocityY = velDown + velUp;
        x += velocityX;
        y += velocityY;



        //bound this player from
        x = Game.boundCheck(x, 0, Game.WIDTH-44);
        y = Game.boundCheck(y, 0, Game.HEIGHT-66);

        collision();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);

        g.fillRect( (int) x, (int) y, 44,44);
    }

    private void collision(){
        for (int i = 0; i < handler.objects.size(); i++){
            GameObject tempObject = handler.objects.get(i);

            if (tempObject.getId() == ID.Enemy){
                if(this.getBounds().intersects(tempObject.getBounds()))
                    HUD.health -= 2;
            }
        }
    }




}

