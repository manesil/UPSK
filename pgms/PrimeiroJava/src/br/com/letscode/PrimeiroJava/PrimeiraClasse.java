package br.com.letscode.PrimeiroJava;

import java.util.Scanner;

public class PrimeiraClasse {

    public static void main(String[] args){
        int n;
        Scanner oNroTabuada = new Scanner(System.in);
        System.out.println("Informe número da tabuada: ");
        n=oNroTabuada.nextInt();
        tabuada(n);

    }

    public static void tabuada(int num){
        int soma, subtrai, multiplica;
        float divide;
        System.out.println("Tabuada de soma " + num);
        for (int i = 1; i < 10; i++) {
            soma = num + i;
            System.out.println(num + " + " + i + " = " + soma);
        }
        System.out.println(" ");
        System.out.println("Tabuada de subtrair " + num);
        for (int x = 1; x < 10; x++) {
            subtrai = num - x;
            System.out.println(num + " - " + x + " = " + subtrai);
        }
        System.out.println(" ");
        System.out.println("Tabuada de multiplicar " + num);
        for (int y = 1; y < 10; y++) {
            multiplica = num * y;
            System.out.println(num + " x " + y + " = " + multiplica);
        }
       System.out.println(" ");
        System.out.println("Tabuada de dividir " + num);
        for (int z = 1; z < 10; z++) {
            divide = (float) num / (float) z;
            System.out.println(num + " / " + z + " = " + divide);
        }
    }
}
