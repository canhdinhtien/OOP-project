package Main;
import Manager.Constants;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class IntroMenu extends JPanel{

    static Image img = Toolkit.getDefaultToolkit().getImage("resource/Image/computer3.jpg");
    static Image newImage = img.getScaledInstance(480, 678, Image.SCALE_DEFAULT);
    static JFrame window;
    static JPanel bg;
    static JPanel textPanel;
    public static JTextField playerName;
    static ActionListener listener;
    static Timer timer;

    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws InterruptedException, IOException {
        //Create a JFrame with 0 layout
        window = new JFrame();
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
        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(400, 80, 200, 80); // -> adding distance for each panel
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.ipady = 20;
        c.fill = GridBagConstraints.BOTH;

        textPanel = new JPanel();
        bg.add(textPanel, c);

        //add text field into the text panel and format text field
        textPanel.setLayout(new GridBagLayout());
        c.insets = new Insets(0, 0, 0, 0);

        playerName = new JTextField();
        playerName.setFocusable(true);
        playerName.setFont(Constants.titleFont);
        playerName.setHorizontalAlignment(JTextField.CENTER);
        playerName.setText("Type your name");
        playerName.requestDefaultFocus();
        if(playerName.getText() != null) textPanel.add(playerName, c);

        //Edit text panel style
        textPanel.setBackground(new Color(250, 250, 250, 0));
        playerName.setBackground(new Color(250, 250, 250, 0));
        playerName.setForeground(new Color(254, 10, 207));
        textPanel.setVisible(true);

        //Add JPanel to JFrame, pack and set visible
        window.add(bg);
        window.pack();
        window.setVisible(true);

        //Other function
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        playerName.addKeyListener(new Main.PressingKeys());
        //NOT ALLOW USER RESIZE
        window.setResizable(true);
        window.setTitle("THUNDER BRICK BREAKER PRO MAX ULTRA VIP");
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        //Validate and repaint if needed
        window.revalidate();
        window.validate();
        window.repaint();
        playerName.selectAll();

        // Fix the bug of not showing bg
        listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.setSize(Constants.MENU_WIDTH, Constants.MENU_HEIGHT);
                window.validate();
                window.repaint();
                //timer.stop();
            }
        };

        timer = new Timer(5, listener);
        timer.start();
    }
}