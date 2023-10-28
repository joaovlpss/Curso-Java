package sections_1_8.entities;
import java.util.Scanner;

public class codigo4_aula1_exercicios {

    public static void main(String[] args){

        int id;
        double horas,valorhora;

        Scanner sc = new Scanner(System.in);
            System.out.printf("Insira o ID do funcionario: ");
            id = sc.nextInt();
            System.out.println();

            System.out.printf("Insira o nro de horas trabalhadas: ");
            horas = sc.nextDouble();
            System.out.println();

            System.out.printf("Insira o salario/hora: ");
            valorhora = sc.nextDouble();

        sc.close();

        System.out.printf("O funcionario %d recebeu salario de U$ %.2f.", id, valorhora * horas);
    }
    
}
