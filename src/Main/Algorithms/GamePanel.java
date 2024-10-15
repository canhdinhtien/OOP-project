package Main.Algorithms;

import Manager.Constants;
import Main.IntroMenu;
import Main.UI.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable, KeyListener {
    private boolean running;
    private BufferedImage image;
    private Graphics2D g;
    private MouseListener mouseListener;
    private Scoreboard scoreboard;
    private String name;
    private JTextField t;
    private JFrame f;
    private boolean scoreTyped;
    Image backgroundImage;
    public static Sound s;
    private int mouseX;
    public static int a;
    private int c;
    public static int d;
    public static boolean getBackTOMenu;
    private int type;
    public static int WIDTH = 910, HEIGHT = 610;

    private Paddle paddle;
    private Map map;
    private Main.Algorithms.HUD HUD;
    public static ArrayList<PowerUps> powerUps;
    public static ArrayList<Ball> ballList;
    static private int count, count1, count2;

    public GamePanel(int type) throws InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        this.type = type;
        if (Constants.sound) {
            try {
                s = new Sound();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        init();
    }

    public void init() throws InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException {
        getBackTOMenu = false;
        d = 0;
        c = WIDTH/2 ;
        a = 1;


        mouseX = 0;
        paddle = new Paddle();
        map = new Map(Constants.map, type);
        HUD = new HUD();
        mouseListener = new MouseListener();
        powerUps = new ArrayList<PowerUps>();
        ballList = new ArrayList<Ball>();
        ballList.add(new Ball(WIDTH/2-5, HEIGHT-129));
        scoreboard = new Scoreboard();
        scoreTyped = false;
        backgroundImage = new ImageIcon(map.getBackground()).getImage();

        addMouseMotionListener(mouseListener);
        Thread.sleep(2000);
        if (Constants.sound == true) {
            s.play();
        }
        running = true;
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        g = (Graphics2D) image.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        count = 1;
        count1 = 1;
        count2 = 0;
    }

    public void actionPerformed(ActionEvent e) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        String s = this.t.getText();
        this.name = s;
        f.setVisible(false);

        try {
            init();
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }

    @Override
    public void run() {

        while (running) {
            try {
                update();
                draw();
                repaint();
                Thread.sleep(10);
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            try {
                draw();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            repaint();

            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void checkCollisions() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        Rectangle paddleRect = paddle.getRect();
        int[][] mapArray = map.getMapArray();

        for (int i = 0; i < powerUps.size(); i++) {
            Rectangle pRect = powerUps.get(i).getRect();

            if (paddleRect.intersects(pRect)) {
                if (powerUps.get(i).getType() == PowerUps.WIDEN && !powerUps.get(i).getUsed()) {
                    paddle.setWidth(paddle.getWidth()*2);
                    powerUps.get(i).setUsed(true);
                } else if (powerUps.get(i).getType() == PowerUps.ENLARGE && !powerUps.get(i).getUsed()) {
                    for (int j = 0; j < ballList.size(); j++) {
                        ballList.get(j).setSize(ballList.get(j).getSize()*2);
                    }
                    powerUps.get(i).setUsed(true);
                } else if (powerUps.get(i).getType() == PowerUps.MULTIPLIER && !powerUps.get(i).getUsed()) {
                    HUD.MULTIPLIER++;
                    powerUps.get(i).setUsed(true);
                } else if (powerUps.get(i).getType() == PowerUps.SPLIT && !powerUps.get(i).getUsed() && Ball.countBall>0) {
                    ballList.add(new Ball());
                    ballList.add(new Ball());
                    powerUps.get(i).setUsed(true);
                }
            }
        }

        for (int i = 0; i < ballList.size(); i++) {
            Rectangle ballRect = ballList.get(i).getRect();

            if (ballRect.intersects(paddleRect)) {
                ballList.get(i).setDY(-ballList.get(i).getDY());
                if(ballList.get(i).getX() < mouseX + paddle.getWidth()/4) {
                    ballList.get(i).setDX(ballList.get(i).getDX());
                }
                if(ballList.get(i).getX() < mouseX + paddle.getWidth() && ballList.get(i).getX() > mouseX + paddle.getWidth()/4) {
                    ballList.get(i).setDX(ballList.get(i).getDX());
                }
                ballList.get(i).sound();
            }
        }

        A: for (int row = 0; row < mapArray.length; row++) {
            for (int col = 0; col < mapArray[0].length; col++) {
                if (mapArray[row][col] > 0) {

                    int brickx = col*map.getBrickWidth() + map.HOR_PAD;
                    int bricky = row*map.getBrickHeight() + map.VERT_PAD;
                    int width = map.getBrickWidth();
                    int height = map.getBrickHeight();

                    Rectangle brickRect = new Rectangle(brickx, bricky, width, height);

                    for (int i = 0; i < ballList.size(); i++) {
                        Rectangle ballRect = ballList.get(i).getRect();
                        if (ballRect.intersects(brickRect)) {
                            if (mapArray[row][col] == 12) {
                                if (mapArray[row-1][col-1] > 8) {
                                    try {
                                        powerUps.add(new PowerUps((col-1)*map.getBrickWidth() + map.HOR_PAD+width/2, (row-1)*map.getBrickHeight() + map.VERT_PAD, mapArray[row-1][col-1], 20));
                                    } catch (IOException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                    }
                                }if (mapArray[row-1][col] > 8) {
                                    try {
                                        powerUps.add(new PowerUps((col)*map.getBrickWidth() + map.HOR_PAD+width/2, (row-1)*map.getBrickHeight() + map.VERT_PAD, mapArray[row-1][col], 20));
                                    } catch (IOException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                    }
                                }if (mapArray[row-1][col+1] > 8) {
                                    try {
                                        powerUps.add(new PowerUps((col+1)*map.getBrickWidth() + map.HOR_PAD+width/2, (row-1)*map.getBrickHeight() + map.VERT_PAD, mapArray[row-1][col+1], 20));
                                    } catch (IOException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                    }
                                }if (mapArray[row][col-1] > 8) {
                                    try {
                                        powerUps.add(new PowerUps((col-1)*map.getBrickWidth() + map.HOR_PAD+width/2, (row)*map.getBrickHeight() + map.VERT_PAD, mapArray[row][col-1], 20));
                                    } catch (IOException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                    }
                                }if (mapArray[row][col+1] > 8) {
                                    try {
                                        powerUps.add(new PowerUps((col+1)*map.getBrickWidth() + map.HOR_PAD+width/2, (row)*map.getBrickHeight() + map.VERT_PAD, mapArray[row][col+1], 20));
                                    } catch (IOException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                    }
                                }if (mapArray[row+1][col-1] >8) {
                                    try {
                                        powerUps.add(new PowerUps((col-1)*map.getBrickWidth() + map.HOR_PAD+width/2, (row+1)*map.getBrickHeight() + map.VERT_PAD, mapArray[row+1][col-1], 20));
                                    } catch (IOException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                    }
                                }if (mapArray[row+1][col] > 8) {
                                    try {
                                        powerUps.add(new PowerUps((col)*map.getBrickWidth() + map.HOR_PAD+width/2, (row+1)*map.getBrickHeight() + map.VERT_PAD, mapArray[row+1][col], 20));
                                    } catch (IOException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                    }
                                }if (mapArray[row+1][col+1] > 8) {
                                    try {
                                        powerUps.add(new PowerUps((col+1)*map.getBrickWidth() + map.HOR_PAD+width/2, (row+1)*map.getBrickHeight() + map.VERT_PAD, mapArray[row+1][col+1], 20));
                                    } catch (IOException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                    }
                                }


                                try {
                                    powerUps.add(new PowerUps(brickx-width/2, bricky-height/2, mapArray[row][col], 120));
                                    count2 =0;
                                } catch (IOException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                                map.hitBrick(row, col);
                            }
                            else if(mapArray[row][col] > 8) {
                                try {
                                    powerUps.add(new PowerUps(brickx+width/2, bricky, mapArray[row][col], 20));
                                } catch (IOException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                                map.setBrick(row, col, 0);
                            }
                            if (ballList.get(i).getPowered() == false) {
                                map.hitBrick(row, col);
                                HUD.addScore();
                                boolean a = ballList.get(i).getX() >= brickx- ballList.get(i).getSize()+1 && ballList.get(i).getX() <= brickx-ballList.get(i).getSize()+4;
                                boolean b = ballList.get(i).getX() <= brickx+width-1 && ballList.get(i).getX() >= brickx+width-11 && ballList.get(i).getY() >= bricky-11 && ballList.get(i).getY() <= bricky+height-ballList.get(i).getSize()+11;

                                if (ballList.get(i).getSize() == 15) {
                                    if (a || b) {
                                        ballList.get(i).setDX(-ballList.get(i).getDX());

                                    }
                                    else {
                                        ballList.get(i).setDY(-ballList.get(i).getDY());

                                    }
                                }

                            } else if (ballList.get(i).getPowered() == true) {
                                map.hitBrick(row, col);
                                HUD.addScore();

                                boolean a = ballList.get(i).getX() >= brickx- ballList.get(i).getSize()+1 && ballList.get(i).getX() <= brickx-ballList.get(i).getSize()+4;
                                boolean b = ballList.get(i).getX() <= brickx+width-1 && ballList.get(i).getX() >= brickx+width-11 && ballList.get(i).getY() >= bricky-11 && ballList.get(i).getY() <= bricky+height-ballList.get(i).getSize()+11;

                                if (ballList.get(i).getSize() == 15) {
                                    if (a || b) {
                                        ballList.get(i).setDX(-ballList.get(i).getDX());

                                    }
                                    else {
                                        ballList.get(i).setDY(-ballList.get(i).getDY());

                                    }

                                }
                            }
                            break A;
                        }
                    }


                }
            }
        }
    }

    private void gameOver()
    {
        running = false;
        GameModeSelectionMenu.f.dispose();
        if(getBackTOMenu == true) {try {
            Ball.countBall = -1;
            new MainMenu();

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } }
    }


    public void update() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        // Cập nhật trạng thái của trò chơi, kiểm tra va chạm, v.v.
        // Thêm các thao tác cập nhật và ném ra các ngoại lệ tương ứng nếu cần
        try {
            checkCollisions();
            for (Ball ball : ballList) {
                ball.update();
            }
            paddle.update();
            for (PowerUps p : powerUps) {
                if (p.getType() != PowerUps.EXPLODE) {
                    p.update();
                }
            }
            if (getBackTOMenu) {
                gameOver();
            }
        } catch (InterruptedException | UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
            // Xử lý ngoại lệ theo logic của ứng dụng của bạn
        }
        checkCollisions();
        for (Ball ball:ballList) {
            ball.update();

        }

        paddle.update();

        for (PowerUps p: powerUps) {
            if (p.getType() != PowerUps.EXPLODE) {
                p.update();}
        }
        if (getBackTOMenu == true) {
            gameOver();
        }
    }

    public void draw() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.drawImage(backgroundImage, -100, 0, null);

        for (Ball ball:ballList) {
            ball.draw(g);

        }
        paddle.draw(g);
        map.draw(g, this);
        HUD.draw(g);
        drawPower();

        if (map.winCheck() == true) {
            if (Constants.sound == true) {
                s.pause();
            }
            Ball.countBall = -1;
            drawWin();
        }
        if (Ball.countBall == 0) {
            if (Constants.sound == true) {
                s.pause();
            }
            //CollisionSound.close();
            ballList.clear();
            drawLose();
        }
    }

    public void drawPower() {
        for (PowerUps p: powerUps) {
            if (p.getType() == PowerUps.EXPLODE) {
                if (count2<10) {
                    p.draw(g, this);
                    count2++;
                }else {
                    powerUps.remove(p);
                    break;
                }
            }
            else{
                p.draw(g, this );
            }
        }
    }

    public void drawWin() {
        g.setColor(Color.RED);
        g.setFont(new Font("serif", Font.BOLD, 30));
        g.drawString("You Win!", WIDTH/2 -60, 260);
        g.drawString("Press ENTER to Replay" , WIDTH/2 - 160 , 300);
        if (!scoreTyped) {
            saveScore();
        }
    }

    public void drawLose() {
        g.setColor(Color.RED);
        g.setFont(new Font("serif", Font.BOLD, 30));
        g.drawString("You Lose", WIDTH/2 - 60, 370);
        g.drawString("Score: " + HUD.getScore(), WIDTH/2 -60, 400);
        g.drawString("Press ENTER to Replay" , WIDTH/2 - 160 , 425);
        if (!scoreTyped) {
            saveScore();
        }
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(image, 0, 0, WIDTH, HEIGHT, null);
        g2.dispose();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            paddle.mouseMoved((int) paddle.getX()+10);
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            paddle.mouseMoved((int) paddle.getX()-10);

        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (Ball.countBall <= 0) {
                try {
                    try {
                        init();
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE && count > 0) {
            ballList.get(0).set(-4,-Math.sqrt(20));
            count --;
            count1 -- ;
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            if (Constants.sound == true) {
                s.pause();
            }
            for (Ball ball:ballList) {
                ball.stop();

            }
            for (PowerUps p: powerUps) {
                p.stop();
            }
            a = 0;
            d = 1;
            new PauseMenu("Paused game!");
        }
    }

    public void saveScore() {
        this.scoreTyped = true;
        try {
            if(IntroMenu.playerName != null) scoreboard.writeScore(IntroMenu.playerName.getText(), HUD.getScore());
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            scoreboard.readScore();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private class MouseListener implements MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent e) {}

        @Override
        public void mouseMoved(MouseEvent e) {
            mouseX = e.getX();
            paddle.mouseMoved(a*(e.getX()-50)+c*d);
            if (count1 >0)
            {
                ballList.get(0).mouseMoved(e.getX()-20);
            }
        }
    }
    public static class PauseMenu extends JFrame implements ActionListener {

        public PauseMenu(String title) {
            super(title);
            addKeyListener(new PressingKeys());
            setFocusable(true);
            setFocusTraversalKeysEnabled(false);

            //This creates a custom icon for the window using an image
            ImageIcon logoIcon = new ImageIcon(("resources/Image/breakout logo.png"));
            Image logo = logoIcon.getImage();
            setIconImage(logo);

            JPanel panel1 = new JPanel();
            JLabel backToGame = new JLabel("PRESS 'ESC' TO RETURN TO THE GAME");
            panel1.add(backToGame);
            add(panel1, BorderLayout.NORTH);

            JPanel panel2 = new JPanel();
            JButton mainMenuButton = new JButton("MAIN MENU");
            JButton exitButton = new JButton("EXIT");
            mainMenuButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Ball.countBall = -1;
                    dispose();
                    GamePanel.getBackTOMenu = true;


                }
            });
            exitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) { System.exit(0); }
            });
            panel2.add(mainMenuButton);
            panel2.add(exitButton);
            add(panel2, BorderLayout.SOUTH);

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);
            setSize(300, 100);
            setVisible(true);
            setLocationRelativeTo(null);
            repaint();
        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }

        public class PressingKeys extends KeyAdapter
        {
            @Override
            public void keyPressed(KeyEvent e) {
                int action = e.getKeyCode();
                if(action == KeyEvent.VK_ESCAPE) {
                    if (Constants.sound == true) {
                        try {
                            s.resumeAudio();
                        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }
                    for (Ball ball: GamePanel.ballList) {
                        ball.conti();

                    }
                    for (PowerUps p: GamePanel.powerUps) {
                        p.conti();
                    }
                    GamePanel.a = 1;
                    GamePanel.d = 0;
                    dispose();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException, UnsupportedAudioFileException, LineUnavailableException{
        GamePanel gamePanel = new GamePanel(4);
        gamePanel.draw();
        gamePanel.run();
        gamePanel.checkCollisions();
    }
}

