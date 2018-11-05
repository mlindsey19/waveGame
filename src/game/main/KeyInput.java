package game.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;
    private boolean[] keyDown = new boolean[4];

    public KeyInput(Handler handler) {
        this.handler = handler;

        for ( int i = 0; i < keyDown.length; i++ ){
            keyDown[ i ] = false;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);

        int key = e.getKeyCode();


        for (int i = 0; i < handler.objects.size(); i++){
            GameObject tempObject = handler.objects.get(i);

            if (tempObject.getId() == ID.Player){
                //key events for player

                if (key == KeyEvent.VK_UP) {
                    tempObject.setVelocityY(-5);
                    keyDown [ KEYS.UP.asInt() ] = true;
                }
                if (key == KeyEvent.VK_DOWN) {
                    tempObject.setVelocityY(5);
                    keyDown[ KEYS.DOWN.asInt() ] = true;
                }
                if (key == KeyEvent.VK_LEFT) {
                    tempObject.setVelocityX(-5);
                    keyDown[ KEYS.LEFT.asInt() ] = true;
                }
                if (key == KeyEvent.VK_RIGHT) {
                    tempObject.setVelocityX(5);
                    keyDown[ KEYS.RIGHT.asInt() ] = true;
                }
            }
        }


        // System.out.println(key);

    }
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.objects.size(); i++){
            GameObject tempObject = handler.objects.get(i);

            if (tempObject.getId() == ID.Player){
                //key events for player

                if (key == KeyEvent.VK_UP){
                    keyDown[ KEYS.UP.asInt() ] = false;
                }
                if (key == KeyEvent.VK_DOWN) {
                    keyDown[ KEYS.DOWN.asInt() ] = false;
                }
                if (key == KeyEvent.VK_LEFT) {
                    keyDown[ KEYS.LEFT.asInt() ] = false;
                }
                if (key == KeyEvent.VK_RIGHT) {
                    keyDown[ KEYS.RIGHT.asInt() ] = false;
                }

                if(!keyDown[ KEYS.DOWN.asInt() ] && !keyDown[ KEYS.UP.asInt() ])
                    tempObject.setVelocityY(0);
                if(!keyDown[ KEYS.LEFT.asInt() ] && !keyDown[ KEYS.RIGHT.asInt() ])
                    tempObject.setVelocityX(0);

            }
        }


    }

}
