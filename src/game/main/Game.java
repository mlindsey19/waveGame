package game.main;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.ImageObserver;

public class Game extends Canvas implements Runnable{

    private static final long serialVersionUID = 852753996046178928L;


    public static final int WIDTH = 640, HEIGHT = WIDTH / 16 * 9;

    private Thread thread;
    private boolean running = false;


    private Handler handler;
    private HUD hud;
    private Spawn spawn;



    public Game(){
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));

        new Window(WIDTH, HEIGHT, "Let's Build a Game!", this);

        hud = new HUD();
        spawn = new Spawn(handler, hud);

        handler.addObject(new Player(100,100, ID.Player, handler));
        handler.addObject(new Enemy(150,10, ID.Enemy, handler));

    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch (Exception error){
            error.printStackTrace();
        }
    }

    public void run(){
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        // int frames = 0; //for printing frames per sec
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running)
                render();
            //  frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                //System.out.println("FPS: " + frames);
                //      frames = 0;
            }
        }
        stop();

    }

    private void tick(){

        handler.tick();
        hud.tick();
    }

    public void render(){

        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        //******************

        g.setColor(Color.CYAN);
        g.fillRect(0,0,WIDTH,HEIGHT);


        handler.render(g);

        hud.render(g);

        g.dispose();
        bs.show();

    }

    public static int boundCheck(int value, int min, int max){
        if (value >= max) return max;
        if (value <= min) return min;
        else return value;
    }


    public static void main(String []args){

        new Game();
    }
}
