package br.com.letscode.turmaitau.operacoes;

public class Tabuada {

    public void realizarOperacao(double multiplicando, double limiteMultiplicador) {

        var multiplicar = new Multiplicar();

        for (int i = 0; i <= limiteMultiplicador; i++) {
            multiplicar.realizarOperacao(multiplicando, i);
        }

        /*int i = 0;
        while (i <= limiteMultiplicador) {
            System.out.printf("Resultado: %.2f x %.2f = %.2f %s ", multiplicando, i, (multiplicando * i), "!");
            i++;
        }*/


    }

}
