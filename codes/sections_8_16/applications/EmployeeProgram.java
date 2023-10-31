package sections_8_16.applications;

import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import sections_8_16.entities.Employee;
import sections_8_16.entities.OutsourcedEmployee;
import sections_8_16.entities.util.ValidityCheck;

public class EmployeeProgram {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        StringBuilder sb = new StringBuilder();
        List<Employee> empList = new ArrayList<Employee>();

        System.out.print("Insert the number of employees: ");
        int count = ValidityCheck.getValueI(sc, "", 1, 999);

        int accumulator = 1;
        for(int i = 0; i < count; i++){
            sb.append("Insert employee #");
            sb.append(accumulator);
            sb.append("'s name: ");
            System.out.print(sb.toString());
            String name = sc.nextLine();
            sb.setLength(0);

            sb.append("Insert employee #");
            sb.append(accumulator);
            sb.append("'s hours worked: ");
            System.out.print(sb.toString());
            int hours = ValidityCheck.getValueI(sc, "", 1, 40); // Assuming business logic.
            sb.setLength(0);

            sb.append("Insert employee #");
            sb.append(accumulator);
            sb.append("'s value per hour: ");
            System.out.print(sb.toString());
            double hourlyRate = ValidityCheck.getValueI(sc, "", 1.00, 50.00); // Assuming business logic.
            sb.setLength(0);

            // Check if it's an Outsourced employee.
            // Since ValidityCheck doesn't have String checks, I had to do it manually.
            char isOutsourced;
            while (true) {
                sb.append("Is employee #");
                sb.append(accumulator);
                sb.append(" outsourced?(Y/N): ");
                System.out.print(sb.toString());
                String response = sc.nextLine().toUpperCase();
                sb.setLength(0);
        
                if (response.equals("Y") || response.equals("N")) {
                    isOutsourced = response.charAt(0);
                    break;
                }
        
                System.out.println("Invalid input! Please enter Y or N.");
            }
            
            // If it's outsourced, we need to check for additionalChage
            if (isOutsourced == 'Y') {
                sb.append("Insert employee #");
                sb.append(accumulator);
                sb.append("'s additional charge: ");
                System.out.print(sb.toString());
                double additionalCharge = ValidityCheck.getValueI(sc, "", 1.00, 1000.00); // Assuming a range here for example
                sb.setLength(0);
                
                OutsourcedEmployee outsourcedEmployee = new OutsourcedEmployee(name, hours, hourlyRate, additionalCharge);
                empList.add(outsourcedEmployee);
            } else {
                Employee employee = new Employee(name, hours, hourlyRate);
                empList.add(employee);
            }
            
            accumulator++;
        }

        System.out.println("EMPLOYEE INFORMATION:");
        System.out.println("=====================");
        for (Employee emp : empList) {
            sb.append("EMPLOYEE NAME = ").append(emp.getName()).append("\n");
            sb.append("HOURS WORKED = ").append(emp.getHours()).append("\n");
            sb.append("HOURLY RATE = ").append(emp.getValuePerHour()).append("\n");
            sb.append("SALARY = ").append(emp.payment()).append("\n");
        
            // Check if the employee is an instance of OutsourcedEmployee
            if (emp instanceof OutsourcedEmployee) {
                sb.append("OUTSOURCED\n");
            } else {
                sb.append("NOT OUTSOURCED\n");
            }
        
            sb.append("===========================\n");
        
            // Print the information and then reset the StringBuilder for the next iteration
            System.out.print(sb.toString());
            sb.setLength(0);
        }


        sc.close();
    }
}
