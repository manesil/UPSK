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
            System.out.println("\n EXEMPLO CLIENTE PF: ABERTURA 1a CONTA \n");
            Cliente clientePF = Conta.abrirConta(nomeCliente, documento, TipoDocumentos.CPF);
            System.out.println(clientePF.toString());

            Integer idContaPadrao = clientePF.getIndexIdContas().get(0);
            clientePF.getContasCliente().get(idContaPadrao).depositar(clientePF, new BigDecimal(1000));
            System.out.println("SALDO ATUAL: " + clientePF.getContasCliente().get(idContaPadrao).consultarSaldo());
            clientePF.getContasCliente().get(idContaPadrao).sacar(clientePF, new BigDecimal(500));
            System.out.println("NOVO SALDO APÓS SAQUE: " + clientePF.getContasCliente().get(idContaPadrao).consultarSaldo());
            clientePF.getContasCliente().get(idContaPadrao).transferir(clientePF, new BigDecimal(480));
            System.out.println("NOVO SALDO APÓS TRANSFERENCIA : " + clientePF.getContasCliente().get(idContaPadrao).consultarSaldo());
            clientePF.getContasCliente().get(idContaPadrao).investir(clientePF, new BigDecimal(3500));
            System.out.println("NOVO SALDO APÓS INVESTIMENTO : " + clientePF.getContasCliente().get(idContaPadrao).consultarSaldo());


            BigDecimal valorDeposito = new BigDecimal(250.25);
            clientePF = Conta.abrirConta(clientePF, TipoContas.CONTA_CORRENTE, valorDeposito);
            clientePF = Conta.abrirConta(clientePF, TipoContas.CONTA_POUPANCA, valorDeposito);
            clientePF = Conta.abrirConta(clientePF, TipoContas.CONTA_INVESTIMENTO, valorDeposito);
            clientePF.imprimir();

            //---------------------------------------------------------------------------------------//

            String nomeEmpresa = "code & cia";
            String documentoEmpresa = "11222333000102";

            System.out.println("\n EXEMPLO CLIENTE PJ: ABERTURA 1a CONTA \n");
            Cliente clientePJ = Conta.abrirConta(nomeEmpresa, documentoEmpresa, TipoDocumentos.CNPJ);
            clientePJ.imprimir();

            Integer idContaPadraoPJ = clientePJ.getIndexIdContas().get(0);
            clientePJ.getContasCliente().get(idContaPadraoPJ).depositar(clientePJ, new BigDecimal(10000));
            System.out.println("SALDO ATUAL: " + clientePJ.getContasCliente().get(idContaPadraoPJ).consultarSaldo());
            clientePJ.getContasCliente().get(idContaPadraoPJ).sacar(clientePJ, new BigDecimal(2500));
            System.out.println("NOVO SALDO APÓS SAQUE : " + clientePJ.getContasCliente().get(idContaPadraoPJ).consultarSaldo());
            clientePJ.getContasCliente().get(idContaPadraoPJ).transferir(clientePJ, new BigDecimal(2500));
            System.out.println("NOVO SALDO APÓS TRANSFERENCIA : " + clientePJ.getContasCliente().get(idContaPadraoPJ).consultarSaldo());
            clientePJ.getContasCliente().get(idContaPadraoPJ).investir(clientePJ, new BigDecimal(500));
            System.out.println("NOVO SALDO APÓS INVESTIMENTO : " + clientePJ.getContasCliente().get(idContaPadraoPJ).consultarSaldo());


            BigDecimal valorDepositoPJ = new BigDecimal(6250);
            clientePJ = Conta.abrirConta(clientePJ, TipoContas.CONTA_CORRENTE, valorDepositoPJ);
            clientePJ = Conta.abrirConta(clientePJ, TipoContas.CONTA_POUPANCA, valorDepositoPJ);
            clientePJ = Conta.abrirConta(clientePJ, TipoContas.CONTA_INVESTIMENTO, valorDepositoPJ);
            clientePJ.imprimir();

        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e);
        }


    }
}
