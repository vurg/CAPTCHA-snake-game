
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class LanguageMenu extends JFrame {

    public static boolean includeSwedishLetters = true;
    LanguageMenu(){
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
        panel.setBackground(Color.LIGHT_GRAY);
        this.add(panel);

        JLabel welcomeMsg = new JLabel("Please select your alphabet:");
        panel.add(welcomeMsg);

        JButton swedishLanguageButton=new JButton("Swedish");
        swedishLanguageButton.setFont(new Font("Ariel", Font.BOLD, 12));
        swedishLanguageButton.setForeground(Color.BLUE);
        swedishLanguageButton.setBackground(Color.yellow);
        panel.add(swedishLanguageButton);

        JButton englishLanguageButton=new JButton("English");
        englishLanguageButton.setFont(new Font("Ariel", Font.BOLD, 12));
        englishLanguageButton.setForeground(Color.red);
        englishLanguageButton.setBackground(Color.BLUE);
        panel.add(englishLanguageButton);

        swedishLanguageButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                includeSwedishLetters = true;
                //System.out.println("Language: Swedish. Swedish boolean: " + StartMenu.includeSwedishLetters);
                CloseFrame();
                new PuzzleSizeMenu();
            }
        });

        englishLanguageButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                includeSwedishLetters = false;
                //System.out.println("Language: English. Swedish boolean: " + StartMenu.includeSwedishLetters);
                CloseFrame();
                new PuzzleSizeMenu();
            }
        });
    }
}
