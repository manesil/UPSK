package br.com.upsk.banco.pooprojeto.main;

import br.com.upsk.banco.pooprojeto.cliente.Cliente;
import br.com.upsk.banco.pooprojeto.cliente.TipoContas;
import br.com.upsk.banco.pooprojeto.cliente.TipoDocumentos;
import br.com.upsk.banco.pooprojeto.conta.Conta;
import br.com.upsk.banco.pooprojeto.conta.ContaCorrente;

import java.math.BigDecimal;

public class Aplicacao {

    public static void main(String[] args) {
        String nomeCliente = "alexandre";
        String documento = "11122233344";

        try {
            Conta conta = new ContaCorrente();

            System.out.println("\n EXEMPLO CLIENTE PF: ABERTURA 1a CONTA \n");
            Cliente cliente = conta.abrirConta(nomeCliente, documento, TipoDocumentos.CPF);
            cliente.imprimir();

            cliente.getContasCliente().get(0).depositar(new BigDecimal(1000));
            System.out.println("SALDO ATUAL: " +cliente.getContasCliente().get(0).consultarSaldo());
            cliente.getContasCliente().get(0).sacar(cliente, new BigDecimal(500));
            System.out.println("NOVO SALDO : " + cliente.getContasCliente().get(0).consultarSaldo());

            BigDecimal valorDeposito = new BigDecimal(250.25);
            cliente = conta.abrirConta(cliente, TipoContas.CONTA_CORRENTE, valorDeposito);
            cliente = conta.abrirConta(cliente, TipoContas.CONTA_POUPANCA, valorDeposito);
            cliente = conta.abrirConta(cliente, TipoContas.CONTA_INVESTIMENTO, valorDeposito);
            cliente.imprimir();

            //---------------------------------------------------------------------------------------//

            System.out.println("\n EXEMPLO CLIENTE PJ: ABERTURA 1a CONTA \n");
            Cliente clientePJ = conta.abrirConta(nomeCliente, documento, TipoDocumentos.CNPJ);
            clientePJ.imprimir();

            clientePJ.getContasCliente().get(0).depositar(new BigDecimal(1000));
            System.out.println("SALDO ATUAL: " + clientePJ.getContasCliente().get(0).consultarSaldo());
            clientePJ.getContasCliente().get(0).sacar(clientePJ, new BigDecimal(500));
            System.out.println("NOVO SALDO : " + clientePJ.getContasCliente().get(0).consultarSaldo());

            BigDecimal valorDepositoPJ = new BigDecimal(6250);
            clientePJ = conta.abrirConta(clientePJ, TipoContas.CONTA_CORRENTE, valorDepositoPJ);
            clientePJ = conta.abrirConta(clientePJ, TipoContas.CONTA_POUPANCA, valorDepositoPJ);
            clientePJ = conta.abrirConta(clientePJ, TipoContas.CONTA_INVESTIMENTO, valorDepositoPJ);
            clientePJ.imprimir();

        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e);
        }


    }
}
