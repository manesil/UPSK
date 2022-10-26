package br.com.upsk.chapametalica.tres;

import java.util.Scanner;

public class ChapaMetalicaTres {

        public static void main(String[] args) {

            obterTemperatura();

        }
        public static void obterTemperatura(){
            Scanner capturaTela = new Scanner(System.in);
            int totLinha, totColuna, totMaxInter, maxCsDec;
            float tempLinha1, tempLinhaUltima, tempCol1, tempColUltima, maxErro;
            float mediaTemperaturas;
            float mediaTemperaturasAnt;

            System.out.println("Digite a quantidade de Linhas e Colunas da chapa (separe os números por espaço)?");
            totLinha = capturaTela.nextInt();
            totColuna = capturaTela.nextInt();

            System.out.println("Digite as temperaturas das Linhas e Colunas da chapa (separe os números por espaço)?");
            tempLinha1 = capturaTela.nextFloat();
            tempLinhaUltima = capturaTela.nextFloat();
            tempCol1 = capturaTela.nextFloat();
            tempColUltima = capturaTela.nextFloat();

            System.out.println("Digite o número máximo de iterações?");
            totMaxInter = capturaTela.nextInt();

            System.out.println("Digite o erro máximo?");
            maxErro = capturaTela.nextFloat();

            System.out.println("Digite número de casas decimais para exibir?");
            maxCsDec = capturaTela.nextInt();

            int i=0, ii=totLinha-1, j=0, jj=totColuna-1;

            float linha[] = new float[totLinha];
            float coluna[] = new float[totColuna];

            linha[0]=tempLinha1;
            linha[linha.length-1]=tempLinhaUltima;
            coluna[0]=tempCol1;
            coluna[coluna.length-1]=tempColUltima;

            System.out.println("====================================================");
            System.out.printf("Ponto central com a temperatura.: 0ºC \n");

            System.out.printf("Inciando temperaturas linhas....: [%d] => %.2f e %d => %.2f \n", i, linha[i],  ii, linha[ii]);
            System.out.printf("Inciando temperaturas colunas...: [%d] => %.2f e %d => %.2f \n", j, coluna[j], jj, coluna[jj]);
            mediaTemperaturas = (linha[i] + linha[ii]+coluna[j] + coluna[jj])/4;
            System.out.println("====================================================");
            System.out.printf("Ponto central com a temperatura.: %.2f \n", mediaTemperaturas);

            mediaTemperaturasAnt = mediaTemperaturas;
            while (i<totLinha && j<totColuna)
            {
                i++;ii--;j++;jj--;
                System.out.println("----------------------------------------------------");
                linha[i] = Math.abs(linha[i] - mediaTemperaturas);
                linha[ii] = Math.abs(linha[i] - mediaTemperaturas);
                coluna[j] = Math.abs(linha[i] - mediaTemperaturas);
                coluna[jj] = Math.abs(linha[i] - mediaTemperaturas);
                mediaTemperaturas = (linha[i] + linha[ii]+coluna[j] + coluna[jj])/4;
                System.out.println("====================================================");
                System.out.printf("Ponto central com a temperatura.: %.2f \n", mediaTemperaturas);

                if (mediaTemperaturas > mediaTemperaturasAnt){
                    System.out.printf("erro acima do esperado..........: %.2f > %.2f \n", mediaTemperaturas, mediaTemperaturasAnt);
                    System.out.printf("Iterações realizadas...........: %d \n" , i);
                }
                else {
                    System.out.printf("erro dentro do esperado.........: %.2f > %.2f \n",mediaTemperaturas, mediaTemperaturasAnt);
                    System.out.printf("Iterações realizadas...........: %d \n", i);
                }
                if (mediaTemperaturas< maxErro || i >= totMaxInter){
                    break;
                }
                mediaTemperaturasAnt = mediaTemperaturas;
            }
        }
}
