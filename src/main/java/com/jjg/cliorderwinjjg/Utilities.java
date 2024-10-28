/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jjg.cliorderwinjjg;

import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author [JJG]
 * @version 1.0
 */
public class Utilities {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED_ERROR = "\u001B[31m";
    public static final String ANSI_YELLOW_ANSWER = "\u001B[33m";
    public static final String ANSI_GREEN_DEFAULT = "\u001B[32m";
    public static final String ANSI_BOLD = "\u001B[1m";
    public static final String ANSI_BLINK = "\u001B[5m";

    public static void displayInfo() {
        Date date = new Date(System.currentTimeMillis());
        System.out.println(ANSI_GREEN_DEFAULT + "Welcome to the Application!" + ANSI_RESET);
        displayOS();
        System.out.println("Date and Time: " + date);
        System.out.println("Computer: JJG");
        System.out.println("User: juljimgar");
    }

    public static void displayMenu() {
        System.out.println(ANSI_GREEN_DEFAULT + "\nMenu:" + ANSI_RESET);
        System.out.println(ANSI_YELLOW_ANSWER + "1. Choose Takeaway or Restaurant" + ANSI_RESET);
        System.out.println(ANSI_YELLOW_ANSWER + "2. Set Table Number" + ANSI_RESET);
        System.out.println(ANSI_YELLOW_ANSWER + "3. Set Customer Name" + ANSI_RESET);
        System.out.println(ANSI_YELLOW_ANSWER + "4. Set Customer Email" + ANSI_RESET);
        System.out.println(ANSI_YELLOW_ANSWER + "5. Set Customer Comments" + ANSI_RESET);
        System.out.println(ANSI_YELLOW_ANSWER + "6. Set Grand Total" + ANSI_RESET);
        System.out.println(ANSI_YELLOW_ANSWER + "7. Set Payment Method" + ANSI_RESET);
        System.out.println(ANSI_YELLOW_ANSWER + "8. Set Tipping" + ANSI_RESET);
        System.out.println(ANSI_YELLOW_ANSWER + "9. Show Order Summary" + ANSI_RESET);
        System.out.println(ANSI_YELLOW_ANSWER + "10. Exit" + ANSI_RESET);
        System.out.print("Select an option: ");
    }

    public static void displayDeveloperInfo() {
        System.out.println(ANSI_BOLD + "Developer Name: Julian Jimenez Garcia" + ANSI_RESET);
        System.out.println("App Name: CliOrderLinuxJJG");
        System.out.println("Version: 1.0");
    }

    public static void displayOS() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            System.out.println("Operating System (OS): Microsoft Windows");
        } else if (os.contains("nix") || os.contains("nux")) {
            System.out.println(ANSI_GREEN_DEFAULT + "Operating System (OS): Linux or Unix" + ANSI_RESET);
        } else if (os.contains("mac")) {
            System.out.println("Operating System (OS): macOS");
        } else {
            System.out.println(ANSI_RED_ERROR + "Unknown OS." + ANSI_RESET);
        }
    }

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static void cleanScreen() {
        String os = System.getProperty("os.name").toLowerCase();
        try {
            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            } else {
                System.out.println(ANSI_RED_ERROR + "Screen clearing is not supported on this system." + ANSI_RESET);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void pause() {
        try {
            System.out.println(ANSI_BLINK + "LOADING..." + ANSI_RESET);
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void selectFood(Order order, Scanner scanner) {
        System.out.println("Select food (1 for Burger[5.99], 2 for Pizza[7.99], 3 for Salad[4.99]: ");
        int foodChoice = scanner.nextInt();
        scanner.nextLine(); 

        switch (foodChoice) {
            case 1:
                order.setFood(new Product("Burger", 5.99));
                break;
            case 2:
                order.setFood(new Product("Pizza", 7.99));
                break;
            case 3:
                order.setFood(new Product("Salad", 4.99));
                break;
            default:
                System.out.println(Utilities.ANSI_RED_ERROR + "Invalid choice" + Utilities.ANSI_RESET);
                selectFood(order, scanner);
                break;

        }
    }

    public static void selectDrink(Order order, Scanner scanner) {
        System.out.println("Select drink (1 for Water[1.00], 2 for Soda[1.50], 3 for Coffee[2.00]): ");
        int drinkChoice = scanner.nextInt();
        scanner.nextLine(); 

        switch (drinkChoice) {
            case 1:
                order.setDrink(new Product("Water", 1.00));
                break;
            case 2:
                order.setDrink(new Product("Soda", 1.50));
                break;
            case 3:
                order.setDrink(new Product("Coffee", 2.00));
                break;
            default:
                System.out.println(Utilities.ANSI_RED_ERROR + "Invalid choice" + Utilities.ANSI_RESET);
                selectDrink(order, scanner);
                break;
        }
    }
    
    

}
