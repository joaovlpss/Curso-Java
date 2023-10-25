package applications;
import java.util.Scanner;
import entities.Horse;

public class HorseProgram {
    public static void main(String[] args){
        int choice;
        Scanner sc = new Scanner(System.in);
        Horse horse = new Horse(0, "none");
        do{
            choice = menu(sc);
            switch(choice){
                case 1:
                    if(horse.getName() != null){
                        System.out.print("Insert the horse's name: ");
                        String name = sc.nextLine();
                        horse.setName(name);

                        System.out.print("Insert the horse's age: ");
                        int age = sc.nextInt();
                        horse.setAge(age);
                        break;
                    }
                    else {
                        System.out.print("Horse already created.");
                        break;
                    }
                case 2:
                    System.out.printf("Horse's time galloped = %.2f hours%n", horse.getTimeGalloped());
                    break;
                case 3:
                    System.out.printf("Horse's distance galloped = %.2f kilometers%n", horse.getDistanceGalloped());
                    break;
                case 4:
                    System.out.printf("Insert distance to gallop, in kilometers: ");
                    double distance = sc.nextDouble();
                    System.out.printf("Insert time to gallop, in hours: ");
                    double time = sc.nextDouble();
                    horse.gallop(time, distance);
                    break;
            }
        } while (choice != 5);
        sc.close();
    }

    public static int menu(Scanner sc){

        System.out.println("Insert your choice:");
        System.out.println("1 - Create horse.");
        System.out.println("2 - Get time galloped.");
        System.out.println("3 - Get distance galloped.");
        System.out.println("4 - Gallop.");
        System.out.println("5 - Exit.");
        int choice = sc.nextInt();
        sc.nextLine(); 

        if (choice >= 1 && choice <= 5){ 
            return choice;
        }
        else {
            return -1;
        }
    }
}
