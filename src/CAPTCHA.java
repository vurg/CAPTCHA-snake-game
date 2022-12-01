package CAPTCHASnakeGame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class CAPTCHA {
    public static final String UPPER_CASE= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String SWEDISH_UPPER_CASE= "ÅÄÖ";
    public static final String LOWER_CASE= "abcdefghijklmnopqrstuvwxyz";
    public static final String SWEDISH_LOWER_CASE= "åäö";
    public static final String NUMBERS = "0123456789";

    private String myCAPTCHAPuzzleString; //String representation of CAPTCHA puzzle eg. "Aö7u..."
    private ArrayList<String> myCAPTCHAPuzzleStringArrayList; //arraylist of string letters of CAPTCHA puzzle eg. (A, ö, 7, u, ...)
    private ArrayList<Image> myCAPTCHAImageArrayList; //arraylist of CAPTCHA Images corresponding to each letter eg. (A.png, ö.png, 7.png, ...)
    private ArrayList<String> filePaths; //Arraylist of file paths eg. (CAPTCHA/upperCase/A.png, CAPTCHA/lowerCase/ö.png, CAPTCHA/numbers/7.png, ...)
    private Random random;

    public CAPTCHA(){
        random = new Random();
        myCAPTCHAPuzzleStringArrayList = new ArrayList<>();
        myCAPTCHAImageArrayList = new ArrayList<>();
        filePaths = new ArrayList<>();
        myCAPTCHAPuzzleString = "";
    }

    //generatePuzzle() generates CAPTCHA puzzle according to user specifications
    public void generatePuzzle(){
        String alphabet = UPPER_CASE + LOWER_CASE + NUMBERS;

        //if user wants to include Swedish letters, we append the alphabet
        if (LanguageMenuPanel.getIncludeSwedishLetters()){
            alphabet = alphabet + SWEDISH_UPPER_CASE + SWEDISH_LOWER_CASE;
        }

        // the for loop generates a CAPTCHA puzzle of size specified by user
        for (int i=0; i < PuzzleSizeMenuPanel.getNrOfCAPTCHASymbols(); i++){
            while(myCAPTCHAPuzzleStringArrayList.size()<=i){
                //generate random character from specified alphabet incl. uppercase letters, lowercase letters, numbers
                int randomInt = random.nextInt(0, alphabet.length()-1);
                String randomSymbol = String.valueOf(alphabet.charAt(randomInt));

                //adds the randomly generated character to list if it is not already in list (no repeats allowed)
                if(!myCAPTCHAPuzzleStringArrayList.contains(randomSymbol)){
                    myCAPTCHAPuzzleStringArrayList.add(randomSymbol);
                    myCAPTCHAPuzzleString = myCAPTCHAPuzzleString + randomSymbol;
                }
            }

            //sets filepath folder based on type of letter
            String filePathModifier = "";
            if(UPPER_CASE.contains(myCAPTCHAPuzzleStringArrayList.get(i))){
                filePathModifier = "upperCase";
            }else if(LOWER_CASE.contains(myCAPTCHAPuzzleStringArrayList.get(i))){
                filePathModifier = "lowerCase";
            }else if(SWEDISH_UPPER_CASE.contains(myCAPTCHAPuzzleStringArrayList.get(i))){
                filePathModifier = "upperCase";
            }else if(SWEDISH_LOWER_CASE.contains(myCAPTCHAPuzzleStringArrayList.get(i))){
                filePathModifier = "lowerCase";
            }else{
                filePathModifier = "numbers";
            }

            //MyCAPTCHAImage is arraylist used to store the CAPTCHA images
            myCAPTCHAImageArrayList.add(new ImageIcon("CAPTCHA/" + filePathModifier + "/" + myCAPTCHAPuzzleStringArrayList.get(i) + ".png").getImage());
            //filePaths is used to store the filePaths in the directory
            filePaths.add("CAPTCHA/" + filePathModifier + "/" + myCAPTCHAPuzzleStringArrayList.get(i) + ".png");
        }
    }

    //getters
    public String getMyCAPTCHAPuzzleString(){
        return this.myCAPTCHAPuzzleString;
    }
    public ArrayList<String> getMyCAPTCHAPuzzleStringArrayList(){
        return this.myCAPTCHAPuzzleStringArrayList;
    }
    public ArrayList<Image> getMyCAPTCHAImageArrayList(){
        return this.myCAPTCHAImageArrayList;
    }
    public ArrayList<String> getFilePaths(){
        return this.filePaths;
    }

}
