package org.siit.homework.week6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Valid input eg: 100 cm + 20 mm + 10 km");
        System.out.print("Enter expression with spaces: ");
        String input = s.nextLine();
        String[] expression = input.split(" ");

        if (Calculator.calculateExpression(expression) != null) {
            System.out.println("Expression result: " + Calculator.calculateExpression(expression) + " mm");
        } else {
            System.out.println("Invalid expression!");
        }
    }
}
