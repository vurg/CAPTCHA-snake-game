package MySnakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyCaptchaPanel extends JPanel implements ActionListener{

    static final int SCREEN_WIDTH = 300;
    static final int SCREEN_HEIGHT = 250;
    static final int UNIT_SIZE = 50;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/(UNIT_SIZE*UNIT_SIZE);
    static final int DELAY = 100;
    final int[] x = new int[GAME_UNITS];
    final int[] y = new int[GAME_UNITS];
    int bodyParts = 6;
    int applesEaten;
    int appleX;
    int appleY;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;

    Image A;
    Image B;

    MyCaptchaPanel(){
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        A = new ImageIcon("CAPTCHA/A.png").getImage();
        B = new ImageIcon("CAPTCHA/B.png").getImage();

    }

    public void paint(Graphics g){
        super.paint(g); //paint background

        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(A, 0, 0, null);
        g2D.drawImage(B, 100, 100, null);
    }

    public void actionPerformed(ActionEvent e) {

    }
}
