package br.com.upsk.chapametalica.um;

import java.util.Scanner;

public class ChapaMetalicaUm {

    static float[] linha = new float[]{20,0,0,0,0,20};
    static float[] coluna = new float[]{100,0,0,0,-3};
    static final float VALOR_ERRO = (float) 0.5;

    public static void main(String[] args) {

        obterTemperatura();

    }
    public static void obterTemperatura(){
        Scanner capturaTela = new Scanner(System.in);

        float mediaTemperaturas;
        float mediaTemperaturasAnt;

        int i=0, ii=5, j=0, jj=4;
        System.out.println("====================================================");
        System.out.println("Ponto central com a temperatura.: 0ºC");

        System.out.println("Inciando temperaturas linhas....: [" + i + "] " + linha[i]  + " e [" + ii + "] " + linha[ii]);
        System.out.println("Inciando temperaturas colunas...: [" + j + "] " + coluna[j] + " e [" + jj + "] " + coluna[jj] );
        mediaTemperaturas = (linha[i] + linha[ii]+coluna[j] + coluna[jj])/4;
        System.out.println("====================================================");
        System.out.println("Ponto central com a temperatura.: " + mediaTemperaturas);

        mediaTemperaturasAnt = mediaTemperaturas;
        while (i<5 && j<4)
        {
            i++;ii--;j++;jj--;
            System.out.println("----------------------------------------------------");
            linha[i] = Math.abs(linha[i] - mediaTemperaturas);
            linha[ii] = Math.abs(linha[i] - mediaTemperaturas);
            coluna[j] = Math.abs(linha[i] - mediaTemperaturas);
            coluna[jj] = Math.abs(linha[i] - mediaTemperaturas);
            mediaTemperaturas = (linha[i] + linha[ii]+coluna[j] + coluna[jj])/4;
            System.out.println("====================================================");
            System.out.println("Ponto central com a temperatura.: " + mediaTemperaturas);

            if (mediaTemperaturas > mediaTemperaturasAnt){
                System.out.println("erro acima do esperado..........: " + mediaTemperaturas + " > " + mediaTemperaturasAnt);
                System.out.println("Iterações realizadas...........: " + i);
            }
            else {
                System.out.println("erro dentro do esperado.........: " + mediaTemperaturas + " <= " + mediaTemperaturasAnt);
                System.out.println("Iterações realizadas...........: " + i);
            }
            mediaTemperaturasAnt = mediaTemperaturas;
        }
    }
}
