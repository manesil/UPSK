package br.com.upsk.maiorstring;

public class ListaString {

    public static void main(String[] args) {

        String[] input = {"","","","",""};
        input[0] = "acbda";
        input[1] = "fasdlkh";
        input[2] = "poiwqd";
        input[3] = "zxcqwtop";
        input[4] = "qfgophl";

        System.out.println("Maior cadeia: " + substring(input));

    }
    public static String substring(String[] input) {

        StringBuilder alfabeto = new StringBuilder("abcdefghijklmnopqrstuvxwyz");
        String textoSequencia;
        StringBuilder input_com_cadeia= new StringBuilder();
        String maiorCadeia = "";

        for (int i=0; i < input.length; i++){

                for (int k=0; k < 25; k++){

                    textoSequencia = alfabeto.substring(k,k+2);
                    if (input[i].contains(textoSequencia)){
                        input_com_cadeia.append(textoSequencia);
                    }

                }
                if (maiorCadeia.length() < input_com_cadeia.length()){
                    maiorCadeia = input_com_cadeia.toString();
                }
                input_com_cadeia.setLength(0);
        }
        return maiorCadeia;

    }


}
