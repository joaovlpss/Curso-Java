package exercises;
import java.util.Scanner;

public class codigo5_aula1_exercicios {

    public static void main(String[] args){
        int id1, id2, qtd1, qtd2;
        double val1, val2;

        Scanner sc = new Scanner(System.in);
            id1 = sc.nextInt();
            qtd1 = sc.nextInt();
            val1 = sc.nextDouble();

            sc.nextLine();

            id2 = sc.nextInt();
            qtd2 = sc.nextInt();
            val2 = sc.nextDouble();

        sc.close();

        double pagar = qtd1 * val1 + qtd2 * val2;

        System.out.printf("TOTAL A PAGAR PECA %d: R$ %.2f", id1, qtd1*val1);
        System.out.printf("TOTAL A PAGAR PECA %d: R$ %.2f", id2, qtd2*val2);
        System.out.printf("TOTAL A PAGAR: R$ %.2f", pagar);

    }
    
}
