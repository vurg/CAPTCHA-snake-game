package CAPTCHASnakeGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PuzzleSizeMenu extends JFrame {
    public static int numSymbols = 6;
    PuzzleSizeMenu(){
        this.setTitle("Welcome to the Snake CAPTCHA game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(StartMenu.MENU_WIDTH, StartMenu.MENU_HEIGHT);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        start();
    }
    public void CloseFrame(){
        super.dispose();
    }
    public void start(){
        JPanel panel = new JPanel();
        this.add(panel);

        JLabel welcomeMsg = new JLabel("Please select size of CAPTCHA puzzle:");
        panel.add(welcomeMsg);

        JButton fiveCharsButton=new JButton("Five");
        panel.add(fiveCharsButton);

        JButton sixCharsButton=new JButton("Six");
        panel.add(sixCharsButton);

        JButton sevenCharsButton=new JButton("Seven");
        panel.add(sevenCharsButton);

        JButton eightCharsButton=new JButton("Eight");
        panel.add(eightCharsButton);

        fiveCharsButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                numSymbols = 5;
                CloseFrame();
                new StartMenu();
            }
        });

        sixCharsButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                numSymbols = 6;
                CloseFrame();
                new StartMenu();
            }
        });

        sevenCharsButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                numSymbols = 7;
                CloseFrame();
                new StartMenu();
            }
        });

        eightCharsButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                numSymbols = 8;
                CloseFrame();
                new StartMenu();
            }
        });



    }
}
