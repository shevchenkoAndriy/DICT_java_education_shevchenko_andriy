package Hangman;

import java.util.*;

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

    public void start(){
        Scanner input = new Scanner(System.in);
        List<String> givenList = Arrays.asList("python", "java", "kotlin", "javascript");
        Random rand = new Random();
        String randomWord = givenList.get(rand.nextInt(givenList.size()));
        System.out.println(randomWord);
        showAnnouncement();
        System.out.print("Guess the word: > ");
        String userInput = input.nextLine().trim().toLowerCase();
        boolean isWin = Objects.equals(userInput, randomWord);
        showResultGame(isWin);

    }
}
