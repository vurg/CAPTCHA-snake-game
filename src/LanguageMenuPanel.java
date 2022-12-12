import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class LanguageMenuPanel extends JPanel {

    
    LanguageMenuPanel (LanguageMenuFrame languageMenuFrame) {

        setBackground(Color.LIGHT_GRAY);

        JLabel welcomeMsg = new JLabel("Please select your alphabet:");
        add(welcomeMsg);

        JButton swedishLanguageButton = new JButton("Swedish");
        swedishLanguageButton.setFont(new Font("Ariel", Font.BOLD, 12));
        swedishLanguageButton.setForeground(Color.BLUE);
        swedishLanguageButton.setBackground(Color.yellow);
        add(swedishLanguageButton);

        JButton englishLanguageButton = new JButton("English");
        englishLanguageButton.setFont(new Font("Ariel", Font.BOLD, 12));
        englishLanguageButton.setForeground(Color.red);
        englishLanguageButton.setBackground(Color.BLUE);
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
}
