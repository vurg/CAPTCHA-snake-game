import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenuFrame extends JFrame implements ActionListener {
    public static final int MENU_WIDTH = 600;
    public static final int MENU_HEIGHT = 200;
    JPanel panel;
    JButton startMenu;
    //static JButton customizeSnake;
    JButton customizeGame;



    public StartMenuFrame(){

        this.setTitle("Welcome to the Snake CAPTCHA game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(MENU_WIDTH, MENU_HEIGHT); //or this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        start();
    }

    public void NewFrame(){
        super.dispose();
    }
    public void start(){
        panel=new JPanel();
        this.add(panel);

        JLabel startMessage = new JLabel("Welcome to the CAPTCHA snake game!");
        startMessage.setFont(new Font("Comic Sans", Font.BOLD, 20));
        startMessage.setForeground(Color.BLACK);
        panel.add(startMessage);

        //the buttons
        startMenu= new JButton("Start Game");
        customizeGame= new JButton("Settings");

        startMenu.setFocusable(false);
        startMenu.setFont(new Font("Comic Sans", Font.PLAIN, 12));
        startMenu.setBackground(new Color(54, 103, 156));
        startMenu.setForeground(Color.WHITE);
        startMenu.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                NewFrame();
                new Frame(PuzzleSizeMenu.numberOfSymbols, LanguageMenu.includeSwedishLetters);
            }
        });
        panel.add(startMenu);


        customizeGame.setFocusable(false);
        customizeGame.setFont(new Font("Comic Sans", Font.PLAIN, 12));
        customizeGame.setBackground(new Color(54, 103, 156));
        customizeGame.setForeground(Color.WHITE);
        customizeGame.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                NewFrame();
                new LanguageMenu();
            }
        });
        panel.add(customizeGame);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new StartMenuFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}


