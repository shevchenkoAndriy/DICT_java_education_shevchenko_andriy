package Hangman;

import java.util.*;
import java.util.regex.Pattern;

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
    private String hideWord(String word){
        char[] hidedLetters = new char[word.length()];
        Arrays.fill(hidedLetters, '-');
        return new String(hidedLetters);
    }

    private String generateRandomWord(List<String> wordList){
        return wordList.get(rand.nextInt(wordList.size()));
    }

    private String openLetters(String hidedWord, String word, String letter){
        StringBuilder guessedWord = new StringBuilder();
        for (int i = 0; i < hidedWord.length(); i+=1){
            if (Objects.equals(letter, String.valueOf(word.charAt(i)))){
                guessedWord.append(letter);
            }
            else {
                guessedWord.append(hidedWord.charAt(i));
            }
        }
        return new String(guessedWord);
    }
    private boolean checkIsContinue(){
        System.out.print("Continue? y/n : ");
        String userInput = scanner.nextLine();
        if (userInput.equalsIgnoreCase("")){
            return true;
        } else if (userInput.equalsIgnoreCase("y")) {
            return true;
        } else if (userInput.equalsIgnoreCase("n")) {
            return false;
        } else {
            System.out.println("Incorrect answer");
            checkIsContinue();
            return false;
        }
    }
    private String correctInputLetter(){
        String userInput;
        while (true){
            userInput = scanner.nextLine().trim().toLowerCase();
            boolean correctLetter = Pattern.matches("[a-z]", userInput);
            if (!correctLetter){
                System.out.print("Please enter a lowercase English letter > ");
                continue;
            }

            if (userInput.length() == 1){
                return userInput;
            }
            else {
                System.out.print("Please enter a lowercase English letter > ");
            }
        }
    }

    public void start(List<String> wordList){
        int attempts = 8;
        boolean isWin;
        String word = generateRandomWord(wordList);
        String guessedWord = hideWord(word);
        Set<String> usedLetters = new HashSet<>();
        showAnnouncement();
        while (attempts > 0 && !guessedWord.equals(word)){
            System.out.println(attempts);
            System.out.printf("Guess the word %s: > ", guessedWord);
            String answer = correctInputLetter();
            if (usedLetters.contains(answer)) {
                System.out.println("You already used this letter");
            }
            else if (word.contains(answer)){
                guessedWord = openLetters(guessedWord, word, answer);
            }
            else {
                System.out.println("That letter doesn't appear in the word");
                attempts -= 1;
            }
            usedLetters.add(answer);
        }
        isWin = guessedWord.equals(word);
        showResultGame(isWin);
        boolean isContinue = checkIsContinue();
        if (isContinue){
            start(wordList);
        }
    }
}
