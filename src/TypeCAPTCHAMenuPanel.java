
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 class TypeCAPTCHAMenuPanel extends JPanel{

    private CAPTCHA my_CAPTCHA_Puzzle;

    TypeCAPTCHAMenuPanel(CAPTCHA currentPuzzle){
        this.my_CAPTCHA_Puzzle = currentPuzzle;
        StartTyping();
    }

    public void StartTyping(){
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

        // create a panel to add buttons and textfield
        JPanel p = new JPanel();

        // add buttons and textfield to panel
        p.add(t);
        p.add(b);
        p.add(l);

        // add panel to frame
        this.add(p);

        for (int i=0; i<my_CAPTCHA_Puzzle.getMy_CAPTCHA_ArrayListImage().size(); i++){
            JLabel myImgLabel = new JLabel();
            myImgLabel.setIcon(new ImageIcon(my_CAPTCHA_Puzzle.getFilePaths().get(i)));
            p.add(myImgLabel);
        }
        this.setVisible(true);
    }
}
