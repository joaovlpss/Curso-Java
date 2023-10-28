package sections_1_8.applications;
import java.util.Scanner;

import sections_1_8.entities.Student;

import java.util.Locale;

public class StudentProgram {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Student student = new Student();
        double g1, g2, g3;

        System.out.print("Insert student name: ");
        student.name = sc.nextLine();

        System.out.print("Insert student's grades: ");
        g1 = sc.nextDouble();
        g2 = sc.nextDouble();
        g3 = sc.nextDouble();

        student.setGrades(g1, g2, g3);
        student.determine();

        sc.close();
    }
}
