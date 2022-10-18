package ChatBot;

import java.util.Scanner;

public class ChatBot {
    String botName;
    int yearOfCreation;

    public ChatBot (String botName, int yearOfCreation){
        this.botName = botName;
        this.yearOfCreation = yearOfCreation;
    }
    public void sayHi(){
        System.out.printf("Hello! My name is %s\n", this.botName);
        System.out.printf("I was created in %d\n", this.yearOfCreation);
    }
    public void askName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, remind me your name.");
        String name = scanner.nextLine();
        if (name.length() < 2) {
            return;
        }
        System.out.printf("What a great name you have, %s", name);

    }
}
