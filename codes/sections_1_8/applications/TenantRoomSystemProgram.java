package sections_1_8.applications;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

import sections_1_8.entities.Room;
import sections_1_8.entities.Tenant;

public class TenantRoomSystemProgram {

    public static void main(String[] args){
    Scanner sc = new Scanner(System.in).useLocale(Locale.US);
    
    int tenants = -1;
        do {
            System.out.print("Insert the number of tenants to rent to: ");
            if(sc.hasNextInt()) { // check if the next input is an integer
                tenants = sc.nextInt();
                sc.nextLine();
                if (tenants > 10 || tenants < 1) {
                    System.out.println("Invalid number of tenants. Please choose a number between 1 and 10.");
                    tenants = -1; // reset tenants to invalid
                }
            } else {
                System.out.println("Please input a valid number.");
                sc.nextLine(); // clear the invalid input
            }
        } while (tenants > 10 || tenants < 1);

    Tenant[] tvect = new Tenant[tenants];
    Room[] rvect = new Room[10];
    int[] chosenRooms = new int[10];

    // Populate all tenants, and their respective rooms.
    for (int i = 0; i < tvect.length; i++){
        System.out.printf("Insert tenant number %d's name: ", i+1);
        String name = sc.nextLine();

        int age = -1; // start with an invalid value
        do {
            System.out.printf("Insert tenant number %d's age: ", i+1);
            if(sc.hasNextInt()) { // check if the next input is an integer
                age = sc.nextInt();
                sc.nextLine();
                if (age < 10 || age > 100) {
                    System.out.println("Invalid age. Please input an age between 10 and 100.");
                    age = -1; // reset age to invalid
                }
            } else {
                System.out.println("Please input a valid numerical age.");
                sc.nextLine(); // clear the invalid input
            }
        } while (age < 10 || age > 100);

        String email;
        do {
            System.out.printf("Insert tenant number %d's e-mail: ", i+1);
            email = sc.nextLine();
            if (!isValidEmail(email)) {
                System.out.println("Invalid email format. Please input a valid email.");
            }
        } while (!isValidEmail(email));

        int chosenRoom = 0;
        do{
            System.out.printf("Insert tenant number %d's chosen room: ", i+1);
            chosenRoom = sc.nextInt();
            sc.nextLine();

            if(chosenRoom < 1 || chosenRoom > 10){
                System.out.println("Invalid room number.");
            }
            if(ispartof(chosenRoom, chosenRooms)){
                chosenRoom = 0; // reset chosenRoom to invalid
                System.out.println("Room already chosen.");
            }
        } while (chosenRoom > 10 || chosenRoom < 1);

        chosenRooms[i] = chosenRoom;

        rvect[i] = new Room(name, chosenRoom);
        rvect[i].calculateRent(age);
        tvect[i] = new Tenant(name, email, age, rvect[i]);
    }

    Arrays.sort(tvect, (a, b) -> Integer.compare(a.getTenantRoom().getRoomNumber(), b.getTenantRoom().getRoomNumber()));
    System.out.println("ALL TENANTS REPORT:");
    for (int i = 0; i < tvect.length; i++) {
        Room room = tvect[i].getTenantRoom();
        Tenant currTenant = tvect[i];
    
        System.out.printf("ROOM NUMBER: %d%n", room.getRoomNumber());
        System.out.printf("TENANT NAME: %s%n", currTenant.getTenantName());
        System.out.printf("TENANT AGE: %d%n", currTenant.getTenantAge());
        System.out.printf("TENANT E-MAIL: %s%n", currTenant.getTenantEmail());
        System.out.println("------------------------------");
    }
    

    sc.close();
    }

    public static boolean ispartof(int i, int[] vect){
        for(int j = 0; j < vect.length; j++){
            if (i == vect[j]){
                return true;
            }
        }
        return false;
    }   

    // Real-world scenarios would require stricter methods, of course.
    public static boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }
}
