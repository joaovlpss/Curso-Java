package sections_8_16.applications;

import sections_8_16.entities.JuridicPerson;
import sections_8_16.entities.PhysicalPerson;
import sections_8_16.entities.util.ValidityCheck;
import sections_8_16.entities.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Locale;

public class PersonProgram2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        List<Person> lsPeople = new ArrayList<Person>();

        int choice = 1;
        do{
            menu();
            choice = ValidityCheck.getValueI(sc, "", 1, 4);

            switch(choice){
                case 1:
                    promptForPerson(sc, lsPeople);
                    break;
                case 2:
                    for(Person person : lsPeople){
                        System.out.println("=============================");
                        System.out.println("PERSON NAME = " + person.getName());
                        System.out.println("PERSON ANNUAL INCOME = " + person.getAnnualIncome());
                        if (person instanceof PhysicalPerson){
                            PhysicalPerson pp = (PhysicalPerson) person; // Downcasting to PhysicalPerson
                            System.out.println("PERSON MEDICAL EXPENSES = " + pp.getHealthExpenses());
                        } else if (person instanceof JuridicPerson){
                            JuridicPerson jp = (JuridicPerson) person; // Downcasting to JuridicPerson
                            System.out.println("NUMBER OF EMPLOYEES = " + jp.getEmployeeCount());
                        }
                    }
                    System.out.println("==============================");
                    break;          
                case 3:
                    for(Person person : lsPeople){
                        System.out.println("==============================");
                        System.out.println("PERSON ANME = " + person.getName());
                        System.out.println("PERSON ANNUAL INCOME = " + person.getAnnualIncome());
                        System.out.println("PERSON TAXATION = " + person.taxes());
                        System.out.println("==============================");
                    }
                    break;
                case 4:
                    choice = -1;
                    break;
            }
        } while (choice >= 1 || choice <= 4 );

        sc.close();
    }

    public static void menu(){
        System.out.println();
        System.out.println("1 - REGISTER NEW PEOPLE");
        System.err.println("2 - LIST ALL PEOPLE.");
        System.out.println("3 - CALCULATE TAXES FOR ALL PEOPLE.");
        System.out.println("4 - EXIT.");
        System.out.print("PLEASE CHOOSE AN OPTION: ");
    }

    public static void promptForPerson(Scanner sc, List<Person> lsPeople){
        System.out.print("ENTER THE NUMBER OF PEOPLE: ");
        int peopleNumber = ValidityCheck.getValueI(sc, "", 1, 999);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < peopleNumber; i++){
            sb.append("ENTER PERSON #").append(i+1).append("'S NAME: ");
            System.out.print(sb.toString());
            String name = sc.nextLine();
            sb.setLength(0);

            sb.append("ENTER PERSON #").append(i+1).append("'S ANNUAL INCOME: ");
            System.out.print(sb.toString());
            double annualIncome = ValidityCheck.getValueI(sc, "", 0.00, Double.MAX_VALUE);
            sb.setLength(0);

            System.out.print("IS THE PERSON PHYSICAL OR JURIDIC? (P/J): ");
            char ch;
            do{
                ch = sc.next().charAt(0);
            } while (ch != 'p' && ch != 'P' && ch != 'j' && ch != 'J');

            if(ch ==  'P' || ch == 'p'){
                sb.append("ENTER PERSON #").append(i+1).append("'S MEDICAL EXPENSES, IF ANY: ");
                System.out.print(sb.toString());
                double medicalExpenses = ValidityCheck.getValueI(sc, "", 0.00, Double.MAX_VALUE);
                sb.setLength(0);

                lsPeople.add(new PhysicalPerson(medicalExpenses, annualIncome, name));
                System.out.println("PERSON REGISTERED SUCCESSFULLY.");
            }
            else{
                sb.append("ENTER PERSON #").append(i+1).append("'S NUMBER OF EMPLOYEES: ");
                System.out.print(sb.toString());
                int employeeNumber = ValidityCheck.getValueI(sc, "", 0, Integer.MAX_VALUE);
                sb.setLength(0);

                lsPeople.add(new JuridicPerson(name, annualIncome, employeeNumber));
                System.out.println("PERSON REGISTERED SUCCESSFULLY.");
            }
        }
    }

}
