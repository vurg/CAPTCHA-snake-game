import java.util.ArrayList;

import javax.swing.JPanel;

import java.awt.Image;
import java.awt.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GamePanel extends JPanel implements ActionListener {

    private GameFrame gameFrame;
    private final int BLOCK_LENGTH = 35;
    private final int NEW_FRAME_DELAY = 200;
    
    private int nrOfSnakeBodyParts;
    private int nrOfApplesEaten;
    private char snakeMovingDirection;
    private boolean gameIsRunning;

    private Timer timer;
    private Random random;

    private int[] snake_X_Coordinates;
    private int[] snake_Y_Coordinates;
    private int[] myCAPTCHAPuzzle_X_Coordinates;
    private int[] myCAPTCHAPuzzle_Y_Coordinates;

    private KeyboardControls keyboardControls;
    private CAPTCHA myCaptchaPuzzle;
    private ArrayList<Image> myCAPTCHAPuzzleImageArrayList;

    private int score;

    private final int TIME_LIMIT = 60;

    private boolean isRobot;
    private int elapsedTime;

    GamePanel (GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }

    @Override //check 
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g){

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        repaint();
        
    }

    
}
