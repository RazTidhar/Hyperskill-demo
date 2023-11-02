package machine;

import java.util.Scanner;

public class CoffeeMachine {

    private int money = 550;
    private int water = 400;
    private int milk = 540;
    private int coffeeBeans = 120;
    private int cups = 9;

    private enum Coffee {
        ESPRESSO, LATTE, CAPPUCCINO
    }

    private enum UserOptions {
        ESPRESSO, LATTE, CAPPUCCINO
    }

    public CoffeeMachine() {
        this.coffeeBeans = 120;
        this.water = 400;
        this.milk = 540;
        this.coffeeBeans = 120;
        this.cups = 9;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public void addWater(int amount) {
        this.water += amount;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public void addMilk(int amount) {
        this.milk += amount;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public void setCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans = coffeeBeans;
    }

    public void addCoffeeBeans(int amount) {
        this.coffeeBeans += amount;
    }

    public int getCups() {
        return cups;
    }

    public void setCups(int cups) {
        this.cups = cups;
    }

    public void addCups(int amount) {
        this.cups += amount;
    }

    public String buyCoffee(String opt) {
        int water = this.water;
        int coffeeBeans = this.coffeeBeans;
        int money = this.money;
        int cups = this.cups;
        int milk = this.milk;

        switch (opt) {
            case "1" -> {
                water -= 250;
                coffeeBeans -= 16;
                money += 4;
                cups -= 1;

            }
            case "2" -> {
                water -= 350;
                coffeeBeans -= 20;
                milk -= 75;
                money += 7;
                cups -= 1;
            }
            case "3" -> {
                water -= 200;
                milk -= 100;
                coffeeBeans -= 12;
                money += 6;
                cups -= 1;
            }
        };

        if(water<0) return "Sorry, not enough water!";
        if(coffeeBeans<0) return "Sorry, not enough coffeeBeans!";
        if(milk<0) return "Sorry, not enough milk!";
        if(cups<0) return "Sorry, not enough cups!";

        this.milk = milk;
        this.water = water;
        this.coffeeBeans = coffeeBeans;
        this.money = money;
        this.cups = cups;
        return "I have enough resources, making you a coffee!";
    }

    private void printMachineStatus() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water%n", this.water);
        System.out.printf("%d ml of milk%n", this.milk);
        System.out.printf("%d g of coffee beans%n", this.coffeeBeans);
        System.out.printf("%d disposable cups%n", this.cups);
        System.out.printf("$%d of money%n", this.money);
    }

    public static void main(String[] args) {
        boolean stop = false;
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        while (!stop) {
            System.out.println("Write action (buy, fill, take, remaining, exit)");
            switch (scanner.nextLine()) {
                case "buy" -> {
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                    String s = scanner.nextLine();
                    if (s == "back") {
                        coffeeMachine.buyCoffee(s);
                    } else {
                        coffeeMachine.buyCoffee(s);
                    }
                }
                case "fill" -> {
                    System.out.println("Write how many ml of water you want to add:");
                    coffeeMachine.addWater(scanner.nextInt());
                    System.out.println("Write how many ml of milk you want to add:");
                    coffeeMachine.addMilk(scanner.nextInt());
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    coffeeMachine.addCoffeeBeans(scanner.nextInt());
                    System.out.println("Write how many disposable cups you want to add: ");
                    coffeeMachine.addCups(scanner.nextInt());
                }
                case "take" -> {
                    System.out.printf("I gave you %d$%n", coffeeMachine.getMoney());
                    coffeeMachine.setMoney(0);
                }
                case "remaining" -> {
                    coffeeMachine.printMachineStatus();
                }
                case "exit" -> stop = true;
            }
        }
    }

}
