/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.jjg.cliorderwinjjg;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author [JJG]
 * @version 1.0
 */
public class Order {

    private String name;
    private String email;
    private String comments;
    private int tableNumber;
    private int takeOrRest;
    private double grandTotal;
    private int paymentMethod;
    private int tipping;
    private String request;
    private Product food;
    private Product drink;

    public Order() {
        takeOrRest = 0;
        tableNumber = 0;
        name = "";
        email = "";
        comments = "";
        grandTotal = 0.0;
        paymentMethod = 0;
        tipping = 0;
        request = "no";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getTakeOrRest() {
        return takeOrRest;
    }

    public void setTakeOrRest(int takeOrRest) {
        this.takeOrRest = takeOrRest;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public int getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getTipping() {
        return tipping;
    }

    public void setTipping(int tipping) {
        this.tipping = tipping;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public Product getFood() {
        return food;
    }

    public void setFood(Product food) {
        this.food = food;
    }

    public Product getDrink() {
        return drink;
    }

    public void setDrink(Product drink) {
        this.drink = drink;
    }

    public double calculateTotal() {
        double total = grandTotal;

        if (food != null) {
            total += food.getPrice();
        }
        if (drink != null) {
            total += drink.getPrice();
        }
        if (tipping > 0) {
            total += (total * tipping / 100);
        }

        return total;
    }

    public double calculateTotalwithoutTip() {
        double total = grandTotal;

        if (food != null) {
            total += food.getPrice();
        }
        if (drink != null) {
            total += drink.getPrice();
        }

        return total;
    }

    @Override
    public String toString() {
        String foodName = "None";
        String drinkName = "None";

        if (food != null) {
            foodName = food.getName();
        }

        if (drink != null) {
            drinkName = drink.getName();
        }

        return "Order Details:\n"
                + "Name: " + name + "\n"
                + "Email: " + email + "\n"
                + "Comments: " + comments + "\n"
                + "Table Number: " + tableNumber + "\n"
                + "Takeaway[1]/Restauran[2]: " + takeOrRest + "\n"
                + "Grand Total: " + grandTotal + "\n"
                + "Payment Method cash[1]/card[2]: " + paymentMethod + "\n"
                + "Tipping: " + tipping + "\n"
                + "Food: " + foodName + "\n"
                + "Drink: " + drinkName + "\n" 
                +"Total with Tipping: " + calculateTotal() + "\n";
    }

}
