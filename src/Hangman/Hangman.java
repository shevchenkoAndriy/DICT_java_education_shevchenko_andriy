package Hangman;

import java.util.Objects;
import java.util.Scanner;

public class Hangman {

    public void showAnnouncement(){
        System.out.println("HANGMAN");
    }
    private void showResultGame(Boolean isWin){
        if (isWin){
            System.out.println("You survived!");
        }
        else {
            System.out.println("You lost!");
        }
    }

    public void startSimpleMod(String guessWord){
        showAnnouncement();
        Scanner input = new Scanner(System.in);
        System.out.print("Guess the word: > ");
        String userInput = input.nextLine();
        boolean isWin = Objects.equals(guessWord, userInput);
        showResultGame(isWin);
    }
}
