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

        JLabel startMessageLabel = new JLabel("Welcome To CAPTCHA Snake", SwingConstants.CENTER);
        System.out.println(Label.WIDTH);
        startMessageLabel.setFont(new Font("Comic Sans", Font.BOLD, 24));
        startMessageLabel.setForeground(new Color(230, 245, 230));
        startMessageLabel.setBounds((CAPTCHASnakeGame.MENU_WIDTH / 2 ) - (400 / 2), 160, 400, 100);
        this.add(startMessageLabel);

        JButton startGameButton= new JButton("Start Game");
        startGameButton.setFont(new Font("Comic Sans", Font.PLAIN, 12));
        startGameButton.setBackground(new Color(60,179,113));
        startGameButton.setForeground(Color.WHITE);
        startGameButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                startMenuFrame.closeFrame();
                new GameFrame();
            }
        });
        startGameButton.setBounds((CAPTCHASnakeGame.MENU_WIDTH / 2) - 100, 300, 100, 50);
        this.add(startGameButton);


        JButton customizeGameButton = new JButton("Settings");
        customizeGameButton.setFont(new Font("Comic Sans", Font.PLAIN, 12));
        customizeGameButton.setBackground(new Color(85,107,47));
        customizeGameButton.setForeground(Color.WHITE);
        customizeGameButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                startMenuFrame.closeFrame();
                new LanguageMenuFrame();
            }
        });

        customizeGameButton.setBounds((CAPTCHASnakeGame.MENU_WIDTH / 2), 300, 100, 50);
        this.add(customizeGameButton);

        JLabel label = new JLabel("Latest game size");

        add(label);

        JLabel label2 = new JLabel("Latest elapsed time");
        
        add(label2);
    }

    @Override
    public void paintComponent (Graphics g){
        super.paintComponent(g);

        Image img = new ImageIcon("./wallpapers/wallp2.jpg").getImage();

        g.drawImage(img, 0, 0, null);
        
    }

}
