package entities.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class ValidityCheck {

    private ValidityCheck() {
        throw new AssertionError("Utility class should not be instantiated");
    }

    @FunctionalInterface
    interface IntRangeCheck {
        boolean isValid(int value, int min, int max);
    }

    @FunctionalInterface
    interface DoubleRangeCheck {
        boolean isValid(double value, double min, double max);
    }

    private static void displayErrorMessage(String type, double min, double max) {
        System.out.printf("Invalid %s. Please enter a number between %.2f and %.2f.\n", type, min, max);
    }

    public static int getIntValue(Scanner sc, String message, int min, int max, IntRangeCheck checker) {
        int i = Integer.MIN_VALUE;
        boolean validInput;
        do {
            System.out.print(message);
            validInput = true;
            try {
                i = sc.nextInt();
                if (!checker.isValid(i, min, max)) {
                    displayErrorMessage("integer", min, max);
                    validInput = false;
                }
            } catch (InputMismatchException e) {
                displayErrorMessage("integer", min, max);
                sc.next();  // Clear invalid input
                validInput = false;
            }
        } while (!validInput);
        return i;
    }

    public static double getDoubleValue(Scanner sc, String message, double min, double max, DoubleRangeCheck checker) {
        double d = Double.NEGATIVE_INFINITY;
        boolean validInput;
        do {
            System.out.print(message);
            validInput = true;
            try {
                d = sc.nextDouble();
                if (!checker.isValid(d, min, max)) {
                    displayErrorMessage("double", min, max);
                    validInput = false;
                }
            } catch (InputMismatchException e) {
                displayErrorMessage("double", min, max);
                sc.next();  // Clear invalid input
                validInput = false;
            }
        } while (!validInput);
        return d;
    }

    // Specific range-check methods for int
    public static int getValueI(Scanner sc, String message, int min, int max) {
        return getIntValue(sc, message, min, max, (value, minValue, maxValue) -> minValue <= value && maxValue >= value);
    }

    public static int getValueER(Scanner sc, String message, int min, int max) {
        return getIntValue(sc, message, min, max, (value, minValue, maxValue) -> minValue <= value && maxValue > value);
    }

    public static int getValueEL(Scanner sc, String message, int min, int max) {
        return getIntValue(sc, message, min, max, (value, minValue, maxValue) -> minValue < value && maxValue >= value);
    }

    public static int getValueE(Scanner sc, String message, int min, int max) {
    return getIntValue(sc, message, min, max, (value, minValue, maxValue) -> minValue < value && maxValue > value);
    }

    // Specific range-check methods for double
    public static double getValueI(Scanner sc, String message, double min, double max) {
        return getDoubleValue(sc, message, min, max, (value, minValue, maxValue) -> minValue <= value && maxValue >= value);
    }

    public static double getValueER(Scanner sc, String message, double min, double max) {
        return getDoubleValue(sc, message, min, max, (value, minValue, maxValue) -> minValue <= value && maxValue > value);
    }

    public static double getValueEL(Scanner sc, String message, double min, double max) {
        return getDoubleValue(sc, message, min, max, (value, minValue, maxValue) -> minValue < value && maxValue >= value);
    }

    public static double getValueE(Scanner sc, String message, double min, double max) {
        return getDoubleValue(sc, message, min, max, (value, minValue, maxValue) -> minValue < value && maxValue > value);
    }
}
