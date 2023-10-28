package sections_1_8.entities;
import java.util.Scanner;

public class codigo3_aula1_exercicios {

        public static void main(String[] args){

            double r;
            float pi = 3.14159f;
            Scanner sc = new Scanner(System.in);

                System.out.printf("Insira o raio: ");
                r = sc.nextDouble();

            sc.close();

            double radius = pi * Math.pow(r,2);

            System.out.printf("RAIO = %.4f", radius);
            
        }   
}
