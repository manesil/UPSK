package br.com.letscode.PrimeiroJava;

import java.util.Scanner;

public class Calcula {

    public static void main(String[] args){
        int m, n;
        Scanner oNroTabuada = new Scanner(System.in);
        System.out.println("Informe o primeiro número: ");
        m=oNroTabuada.nextInt();
        System.out.println("Informe o segundo número: ");
        n=oNroTabuada.nextInt();

        System.out.println("Calculando com os números '" + m + "' e '" + n +"'");
        CalculaSoma(m, n);
        CalculaSubstracao(m, n);
        CalculaMultiplicacao(m, n);
        CalculaDivisao(m, n);
    }

    public static void CalculaSoma(int numm, int numn){
        int soma;
        soma=numm+numn;
        System.out.println("A soma é " + soma);
    }
    public static void CalculaSubstracao(int numm, int numn){
        int subtrai;
        subtrai=numm-numn;
        System.out.println("A subtração é " + subtrai);
    }
    public static void CalculaMultiplicacao(int numm, int numn){
        int multiplica;
        multiplica=numm*numn;
        System.out.println("A multiplicação é " + multiplica);
    }
    public static void CalculaDivisao(int numm, int numn){
        float divide;
        divide=(float) numm/ (float) numn;
        System.out.println("A divisão é " + divide);
    }
}
