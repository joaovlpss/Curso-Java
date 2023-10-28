package sections_1_8.applications;
import java.util.Scanner;

import sections_1_8.entities.Person2;

import java.util.Locale;

public class Person2Program {

    private static final char MALE = 'M';
    private static final char FEMALE = 'F';

    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter number of people: ");
        int peopleQuantity = sc.nextInt();
        Person2[] vect = new Person2[peopleQuantity];
        sc.nextLine();

        int femaleCount = 0;
        int maleCount = 0;

        for (int i = 0; i < vect.length; i++){
            double height = promptForDouble(sc, "Enter person number %d's height: ", i+1);
            char gender = promptForGender(sc, i+1);

            femaleCount += (gender == FEMALE) ? 1 : 0;
            maleCount += (gender == MALE) ? 1 : 0;

            vect[i] = new Person2(height, gender);
        }

        double highestHeight = Double.MIN_VALUE;
        double lowestHeight = Double.MAX_VALUE;
        double femaleHeightTotal = 0.00;
        double maleHeightTotal = 0.00;

        for (Person2 person : vect) {
            double height = person.getHeight();
            char gender = person.getGender();

            highestHeight = Math.max(highestHeight, height);
            lowestHeight = Math.min(lowestHeight, height);

            if (gender == FEMALE) {
                femaleHeightTotal += height;
            } else {
                maleHeightTotal += height;
            }
        }

        displayResults(highestHeight, lowestHeight, femaleHeightTotal / femaleCount, maleHeightTotal / maleCount, maleCount, femaleCount);
        sc.close();
    }

    private static double promptForDouble(Scanner sc, String message, int personNumber) {
        System.out.printf(message, personNumber);
        return sc.nextDouble();
    }

    private static char promptForGender(Scanner sc, int personNumber) {
        char gender;
        do {
            System.out.printf("Enter person number %d's gender (F/M): ", personNumber);
            gender = Character.toUpperCase(sc.next().charAt(0));
            if (gender != FEMALE && gender != MALE) {
                System.out.println("Invalid gender. Please enter F or M.");
            }
        } while (gender != FEMALE && gender != MALE);
        sc.nextLine();  // Consumir o line break que sobrou
        return gender;
    }

    private static void displayResults(double highestHeight, double lowestHeight, double avgFemaleHeight, double avgMaleHeight, int maleCount, int femaleCount) {
        System.out.printf("Highest height = %.2f%n", highestHeight);
        System.out.printf("Lowest height = %.2f%n", lowestHeight);
        System.out.printf("Average female height = %.2f%n", avgFemaleHeight);
        System.out.printf("Average male height = %.2f%n", avgMaleHeight);
        System.out.printf("Number of males = %d%n", maleCount);
        System.out.printf("Number of females = %d%n", femaleCount);
    }
}
