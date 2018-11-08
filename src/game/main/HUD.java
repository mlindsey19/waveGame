package game.main;

import java.awt.*;

public class HUD {

    public static float health = 100;

    private short   redValue = 0,
            greenValue = 255,
            blueValue = 0;

    private int score = 0;
    private int level = 1;

    public void tick(){

        health = Game.boundCheck(health, 0,100);

        if (health < 35) {
            redValue = 255;
            greenValue = 0;
        }

        score++;

    }

    public void render(Graphics g){


        g.setColor(Color.gray);
        g.fillRect(15,15, 200, 32);
        g.setColor(new Color(redValue, greenValue, blueValue));
        g.fillRect(15,15, (int) (health * 2 ), 32);
        g.setColor(Color.white);
        g.drawRect(15,15,200,32);

        g.drawString("Score: "  + score, 16,64);
        g.drawString("Level: "  + level, 16,80);

    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
