package NewGame;

import javax.swing.*;
import java.awt.*;

public class NameFrame extends JFrame {
    NameFrame(){
        this.add(new BossPanel());
        this.add(new Panel());

        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        //this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
