package SnakeGame;

import java.awt.*;
import java.util.ArrayList;

public class MyMain {
    public static void main(String[] args) {
        CAPTCHA myPuzzle = new CAPTCHA(6, true);
        ArrayList<Image> myCAPTCHAImage = myPuzzle.generatePuzzle();
    }
}
