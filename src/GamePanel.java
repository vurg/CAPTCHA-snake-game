import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Image;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 class GamePanel extends JPanel implements ActionListener {

    private GameFrame gameFrame;
    private final int BLOCK_LENGTH = 35;
    private final int NEW_FRAME_DELAY_MILLISECONDS = 200;
    
    private int nrOfSnakeBodyParts;
    private int nrOf_CAPTCHA_Taken;
    private boolean gameIsRunning;

    private Timer timer;
    private Random random;

    private int[] snake_X_Coordinates;
    private int[] snake_Y_Coordinates;
    private ArrayList<Integer> my_CAPTCHA_Puzzle_X_Coordinates;
    private ArrayList<Integer> my_CAPTCHA_Puzzle_Y_Coordinates;

    private KeyboardControls keyboardControls;
    private CAPTCHA my_CAPTCHA_Puzzle;
    private ArrayList<Image> my_CAPTCHA_PuzzleArrayListImage;

    private final int TIME_LIMIT = 60;

    // private boolean isRobot;
    private int elapsedTimeMilliseconds;
    private int score;

    private JButton mainMenuButton;
    private JButton retryButton;
    private JButton type_CAPTCHA_Button;
    private JButton exitButton;

    private FontMetrics fontMetrics;

    GamePanel (GameFrame gameFrame) {

        this.gameFrame = gameFrame;

        nrOfSnakeBodyParts = 6;
        timer = new Timer(NEW_FRAME_DELAY_MILLISECONDS, this);
        random = new Random();
        snake_X_Coordinates = new int[600];
        snake_Y_Coordinates = new int[600];
        my_CAPTCHA_Puzzle_X_Coordinates = new ArrayList<>();
        my_CAPTCHA_Puzzle_Y_Coordinates = new ArrayList<>();
        keyboardControls = new KeyboardControls();
        addKeyListener(keyboardControls);
        my_CAPTCHA_Puzzle = new CAPTCHA();
        my_CAPTCHA_Puzzle.generatePuzzle();
        my_CAPTCHA_PuzzleArrayListImage = my_CAPTCHA_Puzzle.getMy_CAPTCHA_ArrayListImage();
        mainMenuButton = new JButton("Main Menu");
        retryButton = new JButton("Retry");
        type_CAPTCHA_Button = new JButton("Type CAPTCHA");
        exitButton = new JButton("Exit");

        setFocusable(true);
        setLayout(null);

        startGame();

    }

    private void startGame() {
        
        gameIsRunning = true;

        generate_CAPTCHA_ImageCoordinates();

        timer.start();

    }

    private void generate_CAPTCHA_ImageCoordinates () {

        int CAPTCHA_Image_X_Coordinate = 0;
        int CAPTCHA_Image_Y_Coordinate = 0;
        boolean noSameCoordinates = true;

        for (int i = 0; i < my_CAPTCHA_PuzzleArrayListImage.size(); i++) {

            do {
                noSameCoordinates = true;

                CAPTCHA_Image_X_Coordinate = random.nextInt((CAPTCHASnakeGame.GAME_WIDTH / 2) / BLOCK_LENGTH) * BLOCK_LENGTH;
                CAPTCHA_Image_Y_Coordinate = random.nextInt(1, CAPTCHASnakeGame.GAME_HEIGHT / BLOCK_LENGTH) * BLOCK_LENGTH; //prev 1 row



                    for (int j = 0; j < my_CAPTCHA_Puzzle_X_Coordinates.size(); j++) {

                        if (my_CAPTCHA_Puzzle_X_Coordinates.get(j) == CAPTCHA_Image_X_Coordinate && my_CAPTCHA_Puzzle_Y_Coordinates.get(j) == CAPTCHA_Image_Y_Coordinate) {
    
                            noSameCoordinates = false;
                            break;
    
                        }
                    }


            } while (noSameCoordinates == false);

                my_CAPTCHA_Puzzle_X_Coordinates.add(CAPTCHA_Image_X_Coordinate);
                my_CAPTCHA_Puzzle_Y_Coordinates.add(CAPTCHA_Image_Y_Coordinate);

        }
    }

    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);

        if (gameIsRunning == false && score == my_CAPTCHA_PuzzleArrayListImage.size()) {
            timer.stop();
            drawVerificationSuccessScreen(g);

        } else if (gameIsRunning == false) {
            timer.stop();
            drawVerificationFailureScreen(g);

        } else {

            drawRunningGame(g);

        } //check

    }

    private void drawRunningGame(Graphics g){

        //left side of panel
        g.setColor(Color.BLACK);
        g.fillRect(0,0, CAPTCHASnakeGame.GAME_WIDTH / 2, CAPTCHASnakeGame.GAME_HEIGHT);

            for (int i = 0; i < nrOfSnakeBodyParts; i++) {

                if (i == 0){
                  
                    g.setColor(Color.RED);
                    g.fillRect(snake_X_Coordinates[i], snake_Y_Coordinates[i], BLOCK_LENGTH, BLOCK_LENGTH);
    
                    if (snake_X_Coordinates[i] == snake_X_Coordinates[i+1] && snake_Y_Coordinates[i] == snake_Y_Coordinates[i+1]){
    
                        break;
    
                    }
    
                } else {
    
                    g.setColor(Color.GREEN);
                    g.fillRect(snake_X_Coordinates[i], snake_Y_Coordinates[i], BLOCK_LENGTH, BLOCK_LENGTH);
    
                }
    
            }

            for (int i = 0; i < my_CAPTCHA_PuzzleArrayListImage.size(); i++) {

                g.drawImage(my_CAPTCHA_PuzzleArrayListImage.get(i), my_CAPTCHA_Puzzle_X_Coordinates.get(i), my_CAPTCHA_Puzzle_Y_Coordinates.get(i), null);
    
            }

            //right side of panel
            g.setColor(Color.BLACK);
            g.setFont(new Font("Courier", Font.ITALIC ,20));
            fontMetrics = getFontMetrics(g.getFont());

            g.drawString("Collect The Following CAPTCHA Symbols:", (CAPTCHASnakeGame.GAME_WIDTH - (CAPTCHASnakeGame.GAME_WIDTH / 2 / 2)) - (fontMetrics.stringWidth("Collect The Following CAPTCHA Symbols:") / 2), 100); //check

            for (int i = nrOf_CAPTCHA_Taken; i < my_CAPTCHA_PuzzleArrayListImage.size(); i++) {

                g.drawImage(my_CAPTCHA_PuzzleArrayListImage.get(i), (CAPTCHASnakeGame.GAME_WIDTH - (CAPTCHASnakeGame.GAME_WIDTH / 2 / 2)) - (35 * my_CAPTCHA_PuzzleArrayListImage.size() / 2) + (35 * i), 200, null);
                
            }

            g.drawString("Collected:", (CAPTCHASnakeGame.GAME_WIDTH - (CAPTCHASnakeGame.GAME_WIDTH / 2 / 2)) - (fontMetrics.stringWidth("Collected:") / 2), 300); //check

            if (nrOf_CAPTCHA_Taken == 0) {

                g.drawString("None", (CAPTCHASnakeGame.GAME_WIDTH - (CAPTCHASnakeGame.GAME_WIDTH / 2 / 2)) - (fontMetrics.stringWidth("None") / 2) + 150, 300); // check

            } else {

                for (int i = 0; i < nrOf_CAPTCHA_Taken; i++) {

                    g.drawImage(my_CAPTCHA_PuzzleArrayListImage.get(i), (CAPTCHASnakeGame.GAME_WIDTH - (CAPTCHASnakeGame.GAME_WIDTH / 2 / 2)) - (35 * my_CAPTCHA_PuzzleArrayListImage.size() / 2) + (35 * i), 350, null);
    
                }

            }

            g.drawString("Time Remaining: " + (TIME_LIMIT - (elapsedTimeMilliseconds / 1000)) + "s", (CAPTCHASnakeGame.GAME_WIDTH - (CAPTCHASnakeGame.GAME_WIDTH / 2 / 2)) - (fontMetrics.stringWidth("Time Remaining: " + (TIME_LIMIT - (elapsedTimeMilliseconds / 1000)) + "s") / 2), 500); //check

    }

    private void drawVerificationSuccessScreen(Graphics g) {

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, CAPTCHASnakeGame.GAME_WIDTH, CAPTCHASnakeGame.GAME_HEIGHT);

        for (int i = 0; i < my_CAPTCHA_PuzzleArrayListImage.size(); i++){
            g.drawImage(my_CAPTCHA_PuzzleArrayListImage.get(i), (CAPTCHASnakeGame.GAME_WIDTH / 2) - (my_CAPTCHA_PuzzleArrayListImage.size() / 2) + (35 * i), 100, null);
        }
        
        g.setColor(Color.BLUE);
        // fontMetrics = getFontMetrics(g.getFont());

        g.drawString("Verification Complete", (CAPTCHASnakeGame.GAME_WIDTH / 2) - (fontMetrics.stringWidth("Verification Complete") / 2), 200);

        g.drawString("You Are Not A Robot!", (CAPTCHASnakeGame.GAME_WIDTH / 2) - (fontMetrics.stringWidth("You Are Not A Robot!") / 2), 300);

        g.drawString("Time Elapsed: " + (elapsedTimeMilliseconds / 1000) + "s", (CAPTCHASnakeGame.GAME_WIDTH / 2) - (fontMetrics.stringWidth("Time Elapsed: " + (elapsedTimeMilliseconds / 1000) + "s") / 2), 400);

        g.drawString("Game Size: " + my_CAPTCHA_PuzzleArrayListImage.size() + " Symbols", (CAPTCHASnakeGame.GAME_WIDTH / 2) - (fontMetrics.stringWidth("Game Size: " + my_CAPTCHA_PuzzleArrayListImage.size() + " Symbols") / 2), 500);

        exitButton.setBounds((CAPTCHASnakeGame.GAME_WIDTH / 2) - 50, 600, 100, 50);
        add(exitButton);

        exitButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                //check
            }

        });

    }

    private void drawVerificationFailureScreen(Graphics g){

        g.setColor(Color.RED);

        g.drawString("Game Over", (CAPTCHASnakeGame.GAME_WIDTH / 2) - (fontMetrics.stringWidth("Game Over") / 2), 100);

        g.setColor(Color.BLACK);

        g.drawString("Verification Failed", (CAPTCHASnakeGame.GAME_WIDTH / 2) - (fontMetrics.stringWidth("Verification Failed") / 2), 200);

        mainMenuButton.setBounds((CAPTCHASnakeGame.GAME_WIDTH / 2) - (100 / 2) - 120, 600, 100, 50);
        retryButton.setBounds((CAPTCHASnakeGame.GAME_WIDTH / 2) - (100 / 2), 600, 100, 50);
        type_CAPTCHA_Button.setBounds((CAPTCHASnakeGame.GAME_WIDTH / 2) - (100 / 2) + 120, 600, 100, 50);

        add(mainMenuButton);
        add(retryButton);
        add(type_CAPTCHA_Button);
        


        mainMenuButton.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e) {

                gameFrame.closeFrame();
                new StartMenuFrame();


            }

        });


        retryButton.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e) {

                gameFrame.closeFrame();
                new GameFrame();


            }

        });


        type_CAPTCHA_Button.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e) {

                gameFrame.closeFrame();
                new TypeCAPTCHAMenuFrame(my_CAPTCHA_Puzzle);


            }

        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        elapsedTimeMilliseconds += NEW_FRAME_DELAY_MILLISECONDS;

        if (gameIsRunning)
        {
            move();
            checkCollisions();
            checkTime();
            checkLetter();
        }
        repaint();
    }

    private void move(){ 
        for (int i = nrOfSnakeBodyParts; i>0; i--){
            snake_X_Coordinates[i] = snake_X_Coordinates[i-1];
            snake_Y_Coordinates[i] = snake_Y_Coordinates[i-1];
        }

        System.out.println(keyboardControls.getSnakeMovingDirection());
        switch(keyboardControls.getSnakeMovingDirection()) {
            case 'L':
            snake_X_Coordinates[0] = snake_X_Coordinates[0] - BLOCK_LENGTH;
                break;
            case 'R':
            snake_X_Coordinates[0] = snake_X_Coordinates[0] + BLOCK_LENGTH;
                break;
            case 'U':
            snake_Y_Coordinates[0] = snake_Y_Coordinates[0] - BLOCK_LENGTH;
                break;
            case 'D':
            snake_Y_Coordinates[0] = snake_Y_Coordinates[0] + BLOCK_LENGTH;
                break;
        }
    }

    private void checkLetter(){

        for (int i=score; i<my_CAPTCHA_PuzzleArrayListImage.size(); i++){

            if((snake_X_Coordinates[0] == my_CAPTCHA_Puzzle_X_Coordinates.get(score)) && (snake_Y_Coordinates[0] == my_CAPTCHA_Puzzle_Y_Coordinates.get(score))) {
                nrOfSnakeBodyParts++;
                score++;
            }
        }

        if (score == my_CAPTCHA_PuzzleArrayListImage.size()){
            gameIsRunning = false;
        }
    }

    private void checkCollisions(){

        for(int i = nrOfSnakeBodyParts;i>0;i--) {
            if((snake_X_Coordinates[0] == snake_X_Coordinates[i]) && (snake_Y_Coordinates[0] == snake_Y_Coordinates[i])) {
                gameIsRunning = false;
                return;
            }
        }

        if(snake_X_Coordinates[0] < 0) {
            gameIsRunning = false;
        }
        if(snake_X_Coordinates[0] > CAPTCHASnakeGame.GAME_WIDTH / 2 - BLOCK_LENGTH) {
            gameIsRunning = false;
        }
        if(snake_Y_Coordinates[0] < 0) {
            gameIsRunning = false;
        }
        if(snake_Y_Coordinates[0] > CAPTCHASnakeGame.GAME_HEIGHT - BLOCK_LENGTH) {
            gameIsRunning = false;
        }
        if(!gameIsRunning) {
        }
    }

    private void checkTime(){

        if (elapsedTimeMilliseconds >= TIME_LIMIT*1000){
            gameIsRunning = false;
        }
    }

}