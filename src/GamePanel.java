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

public class GamePanel extends JPanel implements ActionListener {

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
    private ArrayList<Integer> myCAPTCHAPuzzle_X_Coordinates;
    private ArrayList<Integer> myCAPTCHAPuzzle_Y_Coordinates;

    private KeyboardControls keyboardControls;
    private CAPTCHA myCaptchaPuzzle;
    private ArrayList<Image> myCAPTCHAPuzzleImageArrayList;

    private final int TIME_LIMIT = 60;

    private boolean isRobot;
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
        snake_X_Coordinates = new int[600];
        snake_Y_Coordinates = new int[600];
        myCAPTCHAPuzzle_X_Coordinates = new ArrayList<>();
        myCAPTCHAPuzzle_Y_Coordinates = new ArrayList<>();
        keyboardControls = new KeyboardControls();
        myCaptchaPuzzle = new CAPTCHA();
        myCaptchaPuzzle.generatePuzzle();
        myCAPTCHAPuzzleImageArrayList = myCaptchaPuzzle.getMyCAPTCHAImageArrayList();
        
        mainMenuButton = new JButton("Main Menu");
        retryButton = new JButton("Retry");
        type_CAPTCHA_Button = new JButton("Type CAPTCHA");
        exitButton = new JButton("Exit");

        addKeyListener(keyboardControls);
        setLayout(null);

        startGame();

    }

    private void startGame() {
        
        gameIsRunning = true;

        generateCAPTCHAImageCoordinates();

        Timer timer = new Timer(NEW_FRAME_DELAY_MILLISECONDS, this);
        timer.start();

    }

    private void generateCAPTCHAImageCoordinates () {

        int CAPTCHA_Image_X_Coordinate = 0;
        int CAPTCHA_Image_Y_Coordinate = 0;
        boolean noSameCoordinates = true;

        for (int i = 0; i < myCAPTCHAPuzzleImageArrayList.size(); i++) {

            do {

                noSameCoordinates = true;

                CAPTCHA_Image_X_Coordinate = random.nextInt((CAPTCHASnakeGame.GAME_WIDTH / 2) / BLOCK_LENGTH) * BLOCK_LENGTH;
                CAPTCHA_Image_Y_Coordinate = random.nextInt(1, CAPTCHASnakeGame.GAME_HEIGHT / BLOCK_LENGTH) * BLOCK_LENGTH; //prev 1 row

                for (int j = 0; j < myCAPTCHAPuzzleImageArrayList.size(); j++) {

                    if (myCAPTCHAPuzzle_X_Coordinates.get(j) == CAPTCHA_Image_X_Coordinate && myCAPTCHAPuzzle_Y_Coordinates.get(j) == CAPTCHA_Image_Y_Coordinate) {

                        noSameCoordinates = false;
                        break;

                    }
                }

            } while (noSameCoordinates == false);

                myCAPTCHAPuzzle_X_Coordinates.add(CAPTCHA_Image_X_Coordinate);
                myCAPTCHAPuzzle_Y_Coordinates.add(CAPTCHA_Image_Y_Coordinate);

        }
    }

    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);

        if (gameIsRunning == false && score == myCAPTCHAPuzzleImageArrayList.size()) {

            drawVerificationSuccessScreen(g);

        } else if (gameIsRunning == false) {

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

            for (int i = 0; i < myCAPTCHAPuzzleImageArrayList.size(); i++) {

                g.drawImage(myCAPTCHAPuzzleImageArrayList.get(i), myCAPTCHAPuzzle_X_Coordinates.get(i), myCAPTCHAPuzzle_Y_Coordinates.get(i), null);
    
            }

            //right side of panel
            g.setColor(Color.BLACK);
            g.setFont(new Font("Courier", Font.ITALIC ,20));
            fontMetrics = getFontMetrics(g.getFont());

            g.drawString("Collect The Following CAPTCHA Symbols:", (CAPTCHASnakeGame.GAME_WIDTH - (CAPTCHASnakeGame.GAME_WIDTH / 2 / 2)) - (fontMetrics.stringWidth("Collect The Following CAPTCHA Symbols:") / 2), 100); //check

            for (int i = nrOf_CAPTCHA_Taken; i < myCAPTCHAPuzzleImageArrayList.size(); i++) {

                g.drawImage(myCAPTCHAPuzzleImageArrayList.get(i), (CAPTCHASnakeGame.GAME_WIDTH - (CAPTCHASnakeGame.GAME_WIDTH / 2 / 2)) - (35 * myCAPTCHAPuzzleImageArrayList.size() / 2) + (35 * i), 200, null);
                
            }

            g.drawString("Collected:", (CAPTCHASnakeGame.GAME_WIDTH - (CAPTCHASnakeGame.GAME_WIDTH / 2 / 2)) - (fontMetrics.stringWidth("Collected:") / 2), 300); //check

            if (nrOf_CAPTCHA_Taken == 0) {

                g.drawString("None:", (CAPTCHASnakeGame.GAME_WIDTH - (CAPTCHASnakeGame.GAME_WIDTH / 2 / 2)) - (fontMetrics.stringWidth("Collected") / 2) + 50, 300); // check

            } else {

                for (int i = 0; i < nrOf_CAPTCHA_Taken; i++) {

                    g.drawImage(myCAPTCHAPuzzleImageArrayList.get(i), (CAPTCHASnakeGame.GAME_WIDTH - (CAPTCHASnakeGame.GAME_WIDTH / 2 / 2)) - (35 * myCAPTCHAPuzzleImageArrayList.size() / 2) + (35 * i), 350, null);
    
                }

            }

            g.drawString("Time Remaining: " + (TIME_LIMIT - (elapsedTimeMilliseconds / 1000)) + "s", (CAPTCHASnakeGame.GAME_WIDTH - (CAPTCHASnakeGame.GAME_WIDTH / 2 / 2)) - (fontMetrics.stringWidth("Time Remaining: " + (TIME_LIMIT - (elapsedTimeMilliseconds / 1000)) + "s") / 2), 500); //check

    }

    private void drawVerificationSuccessScreen(Graphics g) {

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, CAPTCHASnakeGame.GAME_WIDTH, CAPTCHASnakeGame.GAME_HEIGHT);

        for (int i = 0; i < myCAPTCHAPuzzleImageArrayList.size(); i++){
            g.drawImage(myCAPTCHAPuzzleImageArrayList.get(i), (CAPTCHASnakeGame.GAME_WIDTH / 2) - (myCAPTCHAPuzzleImageArrayList.size() / 2) + (35 * i), 100, null);
        }
        
        g.setColor(Color.BLUE);
        // fontMetrics = getFontMetrics(g.getFont());

        g.drawString("Verification Complete", (CAPTCHASnakeGame.GAME_WIDTH / 2) - (fontMetrics.stringWidth("Verification Complete") / 2), 200);

        g.drawString("You Are Not A Robot!", (CAPTCHASnakeGame.GAME_WIDTH / 2) - (fontMetrics.stringWidth("You Are Not A Robot!") / 2), 300);

        g.drawString("Time Elapsed: " + (elapsedTimeMilliseconds / 1000) + "s", (CAPTCHASnakeGame.GAME_WIDTH / 2) - (fontMetrics.stringWidth("Time Elapsed: " + (elapsedTimeMilliseconds / 1000) + "s") / 2), 400);

        g.drawString("Game Size: " + myCAPTCHAPuzzleImageArrayList.size() + " Symbols", (CAPTCHASnakeGame.GAME_WIDTH / 2) - (fontMetrics.stringWidth("Game Size: " + myCAPTCHAPuzzleImageArrayList.size() + " Symbols") / 2), 500);

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
                new TypeCAPTCHAMenuFrame();


            }

        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private void move(){

    }

    private void checkLetter(){

    }

    private void checkCollisions(){

    }

    private void checkTime(){

    }

}