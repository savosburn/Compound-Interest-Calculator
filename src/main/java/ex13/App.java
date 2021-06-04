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
        int numYears = myApp.readYears();
        int numCompounds = myApp.readNumCompounds();

        // Calculations
        String investment = myApp.calculateInvestment(principal, rate, numYears, numCompounds);

        // Output
        String outputString = myApp.generateString(principal, rate, numYears, numCompounds, investment);
        myApp.output(outputString);

    }

    public double readPrincipal() {
        System.out.print("What is the principal amount? ");
        return in.nextDouble();
    }

    public double readRate() {
        System.out.print("What is the rate? ");
        return in.nextDouble() / 100;
    }

    public int readYears() {
        System.out.print("What is the number of years? ");
        return in.nextInt();
    }

    public int readNumCompounds() {
        System.out.print("What is the number of times the interest is compounded per year? ");
        return in.nextInt();
    }

    public String calculateInvestment(double principal, double rate, int numYears, int numCompounds){
        DecimalFormat df = new DecimalFormat("'$'#.##");
        return df.format(principal * Math.pow((1 + rate / numCompounds), (numCompounds * numYears)));
    }

    public String generateString(double principal, double rate, int numYears, int numCompounds, String investment) {
        return String.format("%d invested at %.1f%% for %d years compounded %d times per year is %s.",
                (int) principal, rate * 100, numYears, numCompounds, investment);
    }

    public void output(String outputString) {
        System.out.println(outputString);
    }
}
