package Main.UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;

import Manager.Constants;

public class SettingGame extends JFrame implements ActionListener{

    public static final int WIDTH = 480;
    public static final int HEIGHT = 700;
    public static boolean music = false;

    Image img = Toolkit.getDefaultToolkit().getImage("resource/Image/computer3.png");
    Image newImage = img.getScaledInstance(480, 678, Image.SCALE_DEFAULT);

    JFrame frame;
    JPanel bg;

    JPanel containerPanel;


    //SETTING
    //JPanel container for each button group
    JPanel paddleColorPanel = new JPanel();
    JPanel ballColorPanel = new JPanel();
    JPanel musicSettingPanel = new JPanel();
    JPanel difficultyPanel = new JPanel();
    JPanel infoButtonPanel = new JPanel();

    //PADDLE
    JLabel paddleColorLabel = new JLabel("PADDLE COLOR");
    JRadioButton yellowPaddleButton = new JRadioButton("yellow");
    JRadioButton bluePaddleButton = new JRadioButton("blue");
    JRadioButton blackPaddleButton = new JRadioButton("black");
    ButtonGroup paddleButtonGroup = new ButtonGroup();

    //BALL
    JLabel ballColorLabel = new JLabel("BALL COLOR");
    JRadioButton yellowBallButton = new JRadioButton("yellow");
    JRadioButton blueBallButton = new JRadioButton("blue");
    JRadioButton blackBallButton = new JRadioButton("black");
    ButtonGroup ballButtonGroup = new ButtonGroup();

    //MUSIC
    JLabel musicSettingLabel = new JLabel("MUSIC" );
    JRadioButton onMusicButton = new JRadioButton("on");
    JRadioButton offMusicButton = new JRadioButton("off");
    ButtonGroup musicSettingGroup = new ButtonGroup();

    //DIFICU
    JLabel difficultyLabel = new JLabel("MAPS");
    JRadioButton Butterfly = new JRadioButton("Butterfly");
    JRadioButton Diamond = new JRadioButton("Diamond");
    JRadioButton House = new JRadioButton("House");
    JRadioButton OOP = new JRadioButton("OOP");
    JRadioButton Tornado = new JRadioButton("Tornado");
    JRadioButton X = new JRadioButton("X-map");
    ButtonGroup difficultyGroup = new ButtonGroup();

    //INFO BUTTON
    JButton saveButton = new JButton("Save");
    JButton menuButton = new JButton("Back");

    ActionListener listener;
    Timer timer;

    public SettingGame() throws InterruptedException {
        //public static void main(String[] args) throws InterruptedException {
        //Create a Jframe
        frame = new JFrame("OOP Project");

        //A JPanel of Panel holder
        containerPanel = new JPanel();

        //JPanel background
        bg = new JPanel() {
            @Override
            public void setPreferredSize(Dimension d) {
                // TODO Auto-generated method stub
                d = new Dimension(480, 678);
                super.setPreferredSize(d);
            }
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(newImage, 0, 0, null);
            }
        };

        //Set bg size
        bg.setPreferredSize(new Dimension(489, 678));

        //Add JPanel to JFrame, pack and set visible
        frame.add(bg);
        frame.setVisible(true);

        //ADD ELEMENT TO PANEL
        //COLOR
        paddleButtonGroup.add(yellowPaddleButton);
        paddleButtonGroup.add(bluePaddleButton);
        paddleButtonGroup.add(blackPaddleButton);

        //BALL
        ballButtonGroup.add(yellowBallButton);
        ballButtonGroup.add(blueBallButton);
        ballButtonGroup.add(blackBallButton);

        //MUSIC
        musicSettingGroup.add(onMusicButton);
        musicSettingGroup.add(offMusicButton);

        //DIFICU
        difficultyGroup.add(Butterfly);
        difficultyGroup.add(Diamond);
        difficultyGroup.add(House);
        difficultyGroup.add(OOP);
        difficultyGroup.add(Tornado);
        difficultyGroup.add(X);

        //INFO BUTTON
        infoButtonPanel.add(saveButton);
        infoButtonPanel.add(menuButton);

        //Create array for different type
        List<JLabel> labelList = new ArrayList<JLabel>(Arrays.asList(ballColorLabel, paddleColorLabel, musicSettingLabel, difficultyLabel));
        List<JRadioButton> buttonList = new ArrayList<JRadioButton>(Arrays.asList(Butterfly, Diamond, House, OOP, Tornado, X, onMusicButton, offMusicButton, blueBallButton, blackBallButton, yellowBallButton, bluePaddleButton, blackPaddleButton, yellowPaddleButton));
        List<JButton> infoButtonList = new ArrayList<JButton>(Arrays.asList(menuButton, saveButton));
        List<JPanel> panelList = new ArrayList<JPanel>();

        //Edit button and add to button holder
        panelList.add(paddleColorPanel);
        panelList.add(ballColorPanel);
        panelList.add(musicSettingPanel);
        panelList.add(difficultyPanel);
        panelList.add(infoButtonPanel);

        //Set layout for the button holder -> add button to the panel
        containerPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(0, 0, 0, 0); // -> adding distance for each panel
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.ipady = 20;
        c.fill = GridBagConstraints.BOTH;

        for (int i = 0; i < panelList.size()-1; i++) {
            c.gridx = 0;
            c.gridy = i;
            containerPanel.add(panelList.get(i), c);
        }
        c.insets = new Insets(30, 0, 0, 0); // -> adding distance for each panel
        c.gridy = panelList.size() - 1;
        containerPanel.add(panelList.get(panelList.size() - 1), c);


        //set layout the the bg panel then add then button holder into it
        bg.setLayout(new GridBagLayout());
        c.insets = new Insets(120, 50, 50, 50); // adjust the size of button and button holder
        bg.add(containerPanel, c);
        containerPanel.setOpaque(true);
        containerPanel.setBackground(new Color(254, 10, 207, 0));


        //SET LAYOUT FOR EACH INNER PANEL AND ADD ELEMENTS AND COLOR
        for (JPanel panel: panelList) {
            panel.setLayout(new GridBagLayout());
            panel.setBackground(new Color(250, 250, 250, 0));
            panel.setVisible(true);
        }

        for (JRadioButton button: buttonList) {
            button.setBackground(new Color(1, 247, 253, 0));
            button.setForeground(new Color(1, 247, 253));
            button.setFont(Manager.Constants.textFont);
        }

        for (JLabel label: labelList) {
            label.setForeground(new Color(250, 0, 250));
            label.setFont(Manager.Constants.titleFont);
        }

        for (JButton button: infoButtonList) {
            button.setOpaque(true);
            button.setBorderPainted(true);
            button.setFont(Manager.Constants.titleFont);
            button.setBackground(new Color(1, 247, 253));
            button.setForeground(new Color(254, 10, 207));
            button.setBorder(new Manager.RoundBtn(15));
            button.setVisible(true);
        }

        //Create new constraints
        GridBagConstraints innerPannel_c = new GridBagConstraints();

        //PADDLE
        innerPannel_c.insets = new Insets(10, 0, 10, 0); // -> adding distance for each button
        innerPannel_c.weightx = 1;
        innerPannel_c.weighty = 1;
        innerPannel_c.ipadx = 0;
        innerPannel_c.ipady = 0;
        innerPannel_c.fill = GridBagConstraints.BOTH;

        innerPannel_c.gridx = 1;
        innerPannel_c.gridy = 0;
        paddleColorLabel.setHorizontalAlignment(JLabel.CENTER);
        paddleColorPanel.add(paddleColorLabel, innerPannel_c);

        innerPannel_c.gridx = 0;
        innerPannel_c.gridy = 1;
        blackPaddleButton.setHorizontalAlignment(JRadioButton.CENTER);
        paddleColorPanel.add(blackPaddleButton, innerPannel_c);
        innerPannel_c.gridx = 1;
        innerPannel_c.gridy = 1;
        bluePaddleButton.setHorizontalAlignment(JRadioButton.CENTER);
        paddleColorPanel.add(bluePaddleButton, innerPannel_c);
        innerPannel_c.gridx = 2;
        innerPannel_c.gridy = 1;
        yellowPaddleButton.setHorizontalAlignment(JRadioButton.CENTER);
        paddleColorPanel.add(yellowPaddleButton, innerPannel_c);

        //BALL
        innerPannel_c.gridx = 1;
        innerPannel_c.gridy = 0;
        ballColorLabel.setHorizontalAlignment(JLabel.CENTER);
        ballColorPanel.add(ballColorLabel, innerPannel_c);

        innerPannel_c.gridx = 0;
        innerPannel_c.gridy = 1;
        blackBallButton.setHorizontalAlignment(JRadioButton.CENTER);
        ballColorPanel.add(blackBallButton, innerPannel_c);
        innerPannel_c.gridx = 1;
        innerPannel_c.gridy = 1;
        blueBallButton.setHorizontalAlignment(JRadioButton.CENTER);
        ballColorPanel.add(blueBallButton, innerPannel_c);
        innerPannel_c.gridx = 2;
        innerPannel_c.gridy = 1;
        yellowBallButton.setHorizontalAlignment(JRadioButton.CENTER);
        ballColorPanel.add(yellowBallButton, innerPannel_c);

        //SETTING SOUND
        innerPannel_c.gridx = 0;
        innerPannel_c.gridy = 0;
        innerPannel_c.gridwidth = 2;
        musicSettingLabel.setHorizontalAlignment(JLabel.CENTER);
        musicSettingPanel.add(musicSettingLabel, innerPannel_c);

        innerPannel_c.gridx = 0;
        innerPannel_c.gridy = 1;
        innerPannel_c.gridwidth = 1;
        onMusicButton.setHorizontalAlignment(JRadioButton.CENTER);
        musicSettingPanel.add(onMusicButton, innerPannel_c);
        innerPannel_c.gridx = 1;
        innerPannel_c.gridy = 1;
        offMusicButton.setHorizontalAlignment(JRadioButton.CENTER);
        musicSettingPanel.add(offMusicButton, innerPannel_c);

        //DIFICU
        innerPannel_c.gridx = 1;
        innerPannel_c.gridy = 0;
        difficultyLabel.setHorizontalAlignment(JLabel.CENTER);
        difficultyPanel.add(difficultyLabel, innerPannel_c);

        innerPannel_c.gridx = 0;
        innerPannel_c.gridy = 1;
        Butterfly.setHorizontalAlignment(JRadioButton.CENTER);
        difficultyPanel.add(Butterfly, innerPannel_c);
        innerPannel_c.gridx = 1;
        innerPannel_c.gridy = 1;
        Diamond.setHorizontalAlignment(JRadioButton.CENTER);
        difficultyPanel.add(Diamond, innerPannel_c);
        innerPannel_c.gridx = 2;
        innerPannel_c.gridy = 1;
        House.setHorizontalAlignment(JRadioButton.CENTER);
        difficultyPanel.add(House, innerPannel_c);
        innerPannel_c.gridx = 0;
        innerPannel_c.gridy = 2;
        OOP.setHorizontalAlignment(JRadioButton.CENTER);
        difficultyPanel.add(OOP, innerPannel_c);
        innerPannel_c.gridx = 1;
        innerPannel_c.gridy = 2;
        Tornado.setHorizontalAlignment(JRadioButton.CENTER);
        difficultyPanel.add(Tornado, innerPannel_c);
        innerPannel_c.gridx = 2;
        innerPannel_c.gridy = 2;
        X.setHorizontalAlignment(JRadioButton.CENTER);
        difficultyPanel.add(X, innerPannel_c);

        //Info Button
        innerPannel_c.insets = new Insets(0, 10, 0, 10);
        innerPannel_c.fill = GridBagConstraints.NONE;
        innerPannel_c.gridx = 0;
        innerPannel_c.gridy = 0;

        saveButton.setPreferredSize(new Dimension(120, 80));
        menuButton.setPreferredSize(new Dimension(120, 80));

        saveButton.setHorizontalAlignment(JRadioButton.CENTER);
        infoButtonPanel.add(saveButton, innerPannel_c);
        innerPannel_c.gridx = 1;
        innerPannel_c.gridy = 0;
        menuButton.setHorizontalAlignment(JRadioButton.CENTER);
        infoButtonPanel.add(menuButton, innerPannel_c);


        //Edit container panel
        containerPanel.setBackground(new Color(250, 250, 250, 0));
        containerPanel.setVisible(true);


        //menuFrame.add(bg);
        frame.pack();
        frame.setVisible(true);

        //Other function
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        //NOT ALLOW USER RESIZE
        frame.setResizable(false);
        frame.setTitle("THUNDER BRICK BREAKER PRO MAX ULTRA VIP");
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //Validate and repaint if needed
        frame.revalidate();
        frame.validate();
        frame.repaint();

        // Fix the bug of not showing bg
        listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setSize(480, 700);
                frame.validate();
                frame.repaint();
                //timer.stop();
            }
        };
        timer = new Timer(10, listener);
        timer.start();


        //ADD FUNCTION TO
        yellowPaddleButton.setActionCommand("Paddle Yellow");
        bluePaddleButton.setActionCommand("Paddle Blue");
        blackPaddleButton.setActionCommand("Paddle Black");

        blackBallButton.setActionCommand("Ball Black");
        yellowBallButton.setActionCommand("Ball Yellow");
        blueBallButton.setActionCommand("Ball Blue");

        onMusicButton.setActionCommand("ON");
        offMusicButton.setActionCommand("OFF");

        Butterfly.setActionCommand("Butterfly");
        House.setActionCommand("House");
        Diamond.setActionCommand("Diamond");
        OOP.setActionCommand("OOP");
        Tornado.setActionCommand("Tornado");
        X.setActionCommand("X");



        //difficulty settings


        //button to save data
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Save")) {
                    if(paddleButtonGroup.getSelection() != null) {
                        //set the customized color of the paddle
                        if (paddleButtonGroup.getSelection().getActionCommand().equals("Paddle Yellow")) {
                            Constants.PADDLE_COLOR = Color.yellow;
                        } else if (paddleButtonGroup.getSelection().getActionCommand().equals("Paddle Blue")) {
                            Constants.PADDLE_COLOR = Color.blue;
                        } else if (paddleButtonGroup.getSelection().getActionCommand().equals("Paddle Black")) {
                            Constants.PADDLE_COLOR = Color.black;
                        }
                    }
                    if(ballButtonGroup.getSelection() != null) {
                        //set the customized color of the ball
                        if (ballButtonGroup.getSelection().getActionCommand().equals("Ball Black")) {
                            Constants.BALL_COLOR = Color.BLACK;
                        } else if (ballButtonGroup.getSelection().getActionCommand().equals("Ball Yellow")) {
                            Constants.BALL_COLOR = Color.yellow;
                        } else if (ballButtonGroup.getSelection().getActionCommand().equals("Ball Blue")) {
                            Constants.BALL_COLOR = Color.blue;
                        }
                    }

                    //set the music
                    if(musicSettingGroup.getSelection() != null) {
                        if (musicSettingGroup.getSelection().getActionCommand().equals("ON")) {
                            Constants.sound = true;
                        } else if (musicSettingGroup.getSelection().getActionCommand().equals("OFF")) {
                            Constants.sound = false;
                        }
                    }

                    //customize map
                    //set the customized color of the ball
                    if (difficultyGroup.getSelection().getActionCommand().equals("Butterfly")) {
                        Constants.map = "Butterfly";
                    } else if (difficultyGroup.getSelection().getActionCommand().equals("Diamond")) {
                        Constants.map = "Diamond";
                    } else if (difficultyGroup.getSelection().getActionCommand().equals("House")) {
                        Constants.map = "House";
                    } else if (difficultyGroup.getSelection().getActionCommand().equals("OOP")) {
                        Constants.map = "OOP";
                    } else if (difficultyGroup.getSelection().getActionCommand().equals("Tornado")) {
                        Constants.map = "Tornado";
                    } else if (difficultyGroup.getSelection().getActionCommand().equals("X")) {
                        Constants.map = "X";
                    }


                    frame.dispose();
                    try {
                        new MainMenu();
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

                }
            }
        });


        //Main menu at the bottom
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                try {
                    new MainMenu();
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}