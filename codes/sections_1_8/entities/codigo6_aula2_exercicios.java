package sections_1_8.entities;
import java.util.Scanner;

public class codigo6_aula2_exercicios {
    public static void main(String[] args){

        int entry;
        Scanner sc = new Scanner(System.in);

            entry = sc.nextInt();

        sc.close();

        if (entry < 1 || entry > 1000){
            System.out.println("Valor Invalido.");
        }
        else {
            int i;
            for (i = 1; i <= entry; i++) {
                if (i%2 == 0) {
                    continue;
                }
                else {
                    System.out.println(i);
                }
            }
        }
    }
}
