package CAPTCHASnakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenu extends JFrame {
    public static final int MENU_WIDTH = 600;
    public static final int MENU_HEIGHT = 200;
    public static final String END_OF_LINE = System.lineSeparator();

    StartMenu(){
        this.setTitle("Welcome to the Snake CAPTCHA game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(MENU_WIDTH, MENU_HEIGHT); //or this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        start();
    }

    public void CloseFrame(){
        super.dispose();
    }

    public void start(){
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        this.add(panel);
        //panel.setLayout(null);
        JLabel welcomeMsg = new JLabel("Welcome to the CAPTCHA snake game!" );
        welcomeMsg.setFont(new Font("Ariel",Font.BOLD,14));
        welcomeMsg.setBounds(150, 100, 300, 50);


        panel.add(welcomeMsg);

        JButton startGameButton=new JButton("Start Game");
        startGameButton.setBackground(Color.green);
        startGameButton.setBounds(0, 100, 50, 50);

        panel.add(startGameButton);
        JButton customizeButton=new JButton("Customize");
        customizeButton.setBackground(Color.blue);
        customizeButton.setForeground(Color.white);
        panel.add(customizeButton);

        startGameButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                CloseFrame();
                //System.out.println("Starting game. NumCharacters: " + PuzzleSizeMenu.numSymbols + ". Swedish language: " + LanguageMenu.includeSwedishLetters);
                new Frame(PuzzleSizeMenu.numSymbols, LanguageMenu.includeSwedishLetters);
            }
        });

        customizeButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                CloseFrame();
                new LanguageMenu();
            }
        });

        this.setVisible(true);
    }
}
