package br.com.upsk.chapametalica.tres;

import java.util.Scanner;

public class ChapaMetalicaTres {

    public static void main(String[] args) {

        obterTemperatura();

    }
    public static void obterTemperatura(){
        Scanner capturaTela = new Scanner(System.in);
        int totLinha, totColuna, totMaxInter, maxCsDec;
        float tempLinha1, tempLinhaUltima, tempCol1, tempColUltima,
              maxErro, mediaTemperaturas, mediaTemperaturasAnt;

        System.out.println("Observação: separe os números por espaço");
        System.out.println("Digite a quantidade de Linhas e Colunas da chapa: ");
        totLinha = capturaTela.nextInt();
        totColuna = capturaTela.nextInt();

        System.out.println("Digite as 2 temperaturas das Linhas e as 2 das Colunas da chapa:");
        tempLinha1 = Math.abs(capturaTela.nextFloat());
        tempLinhaUltima = Math.abs(capturaTela.nextFloat());
        tempCol1 = Math.abs(capturaTela.nextFloat());
        tempColUltima = Math.abs(capturaTela.nextFloat());

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
        System.out.println("====================================================");
        System.out.printf("Iteração .......................: %d \n", 1);
        System.out.printf(formTxt("Inciando temperaturas linhas....: [%d] => %.#f e [%d] => %.#f \n",maxCsDec), i, linha[i],  ii, linha[ii]);
        System.out.printf(formTxt("Inciando temperaturas colunas...: [%d] => %.#f e [%d] => %.#f \n",maxCsDec), j, coluna[j], jj, coluna[jj]);
        mediaTemperaturas = (linha[i] + linha[ii]+coluna[j] + coluna[jj])/4;
        System.out.printf(formTxt("Ponto central com a temperatura.: %.#f \n",maxCsDec), mediaTemperaturas);
        System.out.println("====================================================");

        mediaTemperaturasAnt = mediaTemperaturas;
        //while (i<totLinha && j<totColuna)
        while (mediaTemperaturas > maxErro && i+1 < totMaxInter)
        {
            i++;ii--;j++;jj--;

            linha[i] = Math.abs(linha[i-1] - mediaTemperaturas);
            linha[ii] = Math.abs(linha[ii+1] - mediaTemperaturas);
            coluna[j] = Math.abs(coluna[j-1] - mediaTemperaturas);
            coluna[jj] = Math.abs(coluna[jj+1] - mediaTemperaturas);
            mediaTemperaturas = (linha[i] + linha[ii]+coluna[j] + coluna[jj])/4;

            System.out.println("====================================================");
            System.out.printf("Iteração .......................: %d \n" , i+1);
            System.out.printf(formTxt("Novas temperaturas linhas....: [%d] => %.#f e [%d] => %.#f \n",maxCsDec), i, linha[i],  ii, linha[ii]);
            System.out.printf(formTxt("Novas temperaturas colunas...: [%d] => %.#f e [%d] => %.#f \n",maxCsDec), j, coluna[j], jj, coluna[jj]);
            System.out.printf(formTxt("Ponto central com a temperatura.: %.#f \n",maxCsDec), mediaTemperaturas);

            if (mediaTemperaturas > mediaTemperaturasAnt){
                System.out.printf(formTxt("erro acima do esperado..........: %.#f > %.#f \n",maxCsDec), mediaTemperaturas, mediaTemperaturasAnt);
                System.out.printf("Iterações realizadas............: %d \n" , i+1);
            }
            else {
                System.out.printf(formTxt("erro dentro do esperado.........: %.#f > %.#f \n",maxCsDec),mediaTemperaturas, mediaTemperaturasAnt);
                System.out.printf("Iterações realizadas............: %d \n", i+1);
            }
            if (mediaTemperaturas< maxErro || i >= totMaxInter){
                break;
            }
            mediaTemperaturasAnt = mediaTemperaturas;
        }
    }
    public static String formTxt(String texto, int CasasDecimais){
        return texto.replace("%.#","%." + CasasDecimais);
    }
}
