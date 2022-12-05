package CAPTCHASnakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TypeCAPTCHAMenuFrame extends JFrame{

    TypeCAPTCHAMenuFrame(CAPTCHA currentPuzzle){
        //sets frame properties
        this.setTitle("Welcome to the Snake CAPTCHA game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(CAPTCHASnakeGame.GAME_WIDTH+350, CAPTCHASnakeGame.GAME_HEIGHT);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        new TypeCAPTCHAMenuPanel(currentPuzzle);
    }
}
