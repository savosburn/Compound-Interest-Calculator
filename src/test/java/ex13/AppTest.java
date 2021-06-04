/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Savannah Osburn
 */

package ex13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    public void output_string_includes_inputs_and_calculations () {
        App myApp = new App();

        double principal = 1500;
        double rate = .043;
        int numYears = 6;
        int numCompounds = 4;
        double calculation = principal * Math.pow((1 + rate / numCompounds), (numCompounds * numYears));
        String investment = String.format("$%.2f", calculation);

        String expectedOutput = "1500 invested at 4.3% for 6 years compounded 4 times per year is $1938.84.";

        String actualOutput = myApp.generateString(principal, rate, numYears, numCompounds, investment);

    }

}