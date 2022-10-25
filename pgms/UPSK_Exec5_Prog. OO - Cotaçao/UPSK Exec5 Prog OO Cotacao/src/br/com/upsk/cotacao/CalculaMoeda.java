package br.com.upsk.cotacao;

public class CalculaMoeda {

    public static void cotarMoeda(Double vlrDolaCotacao,Double vlrDolarInformado){
        Double vlrReal;

        vlrReal = vlrDolaCotacao * vlrDolarInformado;
        System.out.printf("O valor em reais para os dados informados: " + vlrReal );
    }

}
