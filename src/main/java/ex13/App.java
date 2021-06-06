/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Savannah Osburn
 */

package ex13;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();

        // Input
        double principal = myApp.readPrincipal();
        double rate = myApp.readRate();
        double numYears = myApp.readYears();
        double numCompounds = myApp.readNumCompounds();

        // Calculations
        String investment = myApp.calculateInvestment(principal, rate, numYears, numCompounds);

        // Output
        String outputString = myApp.generateString(principal, rate, numYears, numCompounds, investment);
        myApp.output(outputString);

    }

    public double readPrincipal() {
        System.out.print("What is the principal amount? ");

        // User can only enter number
        while (!in.hasNextDouble()) {
            System.out.print("Invalid amount. Enter again: ");
            in.next();
        }

        return in.nextDouble();
    }

    public double readRate() {
        System.out.print("What is the rate's percentage? (ex: 4.3) ");

        // User can only enter number
        while (!in.hasNextDouble()) {
            System.out.print("Invalid rate. Enter again: ");
            in.next();
        }

        return in.nextDouble() / 100;
    }

    public double readYears() {
        System.out.print("What is the number of years? ");

        // User can only enter number
        while (!in.hasNextDouble()) {
            System.out.print("Invalid number. Enter again: ");
            in.next();
        }

        return in.nextDouble();
    }

    public double readNumCompounds() {
        System.out.print("What is the number of times the interest is compounded per year? ");

        // User can only enter number
        while (!in.hasNextDouble()) {
            System.out.print("Invalid number. Enter again: ");
            in.next();
        }

        return in.nextDouble();
    }

    public String calculateInvestment(double principal, double rate, double numYears, double numCompounds){
        DecimalFormat df = new DecimalFormat("'$'#.##");
        return df.format(principal * Math.pow((1 + rate / numCompounds), (numCompounds * numYears)));
    }

    public String generateString(double principal, double rate, double numYears, double numCompounds, String investment) {
        int newCompounds, newYears, newPrincipal;

        String compounds = Double.toString(numCompounds);
        String years = Double.toString(numYears);
        String principalVal = Double.toString(principal);

        if (numCompounds % 1 == 0) {
            newCompounds = (int) numCompounds;
            compounds = String.format("%d", newCompounds);
        }

        if (numYears % 1 == 0) {
            newYears = (int) numYears;
            years = String.format("%d", newYears);
        }

        if (principal % 1 == 0) {
            newPrincipal = (int) principal;
            principalVal = String.format("%d", newPrincipal);
        }

        return String.format("%s invested at %.1f%% for %s years compounded %s times per year is %s.",
                principalVal, rate * 100, years, compounds, investment);
    }

    public void output(String outputString) {

        System.out.println(outputString);
    }
}
