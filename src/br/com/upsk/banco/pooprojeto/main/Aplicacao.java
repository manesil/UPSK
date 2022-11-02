package br.com.upsk.banco.pooprojeto.main;

import br.com.upsk.banco.pooprojeto.cliente.Cliente;
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

            System.out.println("\n EXEMPLO CLIENTE PF \n");
            Cliente cliente = conta.abrirConta(nomeCliente, documento, TipoDocumentos.CPF);
            cliente.imprimir();

            cliente.getContasCliente().get(0).depositar(new BigDecimal(1000));
            System.out.println("SALDO ATUAL: " +cliente.getContasCliente().get(0).consultarSaldo());
            cliente.getContasCliente().get(0).sacar(cliente, new BigDecimal(500));
            System.out.println("NOVO SALDO : " + cliente.getContasCliente().get(0).consultarSaldo());

            System.out.println("\n EXEMPLO CLIENTE PJ \n");
            Cliente clientePJ = conta.abrirConta(nomeCliente, documento, TipoDocumentos.CNPJ);
            clientePJ.imprimir();

            clientePJ.getContasCliente().get(0).depositar(new BigDecimal(1000));
            System.out.println("SALDO ATUAL: " + clientePJ.getContasCliente().get(0).consultarSaldo());
            clientePJ.getContasCliente().get(0).sacar(clientePJ, new BigDecimal(500));
            System.out.println("NOVO SALDO : " + clientePJ.getContasCliente().get(0).consultarSaldo());

        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e);
        }


    }
}
