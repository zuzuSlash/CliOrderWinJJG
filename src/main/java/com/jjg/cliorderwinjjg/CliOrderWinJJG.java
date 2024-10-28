package com.jjg.cliorderwinjjg;

import java.util.Scanner;

/**
 * @author [JJG]
 * @version 1.0
 */
public class CliOrderWinJJG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();
        boolean running = true;
        Utilities.cleanScreen();
        Utilities.pause();
        Utilities.cleanScreen();
        Utilities.displayInfo();

        String choiceInput;
        do {
            Utilities.displayMenu();
            choiceInput = scanner.nextLine().toLowerCase();

            if ("x".equals(choiceInput)) {
                Utilities.cleanScreen();
                System.out.println(Utilities.ANSI_GREEN_DEFAULT + "Thank you for using this application!" + Utilities.ANSI_RESET);
                running = false;
                break;
            }
            if ("a".equals(choiceInput)) {
                Utilities.displayDeveloperInfo();
                continue;
            }

            int choice;
            try {
                choice = Integer.parseInt(choiceInput);
            } catch (NumberFormatException e) {
                System.out.println(Utilities.ANSI_RED_ERROR + "Invalid input. Please enter a number." + Utilities.ANSI_RESET);
                continue;
            }

            running = processMenuChoice(order, choice, scanner);
        } while (running);

        scanner.close();
    }


    private static boolean processMenuChoice(Order order, int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                System.out.print(Utilities.ANSI_YELLOW_ANSWER + "Takeaway or restaurant (1 for takeaway, 2 for restaurant): " + Utilities.ANSI_RESET);
                int takeOrRest = scanner.nextInt();
                order.setTakeOrRest(takeOrRest);
                scanner.nextLine();

                Utilities.selectFood(order, scanner);
                Utilities.selectDrink(order, scanner);

                if (takeOrRest == 1) {
                    order.setTableNumber(0);
                    System.out.println(Utilities.ANSI_RED_ERROR + "You cannot choose a table for takeaway orders." + Utilities.ANSI_RESET);
                } else {
                    System.out.print(Utilities.ANSI_YELLOW_ANSWER + "Enter table number: " + Utilities.ANSI_RESET);
                    order.setTableNumber(scanner.nextInt());
                    scanner.nextLine();
                }
                break;
            case 2:
                if (order.getTakeOrRest() == 1) {
                    System.out.println(Utilities.ANSI_RED_ERROR + "You cannot choose a table for takeaway orders." + Utilities.ANSI_RESET);
                } else {
                    System.out.print(Utilities.ANSI_YELLOW_ANSWER + "Enter table number (for restaurant): " + Utilities.ANSI_RESET);
                    int tableNumber = scanner.nextInt();
                    order.setTableNumber(tableNumber);
                    scanner.nextLine();
                }
                break;
            case 3:
                System.out.print(Utilities.ANSI_YELLOW_ANSWER + "Enter customer name: " + Utilities.ANSI_RESET);
                order.setName(scanner.nextLine());
                break;
            case 4:
                System.out.print(Utilities.ANSI_YELLOW_ANSWER + "Enter customer email: " + Utilities.ANSI_RESET);
                String email = scanner.nextLine();
                if (Utilities.isValidEmail(email)) {
                    order.setEmail(email);
                } else {
                    System.out.println(Utilities.ANSI_RED_ERROR + "Invalid email format." + Utilities.ANSI_RESET);
                }
                break;
            case 5:
                System.out.print(Utilities.ANSI_YELLOW_ANSWER + "Enter comments: " + Utilities.ANSI_RESET);
                order.setComments(scanner.nextLine());
                break;
            case 6:
                double totalWithoutTip = order.calculateTotalwithoutTip();
                order.setGrandTotal(totalWithoutTip);
                System.out.print(Utilities.ANSI_YELLOW_ANSWER + "Grand total without tip: " + totalWithoutTip + Utilities.ANSI_RESET);
                break;
            case 7:
                System.out.print(Utilities.ANSI_YELLOW_ANSWER + "Enter payment method (1 for cash, 2 for card): " + Utilities.ANSI_RESET);
                order.setPaymentMethod(scanner.nextInt());
                scanner.nextLine();
                break;
            case 8:
                System.out.print(Utilities.ANSI_YELLOW_ANSWER + "Enter tipping amount: 5%, 10%, 15%, 20% or none[0]: " + Utilities.ANSI_RESET);
                order.setTipping(scanner.nextInt());
                scanner.nextInt();
                break;
            case 9:
                System.out.println(Utilities.ANSI_YELLOW_ANSWER + order + Utilities.ANSI_RESET);
                break;
            case 10:
                System.out.println(Utilities.ANSI_RED_ERROR + "Exiting..." + Utilities.ANSI_RESET);
                return false;
            default:
                System.out.println(Utilities.ANSI_RED_ERROR + "Invalid option. Try again." + Utilities.ANSI_RESET);
        }
        return true;
    }
}

