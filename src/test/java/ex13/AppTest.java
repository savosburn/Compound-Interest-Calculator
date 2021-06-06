/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Savannah Osburn
 */

package ex13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    public void output_example_output () {
        App myApp = new App();

        String investment = myApp.calculateInvestment(1500, .043, 6, 4);

        String expectedOutput = "1500 invested at 4.3% for 6 years compounded 4 times per year is $1938.84.";

        String actualOutput = myApp.generateString(1500, .043, 6, 4, investment);

        assertEquals(expectedOutput, actualOutput);
    }

}