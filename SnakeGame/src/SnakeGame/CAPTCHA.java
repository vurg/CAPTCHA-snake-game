package SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class CAPTCHA {
    public static final String UPPER_CASE= "ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ";
    public static final String LOWER_CASE= "abcdefghijklmnopqrstuvwxyzåäö";
    public static final String SWEDISH = "";
    //public static final String SWEDISH = "\u0305" + "\u0304" + "\u0326" + "\u0345" + "\u0344" + "\u0366";
    public static final String NUMBERS = "0123456789";

    int puzzleSize;
    boolean swedishAlphabet;
    ArrayList<String> myCAPTCHAPuzzle;
    ArrayList<Image> myCAPTCHAImage;
    Random random;

    public CAPTCHA(int numSymbols, boolean includeSwedishLetters){
        this.puzzleSize = numSymbols;
        this.swedishAlphabet = includeSwedishLetters;
        random = new Random();
        myCAPTCHAPuzzle = new ArrayList<>();
        myCAPTCHAImage = new ArrayList<>();
    }

    public ArrayList<Image> generatePuzzle(){
        String alphabet = UPPER_CASE + LOWER_CASE + NUMBERS;

        if (swedishAlphabet){
            alphabet = alphabet + SWEDISH;
        }

        for (int i=0; i < puzzleSize; i++){
            int randomInt = random.nextInt(0, alphabet.length());
            //char randomChar = alphabet.charAt(randomInt);
            String randomSymbol = String.valueOf(alphabet.charAt(randomInt));
            myCAPTCHAPuzzle.add(randomSymbol);
            System.out.println(myCAPTCHAPuzzle.get(i));

            String filePathModifier = "";
            if(UPPER_CASE.contains(myCAPTCHAPuzzle.get(i))){
                filePathModifier = "upperCase";
            }else if(LOWER_CASE.contains(myCAPTCHAPuzzle.get(i))){
                filePathModifier = "lowerCase";
            }else{
                filePathModifier = "numbers";
            }


            myCAPTCHAImage.add(new ImageIcon("CAPTCHA/" + filePathModifier + "/" + myCAPTCHAPuzzle.get(i) + ".png").getImage());
        }

        return myCAPTCHAImage;
    }
}
