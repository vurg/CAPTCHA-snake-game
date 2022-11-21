package SnakeGame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener{
    static final int SCREEN_WIDTH = 1120;
    static final int SCREEN_HEIGHT = 700;
    static final int UNIT_SIZE = 35;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/(UNIT_SIZE*UNIT_SIZE);
    static final int DELAY = 100;
    final int[] x = new int[GAME_UNITS];
    final int[] y = new int[GAME_UNITS];
    int bodyParts = 6;
    int score;
    int[] appleX;
    int[] appleY;
    char direction = 'R';
    boolean running = false;
    boolean notRobot = false;
    Timer timer;
    Random random;
    //Image A;
    //Image B;

    CAPTCHA myPuzzle;
    ArrayList<Image> myCAPTCHAImage;


    GamePanel(int numSymbols, boolean includeSwedishLetters){
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.white);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        myPuzzle = new CAPTCHA(numSymbols, includeSwedishLetters);
        appleX = new int[numSymbols];
        appleY = new int[numSymbols];
        myCAPTCHAImage = myPuzzle.generatePuzzle();
        startGame();
    }
    public void startGame() {
        newCAPTCHA();
        score = 0;
        running = true;
        timer = new Timer(DELAY,this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g) {
            if (running) {
                g.setColor(Color.BLACK);
                g.fillRect(0,0,SCREEN_WIDTH, SCREEN_HEIGHT);

                for (int i = 0; i < bodyParts; i++) {
                    if (i == 0) {
                        g.setColor(Color.green);
                        g.fillOval(x[i], y[i], UNIT_SIZE, UNIT_SIZE);

                        if (direction == 'R') {
                            g.setColor(Color.red);
                            g.fillOval(x[i] + UNIT_SIZE / 2, y[i] + UNIT_SIZE / 4, UNIT_SIZE / 10, UNIT_SIZE / 10);
                            g.fillOval(x[i] + UNIT_SIZE / 2, y[i] + UNIT_SIZE / 4 * 3, UNIT_SIZE / 10, UNIT_SIZE / 10);
                            g.fillRect(x[i] + UNIT_SIZE / 4 * 3, y[i] + UNIT_SIZE / 2, UNIT_SIZE / 2, UNIT_SIZE / 4);
                        } else if (direction == 'D') {
                            g.setColor(Color.red);
                            g.fillOval(x[i] + UNIT_SIZE / 4, y[i] + UNIT_SIZE / 2, UNIT_SIZE / 8, UNIT_SIZE / 10);
                            g.fillOval(x[i] + UNIT_SIZE / 4 * 3, y[i] + UNIT_SIZE / 2, UNIT_SIZE / 8, UNIT_SIZE / 10);
                        } else if (direction == 'U') {
                            g.setColor(Color.red);
                            g.fillOval(x[i] + UNIT_SIZE / 4, y[i] + UNIT_SIZE / 2, UNIT_SIZE / 8, UNIT_SIZE / 10);
                            g.fillOval(x[i] + UNIT_SIZE / 4 * 3, y[i] + UNIT_SIZE / 2, UNIT_SIZE / 8, UNIT_SIZE / 10);
                        } else if (direction == 'L') {
                            g.setColor(Color.red);
                            g.fillOval(x[i] + UNIT_SIZE - UNIT_SIZE / 10 - UNIT_SIZE / 2, y[i] + UNIT_SIZE / 4, UNIT_SIZE / 10, UNIT_SIZE / 10);
                            g.fillOval(x[i] + UNIT_SIZE - UNIT_SIZE / 10 - UNIT_SIZE / 2, y[i] + UNIT_SIZE / 4 * 3, UNIT_SIZE / 10, UNIT_SIZE / 10);
                            g.fillRect(x[i] + UNIT_SIZE - UNIT_SIZE / 2 - UNIT_SIZE / 4 * 3, y[i] + UNIT_SIZE / 2, UNIT_SIZE / 2, UNIT_SIZE / 4);
                        }

                    } else {
                        g.setColor(new Color(45, 180, 0));
                        g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                    }
                }
                g.setColor(Color.red);
                g.setFont(new Font("SansSerif", Font.BOLD, 30));
                FontMetrics metrics = getFontMetrics(g.getFont());
                g.drawString("Score: " + score, 1170, g.getFont().getSize());
                g.setFont(new Font("SansSerif", Font.BOLD, 20));
                g.drawString("Your Puzzle: ", 1170, 70);

                // random sequence of images
                for (int i=score; i<myCAPTCHAImage.size(); i++){
                    Image myImg = myCAPTCHAImage.get(i);
                    g.drawImage(myImg, appleX[i], appleY[i], null);
                    g.drawImage(myImg, 1200 + myImg.getWidth(null)*i, 100, null);
                }


                /**
                for (int i=score; i<myCAPTCHAImage.size(); i++){
                    g.drawImage(myCAPTCHAImage.get(i), appleX[i], appleY[i], null);
                }

                for (int i=0; i<myCAPTCHAImage.size(); i++){
                    g.drawImage(myCAPTCHAImage.get(i), 1200 + myCAPTCHAImage.get(i).getWidth(null)*i, 100, null);
                }
                 **/

            } else if (running == false && notRobot == true){
                youAreNotARobot(g);
            }else{
                gameOver(g);
            }


    }
    public void newCAPTCHA(){

        int numCharacters = myCAPTCHAImage.size();
        for(int i=0; i<numCharacters; i++){
            appleX[i] = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
            appleY[i] = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
            //appleX[i] = random.nextInt(0, (int)(SCREEN_WIDTH/UNIT_SIZE/numCharacters*2*(i+1))*UNIT_SIZE);
            //if (i %2 == 0){
                //appleY[i] = random.nextInt(0, (int)(SCREEN_HEIGHT/UNIT_SIZE/2)*UNIT_SIZE);
            //}else{
                //appleY[i] = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE/2)*UNIT_SIZE +1, (int)(SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE);
            //}
        }
    }
    public void move(){
        for(int i = bodyParts;i>0;i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }

        switch(direction) {
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
        }
    }
    public void checkApple() {
        for(int i = score; i<myCAPTCHAImage.size(); i++){
            if((x[0] == appleX[score]) && (y[0] == appleY[score])) {
                bodyParts++;
                score++;
            }
        }
    }
    public void checkCollisions() {
        if (score == myCAPTCHAImage.size()){
            running = false;
            notRobot = true;
        }
        //checks if head collides with body
        for(int i = bodyParts;i>0;i--) {
            if((x[0] == x[i])&& (y[0] == y[i])) {
                running = false;
            }
        }
        //check if head touches left border
        if(x[0] < 0) {
            running = false;
        }
        //check if head touches right border
        if(x[0] > SCREEN_WIDTH) {
            running = false;
        }
        //check if head touches top border
        if(y[0] < 0) {
            running = false;
        }
        //check if head touches bottom border
        if(y[0] > SCREEN_HEIGHT) {
            running = false;
        }

        if(!running) {
            timer.stop();
        }
    }

    public void youAreNotARobot(Graphics g) {
        g.setColor(Color.red);
        g.setFont( new Font("SansSerif",Font.BOLD, 40));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Congratulations!", (SCREEN_WIDTH - metrics1.stringWidth("Congratulations!"))/2, g.getFont().getSize());
        //Game Over text
        g.setColor(Color.red);
        g.setFont( new Font("SansSerif",Font.BOLD, 75));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("You are not a robot.", (SCREEN_WIDTH - metrics2.stringWidth("You are not a robot."))/2, SCREEN_HEIGHT/2);
    }
    public void gameOver(Graphics g) {
        //Score
        g.setColor(Color.red);
        g.setFont( new Font("Ink Free",Font.BOLD, 40));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Score: "+ score, (SCREEN_WIDTH - metrics1.stringWidth("Score: "+ score))/2, g.getFont().getSize());
        //Game Over text
        g.setColor(Color.red);
        g.setFont( new Font("Ink Free",Font.BOLD, 75));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (SCREEN_WIDTH - metrics2.stringWidth("Game Over"))/2, SCREEN_HEIGHT/2);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(running) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if(direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(direction != 'U') {
                        direction = 'D';
                    }
                    break;
            }
        }
    }
}