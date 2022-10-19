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
        System.out.print("Please, remind me your name > ");
        String name = scanner.nextLine();
        if (name.length() < 2) {
            return;
        }
        System.out.printf("What a great name you have, %s\n", name);

    }
    private int correctInputInt(String label){
        int userInput;
        System.out.print(label);

        while (true) {
            Scanner input = new Scanner(System.in);
            try {
                userInput = input.nextInt();
                return userInput;
            }
            catch (java.util.InputMismatchException e) {
                System.out.print("Please input integer number > ");
            }
        }
    }
    private int calcUserAge(int remainder3, int remainder5, int remainder7 ){
        return (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;
    }
    public void guessUserAge(){
        System.out.println("Let me guess your age.");
        int remainder3 = correctInputInt("The remainder of the division for 3 > ");
        int remainder5 = correctInputInt("The remainder of the division for 5 > ");
        int remainder7 = correctInputInt("The remainder of the division for 7 > ");
        int userAge = calcUserAge(remainder3, remainder5, remainder7) ;
        System.out.printf("Your age is %s; that's a good time to start programming!", userAge);
    }
}
