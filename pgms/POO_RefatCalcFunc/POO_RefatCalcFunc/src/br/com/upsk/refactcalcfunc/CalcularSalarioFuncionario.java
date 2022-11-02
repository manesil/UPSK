package br.com.upsk.refactcalcfunc;

import java.math.BigDecimal;
import java.util.Scanner;

public class CalcularSalarioFuncionario {

    public static void main(String[] args) {
        BigDecimal vlrSalarioProporcional = new BigDecimal("0.00");
        Integer diasTrabalhado;

        Funcionario funcionario = new Funcionario();

        SolicitarDadosFuncionario(funcionario);

        diasTrabalhado = SolicitarDiasTrabalhadosFuncionario();

        vlrSalarioProporcional = funcionario.ValorProporcionalSalario(diasTrabalhado);

        ImprimirSalarioFuncionario(funcionario,diasTrabalhado,vlrSalarioProporcional);

        ImprimirDadosClasseFuncionario(funcionario);
    }

    public static void ImprimirDadosClasseFuncionario(Funcionario funcionario){
        System.out.println("\n\n==============================================================================");
        System.out.println("==           Informações Classe                                             ==");
        System.out.println("==                                                                          ==");
        System.out.println("==  funcionario:                                                            ==");
        System.out.printf( "==  => '%s'   ==\n",funcionario);
        System.out.println("==  funcionario.hashCode:                                                   ==");
        System.out.printf( "==  => '%s'%s ==\n",funcionario.hashCode(),addSpace(10,66));
        System.out.println("==  funcionario.toString:                                                   ==");
        System.out.printf( "==  => '%s'   ==\n",funcionario.toString());
        System.out.println("==                                                                          ==");
        System.out.println("==============================================================================");
    }

    private static void ImprimirSalarioFuncionario(Funcionario funcionario, Integer diasTrabalhado, BigDecimal vlrSalarioProporcional ) {
        LimparConsole();
        System.out.println("============================================");
        System.out.println("==    Salário Proporcional Funcionário    ==");
        System.out.println("==                                        ==");
        System.out.printf( "==  Nome................:  %s%s ==\n",funcionario.getNome(),addSpace(funcionario.getNome().length(),14));
        System.out.printf( "==  CPF.................:  %s%s ==\n",funcionario.getCpf(),addSpace(funcionario.getCpf().length(),14));
        System.out.printf( "==  Salário Base........:  %.2f%s ==\n",funcionario.getSalarioBase(),addSpace(funcionario.getSalarioBase().toString().length(),13));
        System.out.printf( "==  Dias trabalhado.....:  %d%s ==\n",diasTrabalhado,addSpace(diasTrabalhado.toString().length(),14));
        System.out.printf( "==  Salário proporcional:  %.2f%s ==\n",vlrSalarioProporcional,addSpace(vlrSalarioProporcional.toString().length(),14));
        System.out.println("==                                        ==");
        System.out.println("============================================");
    }

    private static void SolicitarDadosFuncionario(Funcionario funcionario) {
        Scanner capturarTela = new Scanner(System.in);

        System.out.println("Digite nome do funcionário: ");
        funcionario.setNome(capturarTela.next());

        System.out.println("Digite CPF do funcionário: ");
        funcionario.setCpf(capturarTela.next());

        System.out.println("Digite Salario Base do funcionário: ");
        funcionario.setSalarioBase(BigDecimal.valueOf(capturarTela.nextDouble()));
    }

    private static Integer SolicitarDiasTrabalhadosFuncionario() {
        Scanner capturarTela = new Scanner(System.in);

        System.out.println("Digite dias trabalhado pelo funcionário: ");
        return capturarTela.nextInt();
    }

    private static String addSpace(int tamanho, int intMax) {
        StringBuilder espaco = new StringBuilder();
        int qtdEspaco = intMax - tamanho;
        if (qtdEspaco < 1){
            return "";
        }

        espaco.append(" ".repeat(qtdEspaco));
        return espaco.toString();
    }

    private static void LimparConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e){
            //System.out.println("Erro:" + e.getLocalizedMessage());
            System.out.println("Observação: Execução fora do prompt de comando do SO!");
        }
    }

}

