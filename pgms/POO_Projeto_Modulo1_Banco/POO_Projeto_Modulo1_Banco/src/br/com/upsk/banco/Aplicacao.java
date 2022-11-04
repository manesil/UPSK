package br.com.upsk.banco;

import br.com.upsk.banco.cliente.Cliente;
import br.com.upsk.banco.conta.Conta;

import java.math.BigDecimal;
import java.util.Scanner;

public class Aplicacao {

    //TODO: NERI - Tela


    public static void main(String[] args) {
        Cliente nossoCliente =new Cliente();
        Integer idConta;
        //BigDecimal vlrTransacao = new BigDecimal(0);
        BigDecimal vlrTransacao = BigDecimal.ZERO;
        //cadastrar cliente/Abrir a conta
        nossoCliente.setNomeCliente("Joao");
        nossoCliente.setTipoCliente("PF");
        nossoCliente.setIdCliente("123.456.789-01");

        idConta = nossoCliente.abrirConta( "CC");

        //consultar conta (conta está aberta)


        //operação
            //deposito, saque (transferencia, resgatar investimento, investir) rentabilidade / taxa

            Scanner input = new Scanner(System.in);
            System.out.println("Digite o valor do Deposito: ");
            vlrTransacao = input.nextBigDecimal();

            //vlrTransacao = new BigDecimal(1000);
            nossoCliente.efetuarDeposito(idConta, vlrTransacao);

            nossoCliente.setNomeCliente("Maria");
            nossoCliente.setTipoCliente("PJ");
            nossoCliente.setIdCliente("008.975.743/0001-90");

            System.out.println("Digite o valor do Saque: ");
            vlrTransacao = input.nextBigDecimal();

            //vlrTransacao = new BigDecimal(150);
            nossoCliente.efetuarSaque(idConta, vlrTransacao);

    }

}

