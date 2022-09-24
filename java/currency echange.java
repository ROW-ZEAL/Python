/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package currency_exchange;

import java.util.Scanner;

public class Currency_exchange {

    public static void main(String[] args) {
        Currency.exchangeMoney();
    }
}

class Currency {

    public static void exchangeMoney() {
        String Yes_or_no;
        do {
            double ruppesRate_of_dollar = 125;
            System.out.print("Todays Rate is 1$ = 126.49 Rs.\n ");
            System.out.println("USD        NPR          ");
            System.out.println("=========================");
            System.out.println("100      12575.47        ");
            System.out.println("200      25150.94        ");
            System.out.println("300      37726.41        ");
            System.out.println("400      50301.88       ");
            System.out.println("500      62877.35        ");
            System.out.println("600      75452.76        ");
            System.out.println("700      88028.29        ");
            System.out.println("800      100603.76       ");
            System.out.println("900      113179.23       ");
            System.out.print("What do you want to exchange  do press \n 1.Dollar to Nepali \n 2.Nepali to Dollar \n ");
            System.out.print("Enter 1 or 2 : ");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("You are converting dollar to Rs.\n");
                    System.out.println("How many dollar do you want to exchange");
                    double dollar = input.nextDouble();
                    System.out.println("=======================");
                    System.out.println(dollar + " dollar  = " + dollar * ruppesRate_of_dollar + " Rs.");
                    System.out.println("=======================");
                }
                case 2 -> {
                    System.out.print("You are converting Rs to dollar\n");
                    System.out.println("How many Rs. do you want to exchange");
                    double rupees = input.nextDouble();
                    System.out.println("=======================");
                    System.out.println(rupees + " Rs  = " + Double.toString(rupees / ruppesRate_of_dollar) + " dollar");
                    System.out.println("=======================");
                }
                default ->
                    System.out.println("You did not enter 1 or 2");
            }
            System.out.println("Type yes for continue and NO for exit");
            input.nextLine();
            Yes_or_no = input.nextLine();

        } while (Yes_or_no.equals("yes"));
        System.out.println("Thank you for your exchange");
    }
}
