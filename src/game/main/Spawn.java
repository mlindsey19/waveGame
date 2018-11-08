package game.main;

import java.util.Random;

public class Spawn {
    private Handler handler;
    private HUD hud;
    private Random random = new Random();

    private int scoreCheck = 0;




    public Spawn(Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;

    }

    public void tick(){
        scoreCheck = hud.getScore();

        if ( scoreCheck >= 500 ) {
            scoreCheck = 0;
            hud.setLevel( hud.getLevel() + 1 );

            int randomWidth = random.nextInt(Game.WIDTH - 200) + 200 ;
            int  randomHeight = random.nextInt( Game.HEIGHT - 100) + 100 ;

            if (hud.getLevel() % 2 == 0)
                handler.addObject( new SmartEnemy( randomWidth, randomHeight, ID.Enemy, handler));
            if( ( hud.getLevel() % 3 ) == 0 )
                handler.addObject( new BasicEnemy( randomWidth, randomHeight,ID.Enemy, handler) );
            if ( ( hud.getLevel() % 5 )  == 0 )
                handler.addObject( new FastEnemy( randomWidth, randomHeight, ID.Enemy, handler ) );
        }
    }
}
