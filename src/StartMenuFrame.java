import javax.swing.JFrame;



 class StartMenuFrame extends JFrame {

    public StartMenuFrame(){

        this.add(new StartMenuPanel(this));
        this.setTitle("Welcome to the Snake CAPTCHA game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(CAPTCHASnakeGame.MENU_WIDTH, CAPTCHASnakeGame.MENU_HEIGHT); //or this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
    }

    public void closeFrame (){
        super.dispose();
    }
}


