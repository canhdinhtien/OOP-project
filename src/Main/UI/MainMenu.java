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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainMenu {
    public static final int WIDTH = 900;
    public static final int HEIGHT = 700;

    Image img = Toolkit.getDefaultToolkit().getImage("resource/Image/1.jpg");
    Image newImage = img.getScaledInstance(480, 678, Image.SCALE_DEFAULT);

    JFrame frame;
    JPanel bg;
    JPanel buttonHolder;
    JButton playButton, scoreBoardButton, settingsButton, exitButton;
    List<JButton> buttonList;

    ActionListener listener;
    Timer timer;


    public MainMenu() throws InterruptedException {
        //Create a Jframe
        frame = new JFrame("Project OOP");


        //A JPanel of Button holder
        buttonHolder = new JPanel();

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


        //Edit button and add to button holder
        playButton = new JButton("PLAY");
        scoreBoardButton = new JButton("SCOREBOARD");
        settingsButton = new JButton("SETTINGS");
        exitButton = new JButton("EXIT");
        buttonList = new ArrayList<JButton>();

        buttonList.add(playButton);
        buttonList.add(scoreBoardButton);
        buttonList.add(settingsButton);
        buttonList.add(exitButton);

        //Set layout for the button holder -> add button to the panel
        buttonHolder.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(10, 0, 10, 0); // -> adding distance for each button
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.ipady = 30;
        c.fill = GridBagConstraints.BOTH;

        for (int i = 0; i < buttonList.size(); i++) {
            c.gridx = 0;
            c.gridy = i;
            buttonHolder.add(buttonList.get(i), c);
        }

        //set layout the the bg panel then add then button holder into it
        bg.setLayout(new GridBagLayout());
        c.insets = new Insets(250, 150, 120, 150); // adjust the size of button and button holder
        bg.add(buttonHolder, c);


        //Customize the buttons and panel
        for (JButton button: buttonList) {
            button.setOpaque(true);
            button.setBorderPainted(true);
            button.setFont(Manager.Constants.font);
            button.setBackground(new Color(1, 247, 253, 0));
            button.setForeground(new Color(254, 10, 207));
            button.setBorder(new Manager.RoundBtn(15));
            button.setVisible(true);
        }

        buttonHolder.setBackground(new Color(250, 250, 250, 0));
        buttonHolder.setVisible(true);

        //remove default focus
        playButton.setFocusPainted(false);


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


        //ADD FUNCTION TO THE BUTTON
        playButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                frame.dispose();
                try {
                    new GameModeSelectionMenu();
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        scoreBoardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                try {
                    new ScoreMenu();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                try {
                    new Main.UI.SettingGame();
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
    public static void main(String[] args) throws InterruptedException {
        MainMenu mainMenu = new MainMenu();
    }
}