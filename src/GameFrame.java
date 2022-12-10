import javax.swing.JFrame;

import java.awt.Dimension;

 class GameFrame extends JFrame {

    GameFrame () {
        add(new GamePanel(this));
        setTitle("CAPTCHA Snake Game");
        setSize(new Dimension(CAPTCHASnakeGame.GAME_WIDTH, CAPTCHASnakeGame.GAME_HEIGHT));
        setResizable(false); //check
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void closeFrame(){
        super.dispose();
    }
}
