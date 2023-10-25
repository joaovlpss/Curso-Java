package applications;
import java.util.Scanner;
import java.util.Locale;
import entities.Student;

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
