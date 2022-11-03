package br.com.upsk.banco.pooprojeto.main;

import br.com.upsk.banco.pooprojeto.cliente.Cliente;
import br.com.upsk.banco.pooprojeto.cliente.TipoContas;
import br.com.upsk.banco.pooprojeto.cliente.TipoDocumentos;
import br.com.upsk.banco.pooprojeto.conta.Conta;

import java.math.BigDecimal;
import java.util.Scanner;

public class Aplicacao {

    private static Cliente cliente = null;

    public static void main(String[] args) {

        Aplicacao.interagirMenu();

/*
        //------------------------------------------------------------------------------
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

 */

    }

    private static String inicializarMenu(){
        String resposta;
        StringBuffer sb = new StringBuffer();

        sb.append("OLÁ! ").append("\n");
        sb.append("---------------------------------------------------------------------\n");
        sb.append("1- Abrir Conta").append("\n");
        sb.append("2- Depositar").append("\n");
        sb.append("3- Sacar").append("\n");
        sb.append("4- Transferir").append("\n");
        sb.append("5- Investir").append("\n");
        sb.append("6- Consultar Saldo das Contas").append("\n");
        sb.append("x- para sair").append("\n");
        sb.append("---------------------------------------------------------------------\n");
        sb.append("--> Indique o número de uma opção acima e de enter: ");

        Scanner leitorTela = new Scanner(System.in);
        System.out.printf(sb.toString());
        resposta = leitorTela.next();

        return resposta;
    }

    private static String verificarSeDesejaContinuar(){
        String resposta;

        Scanner leitorTela = new Scanner(System.in);
        System.out.printf("Deseja continuar? Digite S ou N: ");
        resposta = leitorTela.next();

        return resposta.toUpperCase();
    }

    private static void interagirMenu(){
        String resposta;
        resposta = Aplicacao.inicializarMenu();

        switch (resposta.toUpperCase()){
            case "1" -> Aplicacao.selecionarOpcaoMenu_1();
            case "2" -> Aplicacao.selecionarOpcaoMenu_2(cliente);
            case "3" -> Aplicacao.selecionarOpcaoMenu_3(cliente);
            case "4" -> Aplicacao.selecionarOpcaoMenu_4(cliente);
            case "5" -> Aplicacao.selecionarOpcaoMenu_5(cliente);
            case "6" -> Aplicacao.selecionarOpcaoMenu_6(cliente);
            case "X" -> System.out.println("ATÉ LOGO!!!");
        }
    }

    private static void  selecionarOpcaoMenu_1(){
        String resposta;

        try {
            Aplicacao.abrirConta();
            Aplicacao.cliente.imprimirResumido();

            resposta = Aplicacao.verificarSeDesejaContinuar();

            if ("N".equals(resposta)){
                System.out.println("ATÉ LOGO!!!");
            }
            interagirMenu();

        }catch (Exception e){
            Aplicacao.executarSaidaAplicacao("Algo não funcionou bem :( ... Desculpe!");
        }

    }

    private static void selecionarOpcaoMenu_2(Cliente cliente){
        String resposta;
        try {
            Aplicacao.depositar(cliente);
            resposta = Aplicacao.verificarSeDesejaContinuar();

            if ("N".equals(resposta)){
                Aplicacao.executarSaidaAplicacao("ATÉ LOGO!!!");
            }
            interagirMenu();

        }catch (Exception e){
            Aplicacao.executarSaidaAplicacao("Algo não funcionou bem :( ... Desculpe!");
        }
    }

    private static void selecionarOpcaoMenu_3(Cliente cliente){
        String resposta;

        try {
            Aplicacao.sacar(cliente);
            resposta = Aplicacao.verificarSeDesejaContinuar();

            if ("N".equals(resposta)){
                Aplicacao.executarSaidaAplicacao("ATÉ LOGO!!!");
            }
            interagirMenu();

        }catch (Exception e){
            Aplicacao.executarSaidaAplicacao("Algo não funcionou bem :( ... Desculpe!");
        }
    }

    private static void selecionarOpcaoMenu_4(Cliente cliente){
        String resposta;

        try {
            Aplicacao.transferir(cliente);
            resposta = Aplicacao.verificarSeDesejaContinuar();

            if ("N".equals(resposta)){
                Aplicacao.executarSaidaAplicacao("ATÉ LOGO!!!");
            }
            interagirMenu();

        }catch (Exception e){
            Aplicacao.executarSaidaAplicacao("Algo não funcionou bem :( ... Desculpe!");
        }
    }

    private static void selecionarOpcaoMenu_5(Cliente cliente){
        String resposta;

        try {
            Aplicacao.investir(cliente);
            resposta = Aplicacao.verificarSeDesejaContinuar();

            if ("N".equals(resposta)){
                Aplicacao.executarSaidaAplicacao("ATÉ LOGO!!!");
            }
            interagirMenu();

        }catch (Exception e){
            Aplicacao.executarSaidaAplicacao("Algo não funcionou bem :( ... Desculpe!");
        }
    }

    private static void selecionarOpcaoMenu_6(Cliente cliente){
        String resposta;

        try {
            Aplicacao.imprimirSaldos(cliente);
            resposta = Aplicacao.verificarSeDesejaContinuar();

            if ("N".equals(resposta)){
                Aplicacao.executarSaidaAplicacao("ATÉ LOGO!!!");
            }
            interagirMenu();

        }catch (Exception e){
            Aplicacao.executarSaidaAplicacao("Algo não funcionou bem :( ... Desculpe!");
        }
    }

    private static void abrirConta() throws Exception{
        String nome;
        String documento;
        String tipoDocumento;

        if (Aplicacao.cliente == null) {
            Scanner leitorTela = new Scanner(System.in);
            System.out.printf("Informe seu nome                             : ");
            nome = leitorTela.nextLine();

            leitorTela = new Scanner(System.in);
            System.out.printf("Qual o documento será utilizado? (CPF | CNPJ): ");
            tipoDocumento = leitorTela.next();

            System.out.printf("Informe o número do documento                : ");
            documento = leitorTela.next();

            TipoDocumentos enumTipoDocumentos;
            if ("CPF".equals(tipoDocumento.toUpperCase())) {
                enumTipoDocumentos = TipoDocumentos.CPF;
            } else if ("CNPJ".equals(tipoDocumento.toUpperCase())) {
                enumTipoDocumentos = TipoDocumentos.CNPJ;
            } else {
                throw new Exception("Algo deu errado! Verificar tipo de documento informado");
            }

            Aplicacao.cliente = Conta.abrirConta(nome, documento, enumTipoDocumentos);

            System.out.println("\n---- Deu tudo certo... conta aberta! Seja benvindo(a) ----");
        } else{
            double dblValorDeposito;
            int respostaTipoConta;


            Scanner leitorTela = new Scanner(System.in);
            System.out.printf("Qual tipo de Conta? 1-CC | 2-POUPANÇA | 3-INVESTIMENTO (digite apenas o número): ");
            respostaTipoConta = leitorTela.nextInt();

            System.out.printf("Deseja fazer um depósito? (ex 1100,50)       : R$");
            dblValorDeposito = leitorTela.nextDouble();
            BigDecimal valorDeposito = new BigDecimal(dblValorDeposito);

            switch (respostaTipoConta){
                case 1 -> Conta.abrirConta(Aplicacao.cliente, TipoContas.CONTA_CORRENTE, valorDeposito);
                case 2 -> Conta.abrirConta(Aplicacao.cliente, TipoContas.CONTA_POUPANCA, valorDeposito);
                case 3 -> Conta.abrirConta(Aplicacao.cliente, TipoContas.CONTA_INVESTIMENTO, valorDeposito);
                default -> throw new Exception("Algo deu errado! :( - tipo de conta informado incorreto.");
            }
        }

    }

    public static void depositar(Cliente cliente) throws Exception{
        int idConta;
        double dblValorDeposito;

        Scanner leitorTela = new Scanner(System.in);
        System.out.printf("Informe o numero de identificação da conta    : ID ");
        idConta = leitorTela.nextInt();

        System.out.printf("Informe o valor do depósito (ex 1100,50)      : ");
        dblValorDeposito = leitorTela.nextDouble();
        BigDecimal valorDeposito = new BigDecimal(dblValorDeposito);

        String saldoAnterior = cliente.getContasCliente().get(idConta).consultarSaldoFormatadoEmMoedaLocal();
        cliente.getContasCliente().get(idConta).depositar(cliente, valorDeposito);
        String saldoAtual = cliente.getContasCliente().get(idConta).consultarSaldoFormatadoEmMoedaLocal();

        System.out.println("\n---- Depósito realizado com sucesso na conta " + idConta + "! ----");
        System.out.println("SALDO ANTERIOR: " + saldoAnterior);
        System.out.println("SALDO ATUAL   : " + saldoAtual);
        System.out.println("\n");
    }

    public static void sacar(Cliente cliente) throws Exception{
        int idConta;
        double dblValorSaque;

        Scanner leitorTela = new Scanner(System.in);
        System.out.printf("Informe o numero de identificação da conta : ID ");
        idConta = leitorTela.nextInt();

        System.out.printf("Informe o valor do saque (ex 1100,50)      : ");
        dblValorSaque = leitorTela.nextDouble();
        BigDecimal valorSaque = new BigDecimal(dblValorSaque);

        String saldoAnterior = cliente.getContasCliente().get(idConta).consultarSaldoFormatadoEmMoedaLocal();
        cliente.getContasCliente().get(idConta).sacar(cliente, valorSaque);
        String saldoAtual = cliente.getContasCliente().get(idConta).consultarSaldoFormatadoEmMoedaLocal();

        System.out.println("\n---- Saque realizado com sucesso na conta " + idConta + "! ----");
        System.out.println("SALDO ANTERIOR: " + saldoAnterior);
        System.out.println("SALDO ATUAL   : " + saldoAtual);
        System.out.println("\n");
    }

    public static void investir(Cliente cliente) throws Exception{
        int idConta;
        double dblValorInvestimento;

        Scanner leitorTela = new Scanner(System.in);
        System.out.printf("Informe o numero de identificação da conta    : ID ");
        idConta = leitorTela.nextInt();

        System.out.printf("Informe o valor do investimento (ex 1100,50)  : R$");
        dblValorInvestimento = leitorTela.nextDouble();
        BigDecimal valorInvestimento = new BigDecimal(dblValorInvestimento);

        String saldoAnterior = cliente.getContasCliente().get(idConta).consultarSaldoFormatadoEmMoedaLocal();
        cliente.getContasCliente().get(idConta).investir(cliente, valorInvestimento);
        String saldoAtual = cliente.getContasCliente().get(idConta).consultarSaldoFormatadoEmMoedaLocal();

        System.out.println("\n---- Investimento realizado com sucesso na conta " + idConta + "! ----");
        System.out.println("SALDO ANTERIOR: " + saldoAnterior);
        System.out.println("SALDO ATUAL   : " + saldoAtual);
        System.out.println("\n");
    }

    public static void transferir(Cliente cliente) throws Exception{
        int idConta;
        double dblValorTransferencia;

        Scanner leitorTela = new Scanner(System.in);
        System.out.printf("Informe o numero de identificação da conta : ID ");
        idConta = leitorTela.nextInt();

        System.out.printf("Informe valor da transferência (ex 1100,50): R$");
        dblValorTransferencia = leitorTela.nextDouble();
        BigDecimal valorSaque = new BigDecimal(dblValorTransferencia);

        String saldoAnterior = cliente.getContasCliente().get(idConta).consultarSaldoFormatadoEmMoedaLocal();
        cliente.getContasCliente().get(idConta).transferir(cliente, valorSaque);
        String saldoAtual = cliente.getContasCliente().get(idConta).consultarSaldoFormatadoEmMoedaLocal();

        System.out.println("\n---- Transferência realizada com sucesso na conta " + idConta + "! ----");
        System.out.println("SALDO ANTERIOR: " + saldoAnterior);
        System.out.println("SALDO ATUAL   : " + saldoAtual);
        System.out.println("\n");
    }

    public static void imprimirSaldos(Cliente cliente) throws Exception{
        cliente.imprimir();
    }

    private static void executarSaidaAplicacao(String mensagem){
        System.out.println("\n------------------------------------\n"
                            + mensagem
                            + "\n----------------------------------\n");
        System.exit(0);
    }
}
