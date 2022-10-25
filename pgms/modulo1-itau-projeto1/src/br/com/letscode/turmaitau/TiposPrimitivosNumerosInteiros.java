package br.com.letscode.turmaitau;

public class TiposPrimitivosNumerosInteiros {
        /*
            soma +
            subtraçao -
            divisao /
            multiplicacao *
         */

    final static int NUMERO_INT = 5;
    final static String RESULTADO = "resultado da operacao ";

    public static void main(String[] args) {
        short variavelShort = 1;

        long numeroLong = 2;

        int divisao = (int)(NUMERO_INT / numeroLong);

        System.out.println(RESULTADO + "divisao = " + divisao);

        //NUMERO_INT = 10;

        somar((int)numeroLong, NUMERO_INT);


    }

    public static void somar(int var1, int var2) {
        int soma = var1 + var2 + NUMERO_INT;
        System.out.println(RESULTADO + "soma = " + soma);
    }

}
