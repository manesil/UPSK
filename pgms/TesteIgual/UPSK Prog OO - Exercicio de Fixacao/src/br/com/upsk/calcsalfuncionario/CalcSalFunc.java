package br.com.upsk.calcsalfuncionario;

import java.util.Scanner;

public class CalcSalFunc {

    public static void main(String[] args) {
        Scanner capturaTela = new Scanner(System.in);
        boolean continua=true;
        Funcionario funcionario = new Funcionario();
        Funcionario2 funcionario2 = new Funcionario2();
        int diasTrabalhados;
        double valorSalCalculado;

        while (continua){

            diasTrabalhados = capturaDados(capturaTela, funcionario);

            valorSalCalculado = Funcionario.salarioProporcional(diasTrabalhados);

            relatorio(funcionario, diasTrabalhados, valorSalCalculado);

            continua = msgContinua(capturaTela);
            if (!continua) break;
        }

        exibeDadosObjeto(funcionario);
        exibeDadosObjeto2(funcionario2,funcionario);
    }

    private static void exibeDadosObjeto(Funcionario funcionario) {
        System.out.println("\n<COM> implementação das classes pai (toString, hasCode e equals)");
        System.out.println("Funcionário => objeto : " + funcionario);
        System.out.println("Funcionário => hasCode : " + funcionario.hashCode());
        System.out.println("Funcionário => toString : " + funcionario.toString());
    }

    private static void exibeDadosObjeto2(Funcionario2 funcionario, Funcionario func) {

        funcionario.nome = func.nome;
        funcionario.cpf = func.cpf;
        funcionario.salarioBase = func.salarioBase;
        System.out.println("\n<SEM> implementação das classes pai (toString, hasCode e equals)");
        System.out.println("Funcionário2 => objeto : " + funcionario);
        System.out.println("Funcionário2 => hasCode : " + funcionario.hashCode());
        System.out.println("Funcionário2 => toString : " + funcionario.toString());
    }
    private static int capturaDados(Scanner capturaTela, Funcionario funcionario) {
        int diasTrabalhados;
        System.out.println("--------------------------------------------------");
        System.out.println("Entre com o nome do funcionário?");
        funcionario.nome = capturaTela.next();
        System.out.println("Entre com o CPF do funcionário?");
        funcionario.cpf = capturaTela.next();
        System.out.println("Entre com o salário base do funcionário?");
        funcionario.salarioBase = capturaTela.nextDouble();
        System.out.println("Entre com os dias trabalhados?");
        diasTrabalhados = capturaTela.nextInt();
        return diasTrabalhados;
    }

    private static boolean msgContinua(Scanner capturaTela) {
        String continua;
        System.out.println("Deseja continuar? S para sim");
        continua = capturaTela.next();
        if (!continua.equals("S")){
            return false;
        }
        return true;
    }

    private static void relatorio(Funcionario funcionario, int diasTrabalhados, double valorSalCalculado) {
        System.out.println("");
        System.out.println("======= Relatório Salário Funcionário =======");
        System.out.printf( "Funcionário...............: %s \n", funcionario.nome);
        System.out.printf( "CPF.......................: %s \n", funcionario.cpf);
        System.out.printf( "Salário base (30 dias)....: %.2f \n", funcionario.salarioBase);
        System.out.printf( "Dias trabalhados..........: %d \n", diasTrabalhados);
        System.out.printf( "Valor salário proporcional: %.2f \n", valorSalCalculado);
        System.out.println("=============== Fim Relatório ===============");
        System.out.println("");
    }
}
