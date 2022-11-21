package MySnakeGame;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    Frame(){
        //GridLayout experimentLayout = new GridLayout(0,2);
        //this.add(new MyGamePanel());
        new GridLayout(0,2);
        this.add(new MyCaptchaPanel());
        this.add(new MyCaptchaPanel());

        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
}
