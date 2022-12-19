import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class LanguageMenuPanel extends JPanel {
    
    LanguageMenuPanel (LanguageMenuFrame languageMenuFrame) {

        setLayout(null);

        JLabel welcomeMsg = new JLabel("Please Select Your Alphabet:", SwingConstants.CENTER);
        welcomeMsg.setFont(new Font("Ariel", Font.BOLD, 22));
        welcomeMsg.setForeground(new Color(220,250,220));
        welcomeMsg.setBounds((CAPTCHASnakeGame.MENU_WIDTH / 2) - (300 / 2), 150, 300, 100);
        add(welcomeMsg);

        JButton swedishLanguageButton = new JButton("Swedish");
        swedishLanguageButton.setFont(new Font("Ariel", Font.BOLD, 12));
        swedishLanguageButton.setForeground(Color.BLUE);
        swedishLanguageButton.setBackground(Color.yellow);
        swedishLanguageButton.setBounds((CAPTCHASnakeGame.MENU_WIDTH / 2), (CAPTCHASnakeGame.MENU_HEIGHT / 2) - (60 / 2), 80, 60);
        add(swedishLanguageButton);

        JButton englishLanguageButton = new JButton("English");
        englishLanguageButton.setFont(new Font("Ariel", Font.BOLD, 12));
        englishLanguageButton.setForeground(Color.red);
        englishLanguageButton.setBackground(Color.BLUE);
        englishLanguageButton.setBounds((CAPTCHASnakeGame.MENU_WIDTH / 2) - 80, (CAPTCHASnakeGame.MENU_HEIGHT / 2) - (60 / 2), 80, 60);
        add(englishLanguageButton);

        swedishLanguageButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                CAPTCHASnakeGame.setIncludeSwedishLetters(true);
                languageMenuFrame.closeFrame();
                new PuzzleSizeMenuFrame();
            }
        });

        englishLanguageButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                CAPTCHASnakeGame.setIncludeSwedishLetters(false);
                languageMenuFrame.closeFrame();
                new PuzzleSizeMenuFrame();
            }
        });
    }

    @Override
    public void paintComponent (Graphics g){
        super.paintComponent(g);

        Image img = new ImageIcon("./wallpapers/wallp2.jpg").getImage();

        g.drawImage(img, 0, 0, null);
        
    }  
}
