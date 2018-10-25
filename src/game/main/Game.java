package game.main;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.ImageObserver;

public class Game extends Canvas implements Runnable{

    private static final long serialVersionUID = 852753996046178928L;


    public static final int WIDTH = 640, HEIGHT = WIDTH / 16 * 9;

    private Thread thread;
    private boolean running = false;

    //14
    //create an instance of handler object
    private Handler handler;



    public Game(){
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));

        new Window(WIDTH, HEIGHT, "Let's Build a Game!", this);


        //15

        handler.addObject(new Player(100,100, ID.Player));
        handler.addObject(new Enemy(150,10, ID.Enemy));

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
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
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
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                //System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();

    }

    private void tick(){
        //16
        //loops threw all objects
        handler.tick();
    }

    public void render(){
        //1
        // add to lower FPS
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        //******************

        //2
        //set background color
        g.setColor(Color.CYAN);
        g.fillRect(0,0,WIDTH,HEIGHT);

        //17
        handler.render(g);


        g.dispose();
        bs.show();

    }

    public static void main(String []args){
        new Game();
    }
}
