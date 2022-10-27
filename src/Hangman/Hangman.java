package Hangman;

import java.util.*;

public class Hangman {
    private final Random rand = new Random();
    private final Scanner scanner = new Scanner(System.in);
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
    private String hideWord(String word, int numberOfVisible){
        char[] hidedLetters = new char[word.length() - numberOfVisible];
        Arrays.fill(hidedLetters, '-');
        return word.substring(0, numberOfVisible) + new String(hidedLetters);
    }

    private String generateRandomWord(List<String> wordList){
        return wordList.get(rand.nextInt(wordList.size()));
    }

    public void start(List<String> wordList){
        String randomWord = generateRandomWord(wordList);
        String wordWithPrompt = hideWord(randomWord, 2);
        showAnnouncement();
        System.out.printf("Guess the word %s: > ", wordWithPrompt);
        String userInput = scanner.nextLine().trim().toLowerCase();
        boolean isWin = Objects.equals(userInput, randomWord);
        showResultGame(isWin);

    }
}
