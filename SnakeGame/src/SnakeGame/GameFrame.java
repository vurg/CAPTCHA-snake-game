package SnakeGame;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame{

    GameFrame(int numSymbols, boolean includeSwedishLetters){
        this.add(new GamePanel(numSymbols, includeSwedishLetters));
        this.setTitle("Snake Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        //this.pack();
        this.setSize(GamePanel.SCREEN_WIDTH*4/3, GamePanel.SCREEN_HEIGHT);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
}