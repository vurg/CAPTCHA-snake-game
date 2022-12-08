import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
    public class LanguageMenuFrame extends JFrame {

        public static boolean includeSwedishLetters = true;
        LanguageMenuFrame(){
            this.setTitle("Welcome to the Snake CAPTCHA game");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(false);
            this.setSize(MainMenu.MENU_WIDTH, MainMenu.MENU_HEIGHT);
            this.setVisible(true);
            this.setLocationRelativeTo(null);
            start();
        }

        public void CloseFrame(){
            super.dispose();
        }

        public void start(){
            JPanel panel = new JPanel();
            this.add(panel);

            JLabel startMessage = new JLabel("Please select your alphabet:");
            startMessage.setFont(new Font("Comic Sans", Font.BOLD, 15));
            startMessage.setForeground(Color.BLACK);
            panel.add(startMessage);

            JButton swedish=new JButton("Swedish");
            swedish.setFocusable(false);
            swedish.setFont(new Font("Comic Sans", Font.PLAIN, 12));
            swedish.setBackground(new Color(54, 103, 156));
            swedish.setForeground(Color.WHITE);
            panel.add(swedish);

            JButton english=new JButton("English");
            english.setFocusable(false);
            english.setFont(new Font("Comic Sans", Font.PLAIN, 12));
            english.setBackground(new Color(54, 103, 156));
            english.setForeground(Color.WHITE);
            panel.add(english);

            swedish.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    includeSwedishLetters = true;
                    CloseFrame();
                    new PuzzleSizeMenu();
                }
            });

            english.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    includeSwedishLetters = false;
                    CloseFrame();
                    new PuzzleSizeMenu();
                }
            });
        }
    }
