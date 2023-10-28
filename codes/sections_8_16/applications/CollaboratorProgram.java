package sections_8_16.applications;

import sections_8_16.entities.Collaborator;
import sections_8_16.entities.util.ValidityCheck;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;

public class CollaboratorProgram {

    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        List<Collaborator> ls = new ArrayList<Collaborator>();

        System.out.print("How many employees need to be registered? ");
        int collaboratorsCount = ValidityCheck.getValueI(sc, "", 1, 1000); // Max of 1000 collaborators
        sc.nextLine();

        for (int i = 0; i < collaboratorsCount; i++) {
            System.out.println("Enter details for employee #" + (i + 1) + ":");
            
            int id = ValidityCheck.getValueI(sc, "Enter employee ID: ", 1, 999); // Ids go from 1 to 999
            sc.nextLine();
            
            System.out.print("Enter employee name: ");
            String name = sc.nextLine().trim();
            
            double salary = ValidityCheck.getValueI(sc, "Enter employee salary: ", 0.0, 1_000_000.0); // Max salary of 1 million
            sc.nextLine();

            ls.add(new Collaborator(id, name, salary));
        }

        for (Collaborator collaborator : ls) {
            System.out.println("=====================================");
            System.out.println("Employee #" + collaborator.getId());
            System.out.println("Name = " + collaborator.getName());
            System.out.println("Salary = " + collaborator.getBaseSalary());
        }

        sc.close();
    }
}

