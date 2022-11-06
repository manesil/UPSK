package br.com.upsk.banco;

import br.com.upsk.banco.cliente.Cliente;
import br.com.upsk.banco.conta.Conta;

import java.math.BigDecimal;

public class Aplicacao {

    //TODO: NERI - Tela


    public static void main(String[] args) {
        Cliente nossoCliente =new Cliente();
        Conta conta;
        BigDecimal vlrTransacao = new BigDecimal(0);
        //cadastrar cliente/Abrir a conta
        nossoCliente.setNomeCliente("Joao");
        nossoCliente.setTipoCliente("PF");
        nossoCliente.setIdCliente("123.456.789-01");

        conta = nossoCliente.abrirConta( "CC");

        //consultar conta (conta está aberta)


        //operação
            //deposito, saque (transferencia, resgatar investimento, investir) rentabilidade / taxa
            vlrTransacao = new BigDecimal(1000);
            nossoCliente.efetuarDeposito(conta, vlrTransacao);

    }

}

