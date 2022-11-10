package CoffeeMachine;

import java.util.*;

public class CoffeeMachine {
    private int water;

    private int milk;

    private int grain;

    private int cups;

    private int money;

    private final Set<String> actions = Set.of("buy", "fill", "remaining", "take", "exit");

    public CoffeeMachine(int water, int milk, int grain, int cups, int money){
        this.water = water;
        this.milk = milk;
        this.grain = grain;
        this.cups = cups;
        this.money = money;
    }
    static class Coffee{
        private static final Map<String, Integer> espresso = Map.of(
                "water", 250,
                "grain", 16,
                "price", 4
        );

        private static final Map<String, Integer> latte = Map.of(
                "water", 350,
                "milk", 75,
                "grain", 20,
                "price", 7
        );

        private static final Map<String, Integer> cappuccino = Map.of(
                "water", 200,
                "milk", 100,
                "grain", 12,
                "price", 6
        );

        private static final Map<String, Map<String, Integer>> actions = Map.of(
                "1", espresso,
                "2", latte,
                "3", cappuccino);
    }

    private void showCurrentState(){
        System.out.printf("""
        The coffee machine has:
        %d of water
        %d of milk
        %d of coffee beans
        %d of disposable cups
        %d of money
        """,
                this.water,
                this.milk,
                this.grain,
                this.cups,
                this.money);
    }

    public void menu(){
        String action = selectActions("Write action" +
                " (buy, fill, take, remaining, exit): > ", this.actions);

        switch (action){
            case "buy" -> saleMode();
            case "fill" -> fillMode();
            case "take" -> takeMode();
            case "remaining" -> showCurrentState();
            case "exit" -> {
                return;
            }
        }
        menu();
    }

    private void takeMode() {
        System.out.printf("Success. Coffee machine gave %d money\n", this.money);
        this.money = 0;
    }

    private void fillMode() {
        this.water += correctInputInt("Write how many ml of water you want to add: > ");
        this.cups += correctInputInt("Write how many disposable coffee cups you want to add: > ");
        this.milk += correctInputInt("Write how many ml of milk you want to add: > ");
        this.grain += correctInputInt("Write how many grams of coffee beans you want to add: > ");
    }

    private void saleMode() {
        Set<String> actions = new HashSet<>(Coffee.actions.keySet());
        actions.add("back");
        String selectedActions = selectActions("""
                        What do you want to buy?
                        1 - espresso, 2 - latte, 3 - cappuccino,
                        back – to main menu: >\s""", actions
                );

        if (Objects.equals(selectedActions, "back")){
            return;
        }

        Map<String, Integer> selectedCoffee = Coffee.actions.get(selectedActions);

        if (!isExistIngredients(selectedCoffee)){
            return;
        }

        sellCoffee(selectedCoffee);
    }

    private boolean isExistIngredients(Map<String, Integer> needIngredients){

            if (this.water < needIngredients.get("water")) {
                System.out.println("Sorry, not enough water!");
                return false;
            } else if (this.grain < needIngredients.get("grain")) {
                System.out.println("Sorry, not enough grain!");
                return false;
            } else if (this.milk < needIngredients.getOrDefault("milk", 0)) {
                System.out.println("Sorry, not enough milk!");
                return false;
            } else if (this.cups < 1) {
                System.out.println("Sorry, not enough cups!");
                return false;
            }
            return true;
    }

    private void sellCoffee(Map<String, Integer> selectedCoffee){
        this.water -= selectedCoffee.get("water");
        this.milk -= selectedCoffee.getOrDefault("milk", 0);
        this.grain -= selectedCoffee.get("grain");
        this.money += selectedCoffee.get("price");
        this.cups -= 1;
        System.out.println("Success. Your coffee is ready!");
    }

    private int correctInputInt(String label){
        Scanner scanner = new Scanner(System.in);
        System.out.print(label);

        while (true) {
            try {
                return scanner.nextInt();
            }
            catch (java.util.InputMismatchException e) {
                scanner.next();
                System.out.print("Please input integer number > ");
            }
        }
    }

    private String selectActions(String label, Collection<String> actions){
        Scanner scanner = new Scanner(System.in);
        System.out.print(label);

        while (true){
            String selectedAction = scanner.nextLine();
            if (actions.contains(selectedAction)){
                return selectedAction;
            }
            else  {
                System.out.print("Please input correct actions > ");
            }
        }
    }
}
