package NewGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class BossPanel extends JPanel implements ActionListener {

    Timer timer;
    Random random;
    Image A;
    Image B;

    BossPanel(){
        random = new Random();
        this.setPreferredSize(new Dimension(1000,800));
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


    @Override
    public void actionPerformed(ActionEvent e) {
        int x = random.nextInt(1000);
        int y = random.nextInt(800);

    }
}
