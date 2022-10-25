package br.com.letscode.PrimeiroJava;

import java.util.Scanner;

public class Combustivel {
    public static final int MEDIA_COMBUSTIVEL = 12;

    public static void main(String[] args) {

        Scanner oValor = new Scanner(System.in);
        int tempoEmHora;
        int velocidadeMedia;
        int distanciaPercorrida;
        float quantidadeDeCombustivelUtilizada;

        System.out.println("Informe quatidade de horas percorrida: ");
        tempoEmHora=oValor.nextInt();
        System.out.println("Informe a velocidade média: ");
        velocidadeMedia=oValor.nextInt();

        distanciaPercorrida = DistanciaPercorrida(tempoEmHora,velocidadeMedia);

        quantidadeDeCombustivelUtilizada = QuantidadeDeCombustivelUtilizada(distanciaPercorrida);

        System.out.println("Velocidade média: " + velocidadeMedia);
        System.out.println("Tempo Gasto: " + tempoEmHora);
        System.out.println("Distância Percorrida: " + distanciaPercorrida);
        System.out.println("Quantidade de combustível: " + quantidadeDeCombustivelUtilizada);
    }

    public static int DistanciaPercorrida(int tempoEmHora, int velocidadeMedia){
        int distancia;

        distancia = tempoEmHora * velocidadeMedia;

        return distancia;
    }

    public static float QuantidadeDeCombustivelUtilizada(int distanciaPercorrida){
        float litrosGastos;
        litrosGastos = (float) distanciaPercorrida / (float) MEDIA_COMBUSTIVEL;

        return litrosGastos;
    }
}
