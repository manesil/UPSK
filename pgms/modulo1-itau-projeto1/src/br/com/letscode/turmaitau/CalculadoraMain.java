package br.com.letscode.turmaitau;

import br.com.letscode.turmaitau.operacoes.*;

import java.util.Scanner;

public class CalculadoraMain {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o primeiro numero: ");
        double numero1 = entrada.nextDouble();

        System.out.println("Digite o segundo numero: ");
        double numero2 = entrada.nextDouble();

        System.out.println("Digite a operaçao: ");
        System.out.println("+ somar; - subtrair; / dividir; x multiplicar; t tabuada");

        String operador = entrada.next();

        switch (operador) {
            case "+":
                Somar somar = new Somar();
                somar.realizarOperacao(numero1, numero2);
                break;
            case "-":
                new Subtrair().realizarOperacao(numero1, numero2);
                break;
            case "/":
                new Dividir().realizarOperacao(numero1, numero2);
                break;
            case "x":
                new Multiplicar().realizarOperacao(numero1, numero2);
                break;
            case "t":
                new Tabuada().realizarOperacao(numero1, numero2);
                break;
            default:
                System.out.printf("Operador invalido!!!");
                break;
        }

        /*if (operacao == 1) {
            System.out.printf("Resultado: %.2f + %.2f = %.2f %s ", numero1, numero2, (numero1 + numero2), "!");
        } else if (operacao == 2) {
            System.out.printf("Resultado: %.2f + %.2f = %.2f %s ", numero1, numero2, (numero1 - numero2), "!");
        } else if (operacao == 3) {
            System.out.printf("Resultado: %.2f / %.2f = %.2f %s ", numero1, numero2, (numero1 / numero2), "!");
        } else if (operacao == 4) {
            System.out.printf("Resultado: %.2f x %.2f = %.2f %s ", numero1, numero2, (numero1 * numero2), "!");
        }*/

    }

}
