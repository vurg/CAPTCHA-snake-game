import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PuzzleSizeMenuPanel extends JPanel {
    
    PuzzleSizeMenuPanel (PuzzleSizeMenuFrame puzzleSizeMenuFrame) {

        JLabel messageLabel = new JLabel("Please select size of CAPTCHA puzzle:");
        messageLabel.setFont(new Font("Comic Sans", Font.BOLD, 15));
        messageLabel.setForeground(Color.BLACK);
        add(messageLabel);

        JButton buttonFive = new JButton("Five");
        buttonFive.setBackground(new Color(54, 103, 156));
        buttonFive.setForeground(Color.WHITE);
        add(buttonFive);

        JButton buttonSix = new JButton("Six");
        buttonSix.setBackground(new Color(54, 103, 156));
        buttonSix.setForeground(Color.WHITE);
        add(buttonSix);

        JButton buttonSeven = new JButton("Seven");
        buttonSeven.setBackground(new Color(54, 103, 156));
        buttonSeven.setForeground(Color.WHITE);
        add(buttonSeven);

        JButton buttonEight = new JButton("Eight");
        buttonEight.setBackground(new Color(54, 103, 156));
        buttonEight.setForeground(Color.WHITE);
        add(buttonEight);

        buttonFive.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                CAPTCHASnakeGame.setNrOf_CAPTCHA_Symbols(5);
                puzzleSizeMenuFrame.closeFrame();
                new StartMenuFrame();
            }
        });

        buttonSix.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                CAPTCHASnakeGame.setNrOf_CAPTCHA_Symbols(6);
                puzzleSizeMenuFrame.closeFrame();
                new StartMenuFrame();
            }
        });

        buttonSeven.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                CAPTCHASnakeGame.setNrOf_CAPTCHA_Symbols(7);
                puzzleSizeMenuFrame.closeFrame();
                new StartMenuFrame();
            }
        });

        buttonEight.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                CAPTCHASnakeGame.setNrOf_CAPTCHA_Symbols(8);
                puzzleSizeMenuFrame.closeFrame();
                new StartMenuFrame();
            }
        });
    }
}
