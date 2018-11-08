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



        Player tempObject =(Player) handler.objects.getFirst();

        if (tempObject.getId() == ID.Player){
            //key events for player

            if (key == KeyEvent.VK_UP) {
                tempObject.setVelUp(-5);
            }
            if (key == KeyEvent.VK_DOWN) {
                tempObject.setVelDown(5);
            }
            if (key == KeyEvent.VK_LEFT) {
                tempObject.setVelLeft(-5);
            }
            if (key == KeyEvent.VK_RIGHT) {
                tempObject.setVelRight(5);
            }
        }



        // System.out.println(key);

    }
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();


        Player tempObject = (Player) handler.objects.getFirst();

        if (tempObject.getId() == ID.Player){
            //key events for player

            if (key == KeyEvent.VK_UP){
                tempObject.setVelUp(0);
            }
            if (key == KeyEvent.VK_DOWN) {
                tempObject.setVelDown(0);
            }
            if (key == KeyEvent.VK_LEFT) {
                tempObject.setVelLeft(0);
            }
            if (key == KeyEvent.VK_RIGHT) {
                tempObject.setVelRight(0);
            }

        }



    }

}
