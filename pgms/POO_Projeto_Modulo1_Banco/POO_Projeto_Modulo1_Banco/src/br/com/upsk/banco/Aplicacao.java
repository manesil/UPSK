package src.br.com.upsk.banco;

import src.br.com.upsk.banco.cliente.Cliente;
import src.br.com.upsk.banco.conta.Conta;

import java.math.BigDecimal;
import java.util.Scanner;

public class Aplicacao {

    public static void main(String[] args) {
        Cliente nossoCliente =new Cliente();

        Integer idConta=0;
        //BigDecimal vlrTransacao = BigDecimal.ZERO;

        boolean continuar=true;
        while (continuar) {


            switch (capturaMenuEscolhido()) {
                case 1: //Abrir conta
                    idConta = solicitarAberturaConta(nossoCliente);
                    break;
                case 2: //Efetuar Depósito
                    solicitarDeposito(nossoCliente, idConta);
                    break;
                case 3: //Efetuar Saque
                    solicitarSaque(nossoCliente, idConta);
                    break;
                case 4: //Efetuar Transferência
                    break;
                case 5: //Efetuar Investimento
                    break;
                case 6: //Efetuar Resgate de Investimento
                    break;
                case 7: //Consultar Saldo
                    break;
                case 8: //Encerrar operação
                    continuar = false;
                    break;
                default:
                    break;

            }
        }
    }


    private static void solicitarSaque(Cliente nossoCliente, Integer idConta) {
        Scanner input = new Scanner(System.in);
        BigDecimal vlrTransacao;
        if (!idConta.equals(0)) {
            System.out.printf("\n===============================================================================");
            System.out.printf("\n==  Banco ITI+                                                               ==");
            System.out.printf("\n===============================================================================");
            System.out.printf("\n==  Deposito em conta:                                                       ==");
            System.out.printf("\n==  Digite o valor do saque:                                                 ==  => ");
            vlrTransacao = input.nextBigDecimal();
            System.out.printf("\n===============================================================================");
            System.out.printf("\n===============================================================================");
            System.out.printf("\n==  Banco ITI+                                                               ==");
            System.out.printf("\n===============================================================================");
            System.out.printf("\n==  Depósito em conta:                                                       ==");
            System.out.printf("\n==  Cliente:           %s ", nossoCliente.getNomeCliente());
            System.out.printf("\n==  Tipo:              %s ", nossoCliente.getTipoCliente());
            System.out.printf("\n==  CPF/CNPJ:          %s ", nossoCliente.getIdCliente());
            System.out.printf("\n==  Tipo de conta      %s ", nossoCliente.toString());
            System.out.printf("\n==  Id Conta           %d ", idConta);
            System.out.printf("\n===============================================================================");
            //vlrTransacao = new BigDecimal(150);
            nossoCliente.efetuarSaque(idConta, vlrTransacao);
        }
        else{
            System.out.println("Abra uma conta antes de solicitar um saque");
        }
    }


    private static void solicitarDeposito(Cliente nossoCliente, Integer idConta) {
        BigDecimal vlrTransacao;
        Scanner input = new Scanner(System.in);
        if (!idConta.equals(0)) {
            System.out.printf("\n===============================================================================");
            System.out.printf("\n==  Banco ITI+                                                               ==");
            System.out.printf("\n===============================================================================");
            System.out.printf("\n==  Deposito em conta:                                                       ==");
            System.out.printf("\n==  Digite o valor do depósito:                                              == => ");
            vlrTransacao = input.nextBigDecimal();
            System.out.printf("\n===============================================================================");
            //vlrTransacao = new BigDecimal(1000);
            nossoCliente.efetuarDeposito(idConta, vlrTransacao);
            System.out.printf("\n===============================================================================");
            System.out.printf("\n==  Banco ITI+                                                               ==");
            System.out.printf("\n===============================================================================");
            System.out.printf("\n==  Depósito em conta:                                                       ==");
            System.out.printf("\n==  Cliente:           %s ", nossoCliente.getNomeCliente());
            System.out.printf("\n==  Tipo:              %s ", nossoCliente.getTipoCliente());
            System.out.printf("\n==  CPF/CNPJ:          %s ", nossoCliente.getIdCliente());
            System.out.printf("\n==  Tipo de conta      %s ", nossoCliente.toString());
            System.out.printf("\n==  Id Conta           %d ", idConta);
            System.out.printf("\n===============================================================================");

        }
        else{
            System.out.println("Abra uma conta antes de solicitar um depósito");
        }
    }

    private static Integer solicitarAberturaConta(Cliente nossoCliente) {
        Conta conta;
        Scanner capturarTela = new Scanner(System.in);
        System.out.printf("\n===============================================================================");
        System.out.printf("\n==  Banco ITI+                                                               ==");
        System.out.printf("\n===============================================================================");
        System.out.printf("\n==  Abertura de conta:                                                       ==");
        System.out.printf("\n==  Digite o nome do cliente:                                                ==  => ");
        nossoCliente.setNomeCliente(capturarTela.next().toString());
        System.out.printf("\n==  Digite o tipo do cliente:                                                ==  => ");
        nossoCliente.setTipoCliente(capturarTela.next().toString());
        System.out.printf("\n==  Digite o CPF/CNPJ do cliente:                                            ==  => ");
        nossoCliente.setIdCliente(capturarTela.next().toString());
        System.out.printf("\n==  Digite o tipo de conta                                                   ==  => ");
        String tipoContaDigitada = capturarTela.next();
        conta = nossoCliente.abrirConta(tipoContaDigitada);
        System.out.printf("\n===============================================================================");

        System.out.printf("\n===============================================================================");
        System.out.printf("\n==  Banco ITI+                                                               ==");
        System.out.printf("\n===============================================================================");
        System.out.printf("\n==  Abertura de conta:                                                       ==");
        System.out.printf("\n==  Cliente:           %s ", nossoCliente.getNomeCliente());
        System.out.printf("\n==  Tipo:              %s ", nossoCliente.getTipoCliente());
        System.out.printf("\n==  CPF/CNPJ:          %s ", nossoCliente.getIdCliente());
        System.out.printf("\n==  Tipo de conta      %s ", nossoCliente.toString());
        System.out.printf("\n==  Id Conta           %d ", conta.getIdConta());
        System.out.printf("\n===============================================================================");

        return conta.getIdConta();
    }


    private static Integer capturaMenuEscolhido(){
        Scanner capturaTela = new Scanner(System.in);
        Integer opcao;
        System.out.printf("\n===============================================================================");
        System.out.printf("\n==  Banco ITI+                                                               ==");
        System.out.printf("\n===============================================================================");
        System.out.printf("\n==  Entre com a operação Desejada:                                           ==");
        System.out.printf("\n==  1. Abrir Conta                                                           ==");
        System.out.printf("\n==  2. Efetuar Depósito                                                      ==");
        System.out.printf("\n==  3. Efetuar Saque                                                         ==");
        System.out.printf("\n==  4. Efetuar Transferência                                                 ==");
        System.out.printf("\n==  5. Efetuar Investimento                                                  ==");
        System.out.printf("\n==  6. Efetuar Resgate de Investimento                                       ==");
        System.out.printf("\n==  7. Consultar Saldo                                                       ==");
        System.out.printf("\n==  8. Encerrar operação                                                     ==");
        System.out.printf("\n===============================================================================");
        System.out.printf("\n== => ");
        try {
            opcao = capturaTela.nextInt();
            if (opcao<1 || opcao>8){
                    System.out.printf("\n==  Opção inválida. Por favor, digite uma opção entre 1 e 8                   ==");
                    return 0;
            }
        }
        catch (Exception e) {
            System.out.printf("\n==  Opção inválida. Por favor, digite uma opção entre 1 e 8                   ==");
            return 0;
        }
        return opcao;
    }

}

