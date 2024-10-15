package Main.Algorithms;

import java.awt.*;

public class HUD {
    public int score;
    public int MULTIPLIER = 1;

    // Constructor
    public HUD() {
        init();
    }

    public void init() {
        this.score = 0;
        MULTIPLIER = 1;
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("serif", Font.BOLD, 20));
        g.drawString("Score: " + this.score, 20, 20);
        g.drawString("Multiplier: " + MULTIPLIER, 20, 40);
    }

    public int getScore() {return this.score;}

    public void addScore() {this.score += 1*MULTIPLIER;}
    public void addScore(int x) {this.score += x*MULTIPLIER;}
}
