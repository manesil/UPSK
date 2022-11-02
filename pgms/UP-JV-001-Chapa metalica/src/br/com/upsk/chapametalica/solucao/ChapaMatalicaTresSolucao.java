package br.com.upsk.chapametalica.solucao;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ChapaMatalicaTresSolucao {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite as dimensões da chapa (linhas,colunas): ");
        int numLinhas = scanner.nextInt();
        int numColunas = scanner.nextInt();

        double[][] chapa = new double[numLinhas][numColunas]; //Temperaturas da chapa
        double[] valoresIniciais = new double[4];//{100, -3, 20, 20}; //Temperaturas dos lados

        double epsilon; //erro máximo aceitável
        int maxIteracoes; //máximo de iterações

        int decimais; //casas decimais a serem mostradas na matriz (0 a 6)

        System.out.print("Digite a temperatura da primeira coluna: ");
        valoresIniciais[0] = scanner.nextDouble();

        System.out.print("Digite a temperatura da última coluna: ");
        valoresIniciais[1] = scanner.nextDouble();

        System.out.print("Digite a temperatura da primeira linha: ");
        valoresIniciais[2] = scanner.nextDouble();

        System.out.print("Digite a temperatura da última linha: ");
        valoresIniciais[3] = scanner.nextDouble();

        System.out.print("Digite o número máximo de iterações: ");
        maxIteracoes = scanner.nextInt();

        System.out.print("Digite o erro máximo aceitável: ");
        epsilon = scanner.nextDouble();

        System.out.print("Número de casa decimais na matriz: ");
        decimais = scanner.nextInt();


        run(chapa, valoresIniciais, maxIteracoes, epsilon, decimais);

    }

    //Método que faz iterações de atualização da temperatura da chapa até atinger o erro eps ou o número máximo de iterações
    private static void run(double[][] chapa, double[] valoresIniciais, int round, double eps, int decimais){
        int cont = 0; //contador de iterações
        int numLinhas = chapa.length;
        int numColunas = chapa[0].length;
        double[][] chapaTemp = new double[numLinhas][numColunas]; // auxiliar
        double erro = eps+1; //erro máximo aceitável
        matrizInicial(chapa, valoresIniciais);//inserindo as temperaturas dos lados da chapa
        matrizInicial(chapaTemp, valoresIniciais);//inserindo as temperaturas dos lados da chapa

        boolean salvarArquivosGnuplot = true;
        System.out.print("Salvar os arquivos para visualizar no Gnuplot? (true/false): ");
        Scanner scanner = new Scanner(System.in);
        salvarArquivosGnuplot = scanner.nextBoolean();
        if(salvarArquivosGnuplot)
            escreveFile(chapa,"heatmap0");

        //Enquanto o erro entre duas etapas consecutivas for maior que eps E tiver
        // menos iterações do que o máximo dado, continue
        while(erro > eps && cont < round){

            //Calculando as novas temperaturas dos pontos no interior da chapa
            for (int i = 1; i < numLinhas - 1; i++) {
                for (int j = 1; j < numColunas - 1; j++) {
                    chapaTemp[i][j] = (chapa[i - 1][j] + chapa[i + 1][j] + chapa[i][j - 1] + chapa[i][j + 1]) / 4;
                }
            }

            cont++; //atualizando o contador de iterações
            erro = maxError(chapa,chapaTemp);//calculando o maior erro entre as iterações
            System.out.println("Etapa "+(cont)+ " Erro máximo: "+erro);
            copy(chapaTemp, chapa); //atualizando as temperaturas da chapa
            //printMat(chapaTemp, decimais);  //mostrando as temperaturas da chapa
            if(salvarArquivosGnuplot)
                escreveFile(chapa,"heatmap"+cont);
        }

        if(salvarArquivosGnuplot)
            escreveScriptGnuplot(cont-1,numLinhas,numColunas);
        //printMat(chapaTemp,decimais);
        //return chapa;

    }
    //////////////////
    //Escreve as temperaturas da chapa, em uma dada iteração, no arquivo (para plottar no gnuplot)
    public static void escreveFile(double[][] mat, String arqNome){
        //Colocar o path do arquivo na variável arqNome
        arqNome = "C:\\Users\\User\\Desktop\\mapaDeCalor\\"+arqNome+".txt";
        int numLinhas = mat.length;
        int numColunas = mat[0].length;

        try {
            FileWriter myWriter = new FileWriter(arqNome);

            for (int i = 0; i < numLinhas; i++) {
                for (int j = 0; j < numColunas; j++) {
                    myWriter.write(Double.toString(mat[i][j])+" ");
                }
                myWriter.write("\n");
            }
            //myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    //////////////////
    public static void escreveScriptGnuplot(int totalDeArquivosGnuplot, int numLinhas, int numColunas){
        //Colocar o path do arquivo na variável arqNome
        //Usar o seguinte comando no Gnuplot para ver os mapas de calor: load "load.txt"
        String arqNome = "C:\\Users\\User\\Desktop\\mapaDeCalor\\load.txt";

        try {
            FileWriter myWriter = new FileWriter(arqNome);

            //myWriter.write("\n");
            myWriter.write("#http://www.gnuplot.info/ -->para baixar o gnuplot"+
                    "reset\n" +
                    "set xrange [0:"+Integer.toString(numColunas)+"]\n"+
                    "set yrange [0:"+Integer.toString(numLinhas+2)+"]\n"+
                    "set size square\n"+
                    "set cbtics 10\n"+
                    "plot 'heatmap0.txt' matrix w image ti sprintf('%d',0) \n"+
                    "pause -1 \n"+
                    "do for [t=0:"+Integer.toString(totalDeArquivosGnuplot)+"] {\n"+
                    "outfile = sprintf('%s%d','heatmap',t).'.txt'\n"+
                    "plot outfile matrix w image ti sprintf('%d',t)\n"+
                    "#pause .01\n"+
                    "}");


            //myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }


    /////////////////


    //Calcula o valor absoluto do erro máximo entre as iterações, ponto a ponto
    private static double maxError(double[][] chapa, double[][] chapaTemp)
    {
        double erro = 0;
        double temp = 0 ;
        int numLinhas = chapa.length;
        int numColunas = chapa[0].length;

        for(int i = 0; i < numLinhas; i++)
            for(int j = 0; j < numColunas; j++) {
                temp = Math.abs(chapa[i][j] - chapaTemp[i][j]);
                if (temp > erro) {
                    erro = temp;
                }
            }

        return erro;
    }

    //Copia manualmente as matrizes --> há métodos que fazem isso automaticamente
    private static void copy(double[][] chapa, double[][] chapaDestino) {
        int numLinhas = chapa.length;
        int numColunas = chapa[0].length;

        for(int i = 0; i < numLinhas ;i++)
            for(int j = 0; j < numColunas; j++)
                chapaDestino[i][j] = chapa[i][j];
    }

    //Inicializa as temperaturas da chapa com os valores dos lados dados e zero no interior
    public static void matrizInicial(double[][] chapa, double[] valoresIniciais ){
        int num_linhas = chapa.length;
        int num_colunas = chapa[0].length;

        for(int i=0; i < num_linhas; i++) {
            chapa[i][0] = valoresIniciais[0];
            chapa[i][num_colunas - 1] = valoresIniciais[1];
        }
        for(int j=0; j < num_colunas; j++) {
            chapa[0][j] = valoresIniciais[2];
            chapa[num_linhas - 1][j] = valoresIniciais[3];
        }
        //printMat(chapa);
    }

    //Mostra a temperatura da chapa na tela, com o número de casas decimais definido pelo usuário (sugestão: decimais <=6)
    public static void printMat(double[][] mat, int decimais) {
        String formatacao = "%10." + decimais + "f  ";

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.printf(formatacao, mat[i][j]);
            }
            System.out.println();
        }
        System.out.println("\n");
    }
}
