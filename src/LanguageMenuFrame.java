
import javax.swing.*;

public class LanguageMenuFrame extends JFrame {
   
    LanguageMenuFrame(){

        this.setTitle("Welcome to the Snake CAPTCHA game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(CAPTCHASnakeGame.MENU_WIDTH, CAPTCHASnakeGame.MENU_HEIGHT);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        this.add(new LanguageMenuPanel(this));

    }

    public void closeFrame(){
        super.dispose();
    }

}
