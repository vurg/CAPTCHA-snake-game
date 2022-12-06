import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Image;
import java.awt.Graphics;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {

    private GameFrame gameFrame;
    private final int BLOCK_LENGTH = 25;
    private final int NEW_FRAME_DELAY = 200;
    
    private int nrOfSnakeBodyParts;
    private int nrOfApplesEaten;
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

    private int score;

    private final int TIME_LIMIT = 60;

    private boolean isRobot;
    private int elapsedTime;

    GamePanel (GameFrame gameFrame) {

        this.gameFrame = gameFrame;
        nrOfSnakeBodyParts = 6;
        snake_X_Coordinates = new int[625];
        snake_Y_Coordinates = new int[625];
        myCAPTCHAPuzzle_X_Coordinates = new ArrayList<>();
        myCAPTCHAPuzzle_Y_Coordinates = new ArrayList<>();
        keyboardControls = new KeyboardControls();
        addKeyListener(keyboardControls);
        myCaptchaPuzzle = new CAPTCHA();
        myCaptchaPuzzle.generatePuzzle();
        myCAPTCHAPuzzleImageArrayList = myCaptchaPuzzle.getMyCAPTCHAImageArrayList();

        startGame();

    }

    private void startGame() {
        
        gameIsRunning = true;

        generateCAPTCHAImageCoordinates();

        Timer timer = new Timer(NEW_FRAME_DELAY, this);
        timer.start();

    }

    private void generateCAPTCHAImageCoordinates () {

        int CAPTCHA_Image_X_Coordinate = 0;
        int CAPTCHA_Image_Y_Coordinate = 0;
        boolean noSameCoordinates = true;

        for (int i = 0; i < myCAPTCHAPuzzleImageArrayList.size(); i++) {

            do {

                noSameCoordinates = true;

                CAPTCHA_Image_X_Coordinate = random.nextInt(CAPTCHASnakeGame.GAME_HEIGHT / BLOCK_LENGTH) * BLOCK_LENGTH;
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
        draw(g);

    }

    private void draw(Graphics g){

        if (gameIsRunning){

            for (int i = 0; i < nrOfSnakeBodyParts; i++) {

                if (i == 0){
                  
                    g.setColor(Color.RED);
                    g.drawRect(snake_X_Coordinates[i], snake_Y_Coordinates[i], BLOCK_LENGTH, BLOCK_LENGTH);
    
                    if (snake_X_Coordinates[i] == snake_X_Coordinates[i+1] && snake_Y_Coordinates[i] == snake_Y_Coordinates[i+1]){
    
                        return;
    
                    }
    
                } else {
    
                    g.setColor(Color.GREEN);
                    g.drawRect(snake_X_Coordinates[i], snake_Y_Coordinates[i], BLOCK_LENGTH, BLOCK_LENGTH);
    
                }
    
            }

        } else {

            JButton mainManuButton = new JButton();
            JButton retryButton = new JButton();
            JButton type_CAPTCHA_Button = new JButton();

            mainManuButton.addActionListener(new ActionListener(){
                
                @Override
                public void actionPerformed(ActionEvent e) {

                }

            });

        }

    }

    private void youAreNot_A_Robot(){

    }

    private void gameOver(Graphics g){

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
