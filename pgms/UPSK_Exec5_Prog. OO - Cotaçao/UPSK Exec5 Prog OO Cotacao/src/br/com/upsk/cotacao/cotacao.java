package br.com.upsk.cotacao;
import java.util.Scanner;

public class cotacao {

    public static void main(String[] args) {
        Double vlrDolaCotacao, vlrDolarInformado;

        Scanner osValores = new Scanner(System.in);
        System.out.println("Informe a Cotação do dolar hoje: ");
        vlrDolaCotacao=osValores.nextDouble();
        System.out.println("Informe o valor em U$: ");
        vlrDolarInformado=osValores.nextDouble();

        CalculaMoeda.cotarMoeda(vlrDolaCotacao,vlrDolarInformado);

    }
}
