package CoffeeMachine;

import java.util.Map;
import java.util.Scanner;

public class CoffeeMachine {
    private final Map<String, Integer> ingredientsForOne = Map.of(
            "water", 200,
            "milk", 50,
            "coffee", 15
    );

    private final Scanner scanner = new Scanner(System.in);


    public void showSteps(){
        System.out.println("""
                Starting to make a coffee
                Grinding coffee beans
                Boiling water
                Mixing boiled water with crushed coffee beans
                Pouring coffee into the cup
                Pouring some milk into the cup
                Coffee is ready!""");
    }
    public void start(){

    int cups = correctInputInt("Write how many cups of coffee you will need: > ");

    System.out.printf("For %d cups of coffee you will need: \n", cups);

    ingredientsForOne.forEach((key, value) ->
            System.out.printf("%s : %d\n", key, value * cups));

    }
    private int correctInputInt(String label){
        System.out.print(label);

        while (true) {
            Scanner input = new Scanner(System.in);
            try {
                return input.nextInt();
            }
            catch (java.util.InputMismatchException e) {
                scanner.next();
                System.out.print("Please input integer number > ");
            }
        }
    }
}
