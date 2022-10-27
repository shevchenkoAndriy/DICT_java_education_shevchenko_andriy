import Hangman.Hangman;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("python", "java", "kotlin", "javascript");
        Hangman hangman = new Hangman();
        hangman.start(wordList);
    }
}
