
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 class TypeCAPTCHAMenuPanel extends JPanel {

    private CAPTCHA my_CAPTCHA_Puzzle;

    TypeCAPTCHAMenuPanel(CAPTCHA my_CAPTCHA_Puzzle){
        
        this.my_CAPTCHA_Puzzle = my_CAPTCHA_Puzzle;
        startTyping();
        setFocusable(true);
        setLayout(null);
    }

    public void startTyping(){

        for (int i=0; i<my_CAPTCHA_Puzzle.getMy_CAPTCHA_ArrayListImage().size(); i++){
            JLabel myImgLabel = new JLabel();
            myImgLabel.setIcon(new ImageIcon(my_CAPTCHA_Puzzle.getFilePaths().get(i)));
            myImgLabel.setBounds((CAPTCHASnakeGame.MENU_WIDTH / 2) - ((CAPTCHASnakeGame.getNrOf_CAPTCHA_Symbols() * 35) / 2) + (i * 35), 100, 35, 35);
            add(myImgLabel);
        }

        // create a label to display text
        JLabel l = new JLabel("Type CAPTCHA:");

        // create a new button
        JButton b = new JButton("submit");

        // create a object of the text class
        JTextField t = new JTextField(16);

        // addActionListener to submit button -- checks if typed text field matches string equivalent of CAPTCHA puzzle
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String s = e.getActionCommand();
                if (s.equals("submit")) {
                    // set the text of the label to the text of the field
                    if(t.getText().equals(my_CAPTCHA_Puzzle.getMy_CAPTCHA_PuzzleString())){
                        l.setText("Congratulations! You are not a robot. Type Exit to leave the program.");
                        t.setText("");
                    }else if(t.getText().equals("Exit") || t.getText().equals("exit")) {
                        //closes window
                        JComponent comp = (JComponent) e.getSource();
                        Window win = SwingUtilities.getWindowAncestor(comp);
                        win.dispose();
                    }else{
                        l.setText("Incorrect. Try again!");
                    }
                }
            }
        });

        l.setBounds((CAPTCHASnakeGame.MENU_WIDTH / 2) - (400 / 2), 150, 400, 100);
        t.setBounds((CAPTCHASnakeGame.MENU_WIDTH / 2) - (150 / 2), 250, 150, 30);
        b.setBounds((CAPTCHASnakeGame.MENU_WIDTH / 2) - (100 / 2), 300, 100, 30);

        // add buttons and textfield to panel
        this.add(t);
        this.add(l);
        this.add(b);

    }
}
