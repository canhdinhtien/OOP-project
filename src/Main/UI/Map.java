package Main.UI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import Main.Algorithms.CollisionSound;
import Main.Algorithms.PowerUps;
import Maps.*;

public class Map {
    CollisionSound s;
    private int[][] map;
    private int brickHeight, brickWidth;
    public Image WIDENIMAGE, ENLARGEIMAGE, MULTIPLIERIMAGE, EXPLODEIMAGE, SPLITIMAGE;

    public final int HOR_PAD = 80, VERT_PAD = 50;

    String backGround;

    public Map(String mode, int type) throws IOException {
        initMap(mode, type);
        WIDENIMAGE = ImageIO.read(new File("resource/Image/widen.png"));
        ENLARGEIMAGE= ImageIO.read(new File("resource/Image/enlarge.png"));
        MULTIPLIERIMAGE = ImageIO.read(new File("resource/Image/multiplier.png"));
        EXPLODEIMAGE = ImageIO.read(new File("resource/Image/explode.png"));
        SPLITIMAGE = ImageIO.read(new File("resource/Image/split.png"));
    }

    public void initMap(String mode, int type) {
        if (mode.equals("Tornado")) {
            Tornado temp = new Tornado();
            map = temp.buildMap(type);
            this.brickHeight = temp.getH() ;
            this.brickWidth = temp.getW() ;
            this.backGround = temp.getBackground();
        } else if (mode.equals("OOP")) {
            OOP temp = new OOP();
            map = temp.buildMap(type);
            this.brickHeight = temp.getH() ;
            this.brickWidth = temp.getW() ;
            this.backGround = temp.getBackground();
        }else if (mode.equals("Diamond")) {
            Diamond temp = new Diamond();
            map = temp.buildMap(type);
            this.brickHeight = temp.getH() ;
            this.brickWidth = temp.getW() ;
            this.backGround = temp.getBackground();
        } else if (mode.equals("Butterfly")) {
            Butterfly temp = new Butterfly();
            map = temp.buildMap(type);
            this.brickHeight = temp.getH() ;
            this.brickWidth = temp.getW() ;
            this.backGround = temp.getBackground();
        }else if (mode.equals("House")) {
            House temp = new House();
            map = temp.buildMap(type);
            this.brickHeight = temp.getH() ;
            this.brickWidth = temp.getW() ;
            this.backGround = temp.getBackground();
        }else if (mode.equals("X")) {
            X temp = new X();
            map = temp.buildMap(type);
            this.brickHeight = temp.getH() ;
            this.brickWidth = temp.getW() ;
            this.backGround = temp.getBackground();
        }else if (mode.equals("Classic")) {
            Classic temp = new Classic();
            map = temp.buildMap(type);
            this.brickHeight = temp.getH() ;
            this.brickWidth = temp.getW() ;
            this.backGround = temp.getBackground();
        }
    }

    public String getBackground() {
        return backGround;
    }

    public void draw(Graphics2D g, Component c) {

        for(int row = 0; row < map.length; row++) {
            for(int col = 0; col < map[0].length; col++) {
                if (map[row][col] > 0) {
                    if (map[row][col] <9) {
                        if (map[row][col] == 1) {
                            g.setColor(new Color(200, 200, 200));
                        }
                        if (map[row][col] == 2) {
                            g.setColor(new Color(125, 125, 125));
                        }
                        if (map[row][col] == 3) {
                            g.setColor(new Color(50,50,50));
                        }
                        if (map[row][col] == 4) {
                            g.setColor(new Color(50,50,125));
                        }
                        if (map[row][col] == 5) {
                            g.setColor(new Color(255, 60, 60));
                        }
                        if (map[row][col] == 6) {
                            g.setColor(new Color(20, 255, 20));
                        }
                        if (map[row][col] == 7) {
                            g.setColor(new Color(255, 255, 0));
                        }
                        if (map[row][col] == 8) {
                            g.setColor(new Color(230, 230, 250));
                        }
                        g.fillRect(col*this.brickWidth + this.HOR_PAD, row*this.brickHeight + this.VERT_PAD, this.brickWidth, this.brickHeight);
                        g.setStroke(new BasicStroke(2));
                        g.setColor(Color.WHITE);
                        g.drawRect(col*this.brickWidth + this.HOR_PAD, row*this.brickHeight + this.VERT_PAD, this.brickWidth, this.brickHeight);
                    }else {


                        if (map[row][col] == 9) {
                            g.drawImage(WIDENIMAGE, col*brickWidth + HOR_PAD, row*brickHeight + VERT_PAD, brickWidth , brickHeight, c);
                        }if (map[row][col] == 10) {
                            g.drawImage(ENLARGEIMAGE, col*brickWidth + HOR_PAD, row*brickHeight + VERT_PAD, brickWidth , brickHeight, c);
                        }if (map[row][col] == 11) {
                            g.drawImage(MULTIPLIERIMAGE, col*brickWidth + HOR_PAD, row*brickHeight + VERT_PAD, brickWidth , brickHeight, c);
                        }if (map[row][col] == 12) {
                            g.drawImage(EXPLODEIMAGE, col*brickWidth + HOR_PAD, row*brickHeight + VERT_PAD, brickWidth , brickHeight, c);
                        }if (map[row][col] == 13) {
                            g.drawImage(SPLITIMAGE, col*brickWidth + HOR_PAD, row*brickHeight + VERT_PAD, brickWidth , brickHeight, c);
                        }
                    }

                }
            }
        }
    }

    public int getBrickWidth() {return brickWidth;}
    public int getBrickHeight() {return brickHeight;}

    public int[][] getMapArray() {return map;}

    public void setBrick(int row, int col, int value) {
        map[row][col] = value;
    }

    public void hitBrick(int row, int col) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        if (Ball.countBall > 0) {
            sound(map[row][col]);
        }
        map[row][col] -= 1;
        if (map[row][col] == 11) {
            map[row-1][col-1] = 0;
            map[row-1][col] = 0;
            map[row-1][col+1] = 0;
            map[row][col-1] = 0;
            map[row][col] = 0;
            map[row][col+1] = 0;
            map[row+1][col-1] = 0;
            map[row+1][col] = 0;
            map[row+1][col+1] = 0;
        } else if (map[row][col] < 0) {
            map[row][col] = 0;
        }else if ( map[row][col] <8 && map[row][col] >2) {
            map[row][col] = 0;
        }
    }
    public void sound(int t) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        s = new CollisionSound(t);
        s.start();
    }


    public boolean winCheck() {
        boolean win = false;
        int HP = 0;
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {
                HP += map[row][col];
            }
        }
        if (HP == 0) {win = true;}

        return win;
    }
}
