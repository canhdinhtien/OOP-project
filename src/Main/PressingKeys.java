package Main;

import Main.UI.MainMenu;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PressingKeys extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {
        int action = e.getKeyCode();

        if(action == KeyEvent.VK_ENTER) {

            IntroMenu.window.dispose();
            try {
                new MainMenu();
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int action = e.getKeyCode();
    }

}