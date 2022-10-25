package br.com.letscode.turmaitau.operacoes;

/*
    modificadores de acesso de classes
    default: dentro do pacote (operacoes)
    public: em qualquer parte do codigo
 */
public class Multiplicar {

    //variaveis

    public Multiplicar() {

    }

    /*
        modificadores de acesso de metodos
        default: dentro do pacote (operacoes)
        private: dentro da propria classe
        public: em qualquer parte do codigo
        protected: apenas funciona com herança
     */
    public void realizarOperacao(double numero1, double numero2) {

        System.out.printf("Resultado: %.2f x %.2f = %.2f %s \n", numero1, numero2, (numero1 * numero2), "!");

    }



}
