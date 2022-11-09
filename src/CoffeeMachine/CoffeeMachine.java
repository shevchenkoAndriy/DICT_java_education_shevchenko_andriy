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


    private void showSteps(){
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
        int maxCups = calcMaxCups();

        if (maxCups == cups){
            System.out.println("Yes, I can make that amount of coffee");
        } else if (maxCups > cups) {
            System.out.printf("Yes, I can make that amount of coffee and even %d more than that\n", maxCups - cups);
        }
        else {
            System.out.printf("No, I can make only %d cups of coffee.", cups);
            return;
        }
        showSteps();
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

    private int calcMaxCups(){
        int availableWater = correctInputInt("Write how many ml of water the coffee machine has: > ");
        int availableMilk = correctInputInt("Write how many ml of milk the coffee machine has: > ");
        int availableGrain = correctInputInt("Write how many grams of coffee beans the coffee machine has: > ");
        int maxCups = 0;
        while (true){
            if (availableWater < ingredientsForOne.get("water")){
                break;
            } else if (availableMilk < ingredientsForOne.get("milk")) {
                break;
            } else if (availableGrain < ingredientsForOne.get("coffee")) {
                break;
            }
            availableWater -= ingredientsForOne.get("water");
            availableMilk -= ingredientsForOne.get("milk");
            availableGrain -= ingredientsForOne.get("coffee");
            maxCups +=1;
        }
        return maxCups;

    }
}
