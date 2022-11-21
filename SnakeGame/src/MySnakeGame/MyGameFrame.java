package MySnakeGame;

import SnakeGame.GamePanel;

import javax.swing.*;
import java.awt.*;

public class MyGameFrame extends JFrame{

    MyGameFrame(){
        this.add(new MyGamePanel());

        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
}