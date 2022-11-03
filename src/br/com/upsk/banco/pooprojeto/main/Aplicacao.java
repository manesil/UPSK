package br.com.upsk.banco.pooprojeto.main;

import br.com.upsk.banco.pooprojeto.cliente.Cliente;
import br.com.upsk.banco.pooprojeto.cliente.TipoContas;
import br.com.upsk.banco.pooprojeto.cliente.TipoDocumentos;
import br.com.upsk.banco.pooprojeto.conta.Conta;

import java.math.BigDecimal;

public class Aplicacao {

    public static void main(String[] args) {




        String nomeCliente = "alexandre";
        String documento = "11122233344";

        try {
            System.out.println("EXEMPLO CLIENTE PF: ABERTURA 1a CONTA \n");
            Cliente clientePF = Conta.abrirConta(nomeCliente, documento, TipoDocumentos.CPF);
            System.out.println(clientePF);

            BigDecimal valorDeposito = new BigDecimal("1000.00");

            Integer idContaPadrao = clientePF.getIndexIdContas().get(0);
            clientePF.getContasCliente().get(idContaPadrao).depositar(clientePF, valorDeposito);
            System.out.println("VALOR DEPOSITO: " + valorDeposito);
            System.out.println("SALDO ATUAL: " + clientePF.getContasCliente().get(idContaPadrao).consultarSaldo());
            clientePF.getContasCliente().get(idContaPadrao).sacar(clientePF, new BigDecimal("500"));
            System.out.println("NOVO SALDO APÓS SAQUE: " + clientePF.getContasCliente().get(idContaPadrao).consultarSaldo());
            clientePF.getContasCliente().get(idContaPadrao).transferir(clientePF, new BigDecimal("480"));
            System.out.println("NOVO SALDO APÓS TRANSFERENCIA : " + clientePF.getContasCliente().get(idContaPadrao).consultarSaldo());
            clientePF.getContasCliente().get(idContaPadrao).investir(clientePF, new BigDecimal("3500"));
            System.out.println("NOVO SALDO APÓS INVESTIMENTO : " + clientePF.getContasCliente().get(idContaPadrao).consultarSaldo());


            valorDeposito = new BigDecimal("250.25");
            Conta.abrirConta(clientePF, TipoContas.CONTA_CORRENTE, valorDeposito);

            valorDeposito = new BigDecimal("2280.00");
            Conta.abrirConta(clientePF, TipoContas.CONTA_POUPANCA, valorDeposito);

            valorDeposito = new BigDecimal("25000.00");
            Conta.abrirConta(clientePF, TipoContas.CONTA_INVESTIMENTO, valorDeposito);

            clientePF.imprimir();

            //---------------------------------------------------------------------------------------//

            String nomeEmpresa = "code & cia";
            String documentoEmpresa = "11222333000102";

            System.out.println("EXEMPLO CLIENTE PJ: ABERTURA 1a CONTA \n");
            Cliente clientePJ = Conta.abrirConta(nomeEmpresa, documentoEmpresa, TipoDocumentos.CNPJ);
            System.out.println(clientePJ);

            BigDecimal valorDepositoPJ = new BigDecimal("10000.00");

            Integer idContaPadraoPJ = clientePJ.getIndexIdContas().get(0);
            clientePJ.getContasCliente().get(idContaPadraoPJ).depositar(clientePJ, valorDepositoPJ);
            System.out.println("VALOR DEPOSITO: " + valorDepositoPJ);
            System.out.println("SALDO ATUAL: " + clientePJ.getContasCliente().get(idContaPadraoPJ).consultarSaldo());
            clientePJ.getContasCliente().get(idContaPadraoPJ).sacar(clientePJ, new BigDecimal("2500"));
            System.out.println("NOVO SALDO APÓS SAQUE : " + clientePJ.getContasCliente().get(idContaPadraoPJ).consultarSaldo());
            clientePJ.getContasCliente().get(idContaPadraoPJ).transferir(clientePJ, new BigDecimal("2500"));
            System.out.println("NOVO SALDO APÓS TRANSFERENCIA : " + clientePJ.getContasCliente().get(idContaPadraoPJ).consultarSaldo());
            clientePJ.getContasCliente().get(idContaPadraoPJ).investir(clientePJ, new BigDecimal("500"));
            System.out.println("NOVO SALDO APÓS INVESTIMENTO : " + clientePJ.getContasCliente().get(idContaPadraoPJ).consultarSaldo());


            valorDepositoPJ = new BigDecimal(6250.00);
            Conta.abrirConta(clientePJ, TipoContas.CONTA_CORRENTE, valorDepositoPJ);

            valorDepositoPJ = new BigDecimal(12000.00);
            Conta.abrirConta(clientePJ, TipoContas.CONTA_POUPANCA, valorDepositoPJ);

            valorDepositoPJ = new BigDecimal("100000.00");
            Conta.abrirConta(clientePJ, TipoContas.CONTA_INVESTIMENTO, valorDepositoPJ);

            clientePJ.imprimir();

        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e);
        }


    }
}
