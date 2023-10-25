package exercises;
import java.util.Scanner;

public class codigo2_aula1_exercicios {

    public static void main(String[] args){
        
        int x;
        int y;

        Scanner sc = new Scanner(System.in);
        
            System.out.printf("Insira os numeros, separados por espaco: ");

            x = sc.nextInt();
            y = sc.nextInt();

        sc.close();

        int sum = x + y;

        System.out.printf("SOMA = %d", sum);
    }
    
}
