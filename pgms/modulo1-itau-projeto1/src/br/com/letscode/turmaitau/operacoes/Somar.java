package br.com.letscode.turmaitau.operacoes;

public class Somar {

    public Somar() {
        System.out.println("Construtor da classe Somar");
    }

    public void realizarOperacao(double numero1, double numero2) {

        System.out.printf("Resultado: %.2f + %.2f = %.2f %s \n", numero1, numero2, (numero1 + numero2), "!");

    }

}
