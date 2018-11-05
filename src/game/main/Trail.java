package game.main;

import java.awt.*;

public class Trail extends GameObject {

    private  float alpha =1;
    private Color color;
    private int width, height;
    private float trailDuration;

    public Trail(int x, int y, ID id, Handler handler, Color color, int width, int height, float trailDuration) {
        super(x, y, id, handler);
        this.color = color;
        this.handler = handler;
        this.width = width;
        this.height = height;
        this.trailDuration = trailDuration;
    }

    @Override
    public void tick() {
        if (alpha > trailDuration) {
            alpha -= trailDuration;
        }else handler.removeObject(this);
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTransparent(alpha));

        g.setColor(color);
        g.fillRect(x,y, width, height);

        g2d.setComposite(makeTransparent(1));
    }

    private AlphaComposite makeTransparent(float alpha){
        int type = AlphaComposite.SRC_OVER;
        return (AlphaComposite.getInstance(type,alpha));

    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
