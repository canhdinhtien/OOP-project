package Main.UI;

import Manager.Constants;
import Manager.RoundBtn;
import Main.PressingKeys;
import Main.Algorithms.Scoreboard;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.swing.*;


public class ScoreMenu extends JFrame {

    Image img = Toolkit.getDefaultToolkit().getImage("resource/Image/computer3.jpeg");
    Image newImage = img.getScaledInstance(480, 678, Image.SCALE_DEFAULT);
    //	static JFrame window;
    JPanel bg;
    JPanel scorePanel = new JPanel();
    JLabel nameLabel;
    JLabel scoreLabel;
    ActionListener listener;
    Timer timer;

    JButton exit;

    ArrayList<String> playerNameArr;
    ArrayList<Integer> playerScoreArr;
    GridBagConstraints c;

    public ScoreMenu() throws IOException {
//	public static void main(String[] args) throws IOException {
        JFrame window = new JFrame();
        window.getContentPane().setLayout(new CardLayout(0, 0));

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

        //panel for user input and add into the bg panel
        bg.setLayout(new GridBagLayout());
        c = new GridBagConstraints();

        c.weightx = 1.0;
        c.weighty = 1.0;
        c.ipady = 20;
        c.fill = GridBagConstraints.BOTH;

        Scoreboard score = new Scoreboard();
        LinkedHashMap<String, Integer> playerInfoArr = score.readScore();
        playerNameArr= new ArrayList<String>(playerInfoArr.keySet());
        playerScoreArr = new ArrayList<Integer>(playerInfoArr.values());

        scorePanel.setLayout(new GridBagLayout());
        c.insets = new Insets(10, 40, 10, 0); // -> adding distance for each panel
        for (int i = 0; i < 10 && i < playerScoreArr.size(); i++) {
            c.gridx = 0;
            c.gridy = i;
            nameLabel = new JLabel(playerNameArr.get(i));
            scorePanel.add(nameLabel, c);

            c.gridx = 1;
            scoreLabel = new JLabel(String.valueOf(playerScoreArr.get(i)));
            scorePanel.add(scoreLabel, c);

            nameLabel.setOpaque(true);
            nameLabel.setFont(Constants.font);
            nameLabel.setBackground(new Color(254, 10, 207, 0));
            nameLabel.setForeground(new Color(0, 250, 250));
            nameLabel.setVisible(true);

            scoreLabel.setOpaque(true);
            scoreLabel.setFont(Constants.font);
            scoreLabel.setBackground(new Color(254, 10, 207, 0));
            scoreLabel.setForeground(new Color(254, 10, 207));
            scoreLabel.setVisible(true);
        }

        // ADD SCORE PANEL INTO FRAME AND MAKE TRANSPARENT
        c.insets = new Insets(100, 70, 80 , 20); //-> positioning Scorepanel
        bg.add(scorePanel, c);
        scorePanel.setOpaque(true);
        scorePanel.setBackground(new Color(254, 10, 207, 0));

        c.insets = new Insets(600, 140, 10 , 140); //-> positioning Scorepanel
        exit = new JButton("Back");
        exit.setOpaque(true);
        exit.setBorderPainted(true);
        exit.setFont(Constants.titleFont);
        exit.setBackground(new Color(1, 247, 253));
        exit.setForeground(new Color(254, 10, 207));
        exit.setBorder(new RoundBtn(15));
        exit.setVisible(true);
        bg.add(exit, c);


        //Add JPanel to JFrame, pack and set visible
        window.add(bg);
        window.pack();
        window.setVisible(true);

        //Other function
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.addKeyListener(new PressingKeys());
        //NOT ALLOW USER RESIZE
        window.setResizable(true);
        window.setTitle("THUNDER BRICK BREAKER PRO MAX ULTRA VIP");
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        //Validate and repaint if needed
        window.revalidate();
        window.validate();
        window.repaint();

        // Fix the bug of not showing bg
        listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.setSize(480, 700);
                window.validate();
                window.repaint();
                //timer.stop();
            }
        };

        timer = new Timer(5, listener);
        timer.start();


        //Main menu at the bottom
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
                try {
                    new MainMenu();
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

    }
}

