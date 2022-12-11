import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



class StartMenuPanel extends JPanel {

    StartMenuPanel (StartMenuFrame startMenuFrame) {

        setVisible(true);

        JLabel startMessageLabel = new JLabel("Welcome to the CAPTCHA snake game!");
        startMessageLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
        startMessageLabel.setForeground(Color.BLACK);
        this.add(startMessageLabel);

        JButton startGameButton= new JButton("Start Game");
        startGameButton.setFocusable(false);
        startGameButton.setFont(new Font("Comic Sans", Font.PLAIN, 12));
        startGameButton.setBackground(new Color(54, 103, 156));
        startGameButton.setForeground(Color.WHITE);
        startGameButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                startMenuFrame.closeFrame();
                new GameFrame();
            }
        });

        this.add(startGameButton);


        JButton customizeGameButton = new JButton("Settings");
        customizeGameButton.setFocusable(false);
        customizeGameButton.setFont(new Font("Comic Sans", Font.PLAIN, 12));
        customizeGameButton.setBackground(new Color(54, 103, 156));
        customizeGameButton.setForeground(Color.WHITE);
        customizeGameButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                startMenuFrame.closeFrame();
                new LanguageMenuFrame();
            }
        });

        this.add(customizeGameButton);

    }
    
}
