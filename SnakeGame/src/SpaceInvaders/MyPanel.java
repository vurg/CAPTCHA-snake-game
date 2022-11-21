package SpaceInvaders;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel implements ActionListener {

    final int PANEL_WIDTH = 1600;
    final int PANEL_HEIGHT = 900;
    Image enemy;
    Image backgroundImage;
    Timer timer;
    int xVelocity = 20;
    int yVelocity = 8;
    int x = 0;
    int y = 0;

    MyPanel(){
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.black);
        //enemy = new ImageIcon("C:\\Users\\Nasit\\IdeaProjects\\SnakeGame\\CAPTCHA\\B.png").getImage();
        enemy = new ImageIcon("CAPTCHA/B.png").getImage();
        backgroundImage = new ImageIcon("background.png").getImage();

        // action listener in timer, is this, since we are implementing actionListener here
        timer = new Timer(1, this); // Timer needs a delay (int in miliseconds), and listener
        timer.start(); // starts timer
    }

    public void paint(Graphics g){
        super.paint(g); //paint background

        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(backgroundImage, 0, 0, null);
        g2D.drawImage(enemy, x, y, null);
    }

    // performs action every 1000 ms, as defined in Timer
    @Override
    public void actionPerformed(ActionEvent e) {
        if(x <= PANEL_WIDTH - enemy.getWidth(null) && x >= 0){
            x = x + xVelocity;
        }else{
            x = x - xVelocity;
            xVelocity = -1 * xVelocity;
        }

        System.out.println("Width: " + backgroundImage.getWidth(null));
        System.out.println("Height: " + backgroundImage.getHeight(null));

        if(y <= PANEL_HEIGHT - enemy.getHeight(null)  && y >= 0){
            y = y + yVelocity;
        }else{
            y = y - yVelocity;
            yVelocity = -1 * yVelocity;
        }
        repaint();
    }
}
