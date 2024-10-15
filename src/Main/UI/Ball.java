package Main.UI;

import Main.Algorithms.CollisionSound;
import Main.Algorithms.GamePanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import Manager.Constants;

public class Ball {
    public double x, y, dx, dy;
    private int ballSize = 15;
    private boolean powered;
    private long powerTimer;
    public static int countBall = 0;
    private int count = 1;
    CollisionSound s;
    public final static int startSize = 15;
    public double dxi, dyi;

    public Ball() {
        this.x = (int) (Math.random()*(GamePanel.WIDTH - 30));
        this.y = 20;

        double a = (Math.random()*2+1);
        double b =  (Math.random()*2+1);

        this.dx = a/(Math.sqrt(a*a+b*b))*6;
        this.dy = b/(Math.sqrt(a*a+b*b))*6;
        if (countBall == -1) {
            countBall = 1;
        }
        else {

            countBall ++;
        }

    }

    public Ball(double x, double y) {
        this.x = x;
        this.y = y;
        this.dx = 0;
        this.dy = 0;
        this.powerTimer = 0;
        this.powered = false;
        if (countBall == -1) {
            countBall =1;
        }
        else {

            countBall ++;
        }
    }

    public Ball(double x, double y, double dx, double dy) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        if (countBall == -1) {
            countBall =1;
        }
        else {

            countBall ++;
        }
    }

    public void mouseMoved(int mouseX) {
        this.x = mouseX;
        if (this.x > GamePanel.WIDTH - startSize) {
            this.x = GamePanel.WIDTH - startSize;
        }
        if (this.x < 0) {
            this.x = 0;
        }
    }

    public void update() {
        setPosition();
        if ((System.nanoTime() - powerTimer) / 1000 > 3000000 && powered == true) {
            this.ballSize = startSize;
            this.powered = false;
        }
    }

    public void setPosition() {
        x += dx;
        y += dy;
        if (x < 0) {
            this.x = 0;
            this.dx = -this.dx;
        }
        if (y < 0) {
            this.dy = -this.dy;
        }
        if (x > GamePanel.WIDTH - (ballSize*2)) {
            this.dx = -this.dx;
            this.x = GamePanel.WIDTH - (ballSize*2);
        }
        if (y > GamePanel.HEIGHT && countBall >0 && count >0) {
            count --;
            countBall -- ;
            this.ballSize = 0;
            //return;
        }
    }



    public void draw(Graphics2D g) {

        if (powered == true) {
            g.setColor(Color.red);
            g.setStroke(new BasicStroke(4));
            g.fillOval((int) x, (int) y, ballSize, ballSize);
            g.setColor(Color.RED);
            g.setFont(new Font("serif", Font.BOLD, 18));
            g.drawString("Ball Shrinking in " + (3 - (System.nanoTime() - powerTimer) / 1000000000), GamePanel.WIDTH-200, 40);
        }else {
            g.setColor(Constants.BALL_COLOR);
            g.setStroke(new BasicStroke(4));
            g.fillOval((int) x, (int) y, ballSize, ballSize);
        }
    }

    public Rectangle getRect() {
        return new Rectangle((int) x,(int) y, ballSize, ballSize);
    }
    public void sound() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        s = new CollisionSound("ball");
        s.start();
    }

    public double getX() {return this.x;}
    public double getY() {return this.y;}
    public void setX(double x) {this.x = x;}
    public void setY(double y) {this.y = y;}

    public double getDY() {return this.dy;}
    public void setDY(double dy) {this.dy = dy;}

    public double getDX() {
        return this.dx;}

    public void stop() {
        this.dxi = dx;
        this.dyi = dy;
        this.dx = 0;
        this.dy = 0;
    }

    public void conti() {
        this.dx = dxi;
        this.dy = dyi;
    }

    public void setDX(double dx) {this.dx = dx;}

    public int getSize() {return this.ballSize;}
    public void setSize(int ballSize) {
        if (powered == false) {
            powered = true;
            this.ballSize = ballSize;
            setTimer();
        }
    }

    public void set(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }
    public void setTimer() {
        this.powerTimer = System.nanoTime();
    }
    public boolean getPowered() {return this.powered;}

}

