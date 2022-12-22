import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Image;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Label;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



class StartMenuPanel extends JPanel {

    StartMenuPanel (StartMenuFrame startMenuFrame) {

        setLayout(null);
        setVisible(true);

        JLabel startMessageLabel = new JLabel("Welcome to the CAPTCHA Snake Game!", SwingConstants.CENTER);
        startMessageLabel.setFont(new Font("ComicSans", Font.BOLD, 22));
        startMessageLabel.setForeground(Color.WHITE);
        startMessageLabel.setBounds((CAPTCHASnakeGame.MENU_WIDTH / 2 ) - 300, 170, 600, 50);
        this.add(startMessageLabel);

        JButton startGameButton= new JButton("Start Game");
        startGameButton.setFont(new Font("Ariel", Font.BOLD, 12));
        startGameButton.setBackground(new Color(53, 66, 48));
        startGameButton.setForeground(Color.WHITE);
        startGameButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                startMenuFrame.closeFrame();
                new GameFrame();
            }
        });
        startGameButton.setBounds((CAPTCHASnakeGame.MENU_WIDTH / 2) - 110, 260, 100, 50);
        this.add(startGameButton);


        JButton customizeGameButton = new JButton("Settings");
        customizeGameButton.setFont(new Font("Ariel", Font.BOLD, 12));
        customizeGameButton.setBackground(new Color(85,107,47));
        customizeGameButton.setForeground(Color.WHITE);
        customizeGameButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                startMenuFrame.closeFrame();
                new LanguageMenuFrame();
            }
        });

        customizeGameButton.setBounds((CAPTCHASnakeGame.MENU_WIDTH / 2) + 10, 260, 100, 50);
        this.add(customizeGameButton);

    }

    @Override
    public void paintComponent (Graphics g){
        super.paintComponent(g);

        Image img = new ImageIcon("wallpapers/snakeGameBackground.png").getImage();

        g.drawImage(img, 0, -230, null);
        
    }

}
