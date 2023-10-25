package applications;

import java.util.Scanner;
import java.util.Locale;
import entities.Person;

public class PersonProgram {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        Locale.setDefault(Locale.US);

        System.out.print("How many people will you enter? ");
        int numberOfPeople = sc.nextInt();
        sc.nextLine(); 

        Person[] vect = new Person[numberOfPeople];

        for (int i = 0; i < vect.length; i++){
            System.out.printf("Insert the name of person number %d: ", i+1);
            String name = sc.nextLine();

            System.out.printf("Insert person number %d's age: ", i+1);
            int age = sc.nextInt();
            sc.nextLine(); 

            System.out.printf("Insert person number %d's height: ", i+1);
            double height = sc.nextDouble();
            sc.nextLine();

            vect[i] = new Person(height, age, name);
        }

        sc.close();

        double avgHeight = 0.00;
        int lessThan16 = 0;
        
        for (int i = 0; i < vect.length; i++){
            avgHeight += (vect[i].getHeight());
            if (vect[i].getAge() < 16){
                lessThan16++;
            }
        }
        avgHeight /= vect.length;

        double lessThan16Percentage = (100.0 * lessThan16) / vect.length;
        System.out.printf("Average height = %.2f%n", avgHeight);
        System.out.printf("Percentage of people less than 16 years old: %.2f%%\n", lessThan16Percentage);
        for (int i = 0; i < vect.length; i++){
            if (vect[i].getAge() < 16){
                System.out.println(vect[i].getName());
            }
        }
    }
}
