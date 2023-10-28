package sections_8_16.applications;
import sections_8_16.entities.Collaborator;
import sections_8_16.entities.Department;
import sections_8_16.entities.HourContract;
import sections_8_16.entities.enums.WorkerLevel;
import sections_8_16.entities.util.ValidityCheck;

import java.util.Scanner;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class CollaboratorProgram2 {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        List<Collaborator> ls = new ArrayList<Collaborator>();
        List<Department> lsDep = new ArrayList<Department>();
        int menuChoice = -1;

        do {
        menuChoice = menu(sc);
        switch (menuChoice) {
            case 1:
                if(lsDep.isEmpty()){
                    System.out.println("You need to add departments first!");
                    break;
                }
                promptForWorker(sc, lsDep, ls);
                break;
            case 2:
                allWorkersData(ls);
                break;
            case 3:
                registerNewContract(sc, ls);
                break;
            case 4:
                removeContract(sc, ls);
                break;
            case 5:
                createNewDepartment(lsDep, sc);
                break;
            case 6:
                removeDepartment(lsDep, sc);
                break;
        }} while (menuChoice != 7);
        sc.close(); 
    }


    public static int menu(Scanner sc){
        int choice = -1;
        do {
            System.out.println("============================");
            System.out.println("1 - Register a new worker.");
            System.out.println("2 - Check all workers' data.");
            System.out.println("3 - Register a new contract for a worker.");
            System.out.println("4 - Remove a contract from a worker.");
            System.out.println("5 - Register a new department.");
            System.out.println("6 - Remove a department.");
            System.out.println("7 - Exit.");
            System.out.println("============================");
            choice = ValidityCheck.getValueI(sc, "Insert your choice: ", 1, 7);
        } while (choice < 1 && choice > 6);

        return choice;
    }
    // Guides the user through the creation of a new Collaborator instance.
    public static void promptForWorker(Scanner sc, List<Department> lsDep, List<Collaborator> ls){
        // Prompts for worker name.
        System.out.print("Insert worker's name: ");
        String name = sc.nextLine().strip();
        // Prompts for ID. Will never receive an invalid input.
        int id = ValidityCheck.getValueI(sc, "Insert worker's id: ", 0, 999);
        // Prompts for salary. Will never receive an invalid input.
        double baseSalary = ValidityCheck.getValueI(sc, "Insert worker's base salary: ", 1000.00, 9999.99);

        // Prompts for seniority level. Will never receive an invalid input.
        System.out.println("1 - JUNIOR");
        System.out.println("2 - MID_LEVEL");
        System.out.println("3 - SENIOR");
        int levelChoice = ValidityCheck.getValueI(sc, "Choose worker level: ", 1, 3);
        WorkerLevel level;
        switch (levelChoice){ // Initializing level.
            case 1:
                level = WorkerLevel.JUNIOR;
                break;
            case 2:
                level = WorkerLevel.MID_LEVEL;
                break;
            case 3:
                level = WorkerLevel.SENIOR;
                break;
            default:
                throw new IllegalArgumentException("Unexpected level choice: " + levelChoice);
        }

        // Prompts for department. Loops until a valid input has been set.
        System.out.println("POSSIBLE DEPARTMENTS:");
        for(Department depart : lsDep){
            System.out.println(depart.getDepName());
        }
        Department dep = null;
        String depName;
        boolean found;
        System.out.print("Choose department (by name): ");
        do{
            depName = sc.nextLine();
            found = false;
            for (Department depart : lsDep){
                if (depart.getDepName().equals(depName)){
                    found = true;
                    dep = depart;
                    break;
                }
            }
            if (!found){
                System.out.print("Invalid department name! Try again: ");
            }
        } while (!found);
        
        // Creates the new collaborator instance.
        ls.add(new Collaborator(id , name, baseSalary, level, dep));
    }
    // Shows all Collaborator instance's data and currently active contracts.
    public static void allWorkersData(List<Collaborator> ls){
        int acc = 0;
        for (Collaborator collab : ls){
            System.out.println("WORKER #" + collab.getId());
            System.out.println("WORKER NAME = " + collab.getName());
            System.out.println("WORKER SENIORITY = " + collab.getWorkerLevel());
            System.out.println("WORKER BASE SALARY = " + collab.getBaseSalary());
            System.out.println("WORKER DEPARTMENT = " + collab.getDep());
            System.out.println("WORKER CONTRACTS:");
            for(HourContract cont : collab.getContracts()){
                acc++;
                System.out.printf("%t");
                System.out.println("CONTRACT #" + acc);
                System.out.printf("%t");
                System.out.println("CONTRACT DATE = " + cont.getDate());
                System.out.printf("%t");
                System.out.println("CONTRACT VALUE PER HOUR = " + cont.getValuePerHour());
                System.out.printf("%t");
                System.out.println("CONTRACT HOURS = " + cont.getHours());
                System.out.printf("%t");
                System.out.println("=========================");
            }
            System.out.println("=================================================");
        }
    }
    // Creates new department instance, if not already in lsDep.
    public static void createNewDepartment(List<Department> lsDep, Scanner sc){
        System.out.print("Insert deparment name: ");
        String depName = sc.nextLine();

        boolean isCopy = false;
        for(Department i : lsDep){
            if (i.getDepName().equals(depName)){
                isCopy = true;
            }
        }
        if(isCopy){
            System.out.println("Department already added.");
        }
        else{
            lsDep.add(new Department(depName));
            System.out.println("Department Added Successfully!");
        }
    }
    // Removes department instance, if found in lsDep.
    public static void removeDepartment(List<Department> lsDep, Scanner sc){
        System.out.println("DEPARTMENTS:");
        for(Department i : lsDep){
            System.out.println(i.getDepName());
        }
        System.out.print("Insert department to be removed: ");
        String depName = sc.nextLine();
        boolean removed = false;
        for(Department i : lsDep){
            if(i.getDepName().equals(depName)){
                lsDep.remove(i);
                removed = true;
            }
        }
        String msg = removed ? "Department removed successfully" : "Couldn't find department. Try again.";
        System.err.println(msg);
    }

    // Register a new contract for a worker.
    public static void registerNewContract(Scanner sc, List<Collaborator> ls) {
        System.out.print("Insert worker's id for contract registration: ");
        int id = sc.nextInt();
        sc.nextLine();  // Consume the newline character

        Collaborator collab = findCollaboratorById(id, ls);

        if (collab == null) {
            System.out.println("No worker found with this ID!");
            return;
        }

        System.out.print("Insert contract date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(sc.nextLine().strip());

        System.out.print("Insert contract hourly rate: ");
        double rate = ValidityCheck.getValueI(sc, "Insert contract hourly rate: ", 1.00, 9999.99);

        System.out.print("Insert contract hours: ");
        int hours = ValidityCheck.getValueI(sc, "Insert contract hours: ", 1, 200);

        HourContract newContract = new HourContract(date, rate, hours);
        collab.addContract(newContract);

        double income = collab.income(date.getYear(), date.getMonthValue());
        System.out.println("INCOME FROM CONTRACT = " + income);
    }

    // Remove a contract from a worker.
    public static void removeContract(Scanner sc, List<Collaborator> ls) {
        System.out.print("Insert worker's id for contract removal: ");
        int id = sc.nextInt();
        sc.nextLine();  // Consume the newline character

        Collaborator collab = findCollaboratorById(id, ls);

        if (collab == null) {
            System.out.println("No worker found with this ID!");
            return;
        }

        List<HourContract> contracts = collab.getContracts();

        if (contracts.isEmpty()) {
            System.out.println("This worker has no contracts!");
            return;
        }

        for (int i = 0; i < contracts.size(); i++) {
            HourContract contract = contracts.get(i);
            System.out.println((i + 1) + ": Date: " + contract.getDate() + ", Value per Hour: " + contract.getValuePerHour() + ", Hours: " + contract.getHours());
        }

        System.out.print("Pick a number to remove the corresponding contract: ");
        int contractChoice = sc.nextInt();

        if (contractChoice >= 1 && contractChoice <= contracts.size()) {
            contracts.remove(contractChoice - 1);
            System.out.println("Contract removed successfully!");
        } else {
            System.out.println("Invalid choice!");
        }
    }

    // Utility function to find a Collaborator by their ID in the list.
    private static Collaborator findCollaboratorById(int id, List<Collaborator> ls) {
        for (Collaborator collab : ls) {
            if (collab.getId() == id) {
                return collab;
            }
        }
        return null;
    }

}
