import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PuzzleSizeMenu extends JFrame {
    public static int numberOfSymbols = 6;
    PuzzleSizeMenu(){
        this.setTitle("Welcome to the Snake CAPTCHA game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(StartMenuFrame.MENU_WIDTH, StartMenuFrame.MENU_HEIGHT);
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

        JLabel message = new JLabel("Please select size of CAPTCHA puzzle:");
        message.setFont(new Font("Comic Sans", Font.BOLD, 15));
        message.setForeground(Color.BLACK);
        panel.add(message);

        JButton buttonFive=new JButton("Five");
        buttonFive.setFocusable(false);
        buttonFive.setBackground(new Color(54, 103, 156));
        buttonFive.setForeground(Color.WHITE);
        panel.add(buttonFive);

        JButton buttonSix=new JButton("Six");
        buttonSix.setFocusable(false);
        buttonSix.setBackground(new Color(54, 103, 156));
        buttonSix.setForeground(Color.WHITE);
        panel.add(buttonSix);

        JButton buttonSeven=new JButton("Seven");
        buttonSeven.setFocusable(false);
        buttonSeven.setBackground(new Color(54, 103, 156));
        buttonSeven.setForeground(Color.WHITE);
        panel.add(buttonSeven);

        JButton buttonEight=new JButton("Eight");
        buttonEight.setFocusable(false);
        buttonEight.setBackground(new Color(54, 103, 156));
        buttonEight.setForeground(Color.WHITE);
        panel.add(buttonEight);

        buttonFive.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                numberOfSymbols = 5;
                CloseFrame();
                new StartMenuFrame();
            }
        });

        buttonSix.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                numberOfSymbols = 6;
                CloseFrame();
                new StartMenuFrame();
            }
        });

        buttonSeven.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                numberOfSymbols = 7;
                CloseFrame();
                new StartMenuFrame();
            }
        });

        buttonEight.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                numberOfSymbols = 8;
                CloseFrame();
                new StartMenuFrame();
            }
        });
    }
}
