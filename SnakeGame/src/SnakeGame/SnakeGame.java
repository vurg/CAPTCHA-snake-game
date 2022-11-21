package SnakeGame;

import java.util.Scanner;

public class SnakeGame {

    public static void main(String[] args) {
        int numSymbols = 6;
        boolean includeSwedishLetters = true;

        new GameFrame(numSymbols, includeSwedishLetters);
    }
}



/**
 String selection = "";

 Scanner input = new Scanner(System.in);

 System.out.println("Welcome to the CAPTCHA snake game!");
 System.out.println();
 System.out.println("Would you like to customize the game? Y/N");
 selection = input.nextLine();

 if (selection.equals("Y")){
 System.out.println("How many CAPTCHA symbols? (range: 4-8)");
 numSymbols = input.nextInt();
 System.out.println("Would you like to include Swedish letters? (Y/N)");
 if(input.nextLine().equals("Y")){
 includeSwedishLetters = true;
 }else{
 includeSwedishLetters = false;
 }
 }


 input.close();
 **/
