package org.siit.homework.week6;

public class Calculator {
    public static double cmToMm(Double cm) {
        return cm * 10;
    }

    public static double dmToMm(Double dm) {
        return cmToMm(dm * 10);
    }

    public static double mToMm(Double m) {
        return dmToMm(m * 10);
    }


    public static double kmToMm(Double km) {
        return km * 1000000;
    }

    public static double sum(String x, String y) {
        return Integer.getInteger(x) + Integer.getInteger(y);
    }

    public static Double convertedNumber(String value, String scale) {
        if (scale.equals("km")) {
            return kmToMm(Double.valueOf(value));
        } else if (scale.equals("m")) {
            return mToMm(Double.valueOf(value));
        } else if (scale.equals("dm")) {
            return dmToMm(Double.valueOf(value));
        } else if (scale.equals("cm")) {
            return cmToMm(Double.valueOf(value));
        } else if (scale.equals("mm")) {
            return Double.valueOf(value);
        } else {
            System.out.println("Invalid scale!");
            return null;
        }
    }

    public static Double calculateExpression(String[] expression) {
        if (expression.length > 1) {
            double result = 0;
            for (int i = 0; i < expression.length; i++) {
                if (i == 0) {
                    result += convertedNumber(expression[i], expression[i + 1]);
                }
                if (expression[i].equals("+")) {
                    result += convertedNumber(expression[i + 1], expression[i + 2]);

                } else if (expression[i].equals("-")) {
                    result -= convertedNumber(expression[i + 1], expression[i + 2]);
                }
            }
            return result;
        } else {
            System.out.println("Invalid expression");
            return null;
        }
    }

}

