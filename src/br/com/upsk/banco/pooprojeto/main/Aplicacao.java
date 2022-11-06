package br.com.upsk.banco.pooprojeto.main;

import br.com.upsk.banco.pooprojeto.cliente.Cliente;
import br.com.upsk.banco.pooprojeto.cliente.ClientePJ;
import br.com.upsk.banco.pooprojeto.cliente.TipoContas;
import br.com.upsk.banco.pooprojeto.cliente.TipoDocumentos;
import br.com.upsk.banco.pooprojeto.conta.Conta;

import java.math.BigDecimal;
import java.util.Scanner;

public class Aplicacao {

    private static Cliente cliente = null;
    private static final String ERRO_MENSAGEM_PADRAO = "Algo não funcionou bem :( ... Desculpe! Execute novamente a Aplicação";
    private static final String ATE_LOGO_MENSAGEM_PADRAO = "ATÉ LOGO!!!";

        private static final String ERRO_SALDO_INSUFICIENTE = "Saldo Insuficiente!";
    private static final String ERRO_MENSAGEM_CONTA = "Conta inexistente! Abra a conta primeiro.";

    public static void main(String[] args){

        Aplicacao.interagirMenu();
    }

    private static String inicializarMenu(){
        String resposta;
        StringBuilder sb = new StringBuilder();

        sb.append("OLÁ! ").append("\n");
        sb.append("---------------------------------------------------------------------\n");
        sb.append("1- Abrir Conta").append("\n");
        sb.append("2- Depositar").append("\n");
        sb.append("3- Sacar").append("\n");
        sb.append("4- Transferir").append("\n");
        sb.append("5- Investir").append("\n");
        sb.append("6- Consultar Saldo das Contas").append("\n");
        sb.append("7- Resgatar").append("\n");
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
            case "7" -> Aplicacao.selecionarOpcaoMenu_7(cliente);
            case "X" -> System.out.println(Aplicacao.ATE_LOGO_MENSAGEM_PADRAO);
        }
    }

    private static void  selecionarOpcaoMenu_1(){
        String resposta;

        try {
            Aplicacao.abrirConta();
            Aplicacao.cliente.imprimirResumido();

            resposta = Aplicacao.verificarSeDesejaContinuar();

            if ("N".equals(resposta)){
                System.out.println(Aplicacao.ATE_LOGO_MENSAGEM_PADRAO);
            }
            else interagirMenu();

        }catch (Exception e){
            Aplicacao.executarSaidaAplicacao(Aplicacao.ERRO_MENSAGEM_PADRAO);
        }

    }

    private static void selecionarOpcaoMenu_2(Cliente cliente){
        String resposta;
        if (cliente == null) {
            System.out.println(ERRO_MENSAGEM_CONTA);
            Aplicacao.selecionarOpcaoMenu_1();
        }
            try {
                Aplicacao.depositar(cliente);
                resposta = Aplicacao.verificarSeDesejaContinuar();

                if ("N".equals(resposta)) {
                    Aplicacao.executarSaidaAplicacao(Aplicacao.ATE_LOGO_MENSAGEM_PADRAO);
                } else interagirMenu();

            } catch (Exception e) {
                Aplicacao.executarSaidaAplicacao(Aplicacao.ERRO_MENSAGEM_PADRAO);
            }

    }

    private static void selecionarOpcaoMenu_3(Cliente cliente){
        String resposta;
        if (cliente == null) {
            System.out.println(ERRO_MENSAGEM_CONTA);
            Aplicacao.selecionarOpcaoMenu_1();
        }
        try {
            Aplicacao.sacar(cliente);
            resposta = Aplicacao.verificarSeDesejaContinuar();

            if ("N".equals(resposta)){
                Aplicacao.executarSaidaAplicacao(Aplicacao.ATE_LOGO_MENSAGEM_PADRAO);
            }
            else interagirMenu();

        }catch (Exception e){
            Aplicacao.executarSaidaAplicacao(Aplicacao.ERRO_MENSAGEM_PADRAO);
        }
    }

    private static void selecionarOpcaoMenu_4(Cliente cliente){
        String resposta;

        if (cliente == null) {
            System.out.println(ERRO_MENSAGEM_CONTA);
            Aplicacao.selecionarOpcaoMenu_1();
        }

        try {
            Aplicacao.transferir(cliente);
            resposta = Aplicacao.verificarSeDesejaContinuar();

            if ("N".equals(resposta)){
                Aplicacao.executarSaidaAplicacao(Aplicacao.ATE_LOGO_MENSAGEM_PADRAO);
            }
            else interagirMenu();

        }catch (Exception e){
            Aplicacao.executarSaidaAplicacao(Aplicacao.ERRO_MENSAGEM_PADRAO);
        }
    }

    private static void selecionarOpcaoMenu_5(Cliente cliente){
        String resposta;

        if (cliente == null) {
            System.out.println(ERRO_MENSAGEM_CONTA);
            Aplicacao.selecionarOpcaoMenu_1();
        }

        try {
            Aplicacao.investir(cliente);
            resposta = Aplicacao.verificarSeDesejaContinuar();

            if ("N".equals(resposta)){
                Aplicacao.executarSaidaAplicacao(Aplicacao.ATE_LOGO_MENSAGEM_PADRAO);
            }
            else interagirMenu();

        }catch (Exception e){
            Aplicacao.executarSaidaAplicacao(Aplicacao.ERRO_MENSAGEM_PADRAO);
        }
    }

    private static void selecionarOpcaoMenu_6(Cliente cliente){
        String resposta;

        if (cliente == null) {
            System.out.println(ERRO_MENSAGEM_CONTA);
            Aplicacao.selecionarOpcaoMenu_1();
        }

        try {
            Aplicacao.imprimirSaldos(cliente);
            resposta = Aplicacao.verificarSeDesejaContinuar();

            if ("N".equals(resposta)){
                Aplicacao.executarSaidaAplicacao(Aplicacao.ATE_LOGO_MENSAGEM_PADRAO);
            }
            else interagirMenu();

        }catch (Exception e){
            Aplicacao.executarSaidaAplicacao(Aplicacao.ERRO_MENSAGEM_PADRAO);
        }
    }

    private static void selecionarOpcaoMenu_7(Cliente cliente) {
        String resposta;
        if (cliente == null) {
            System.out.println(ERRO_MENSAGEM_CONTA);
        } else {
            try {
                Aplicacao.resgatar(cliente);
                resposta = Aplicacao.verificarSeDesejaContinuar();

                if ("N".equals(resposta)) {
                    Aplicacao.executarSaidaAplicacao(Aplicacao.ATE_LOGO_MENSAGEM_PADRAO);
                } else interagirMenu();

            } catch (Exception e) {
                Aplicacao.executarSaidaAplicacao(Aplicacao.ERRO_MENSAGEM_PADRAO);
            }
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
            if ("CPF".equalsIgnoreCase(tipoDocumento)) {
                enumTipoDocumentos = TipoDocumentos.CPF;
            } else if ("CNPJ".equalsIgnoreCase(tipoDocumento)) {
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

            if (cliente instanceof ClientePJ) {
                System.out.printf("Qual tipo de Conta? 1-CC | 3-INVESTIMENTO (digite apenas o número): ");
            } else {
                System.out.printf("Qual tipo de Conta? 1-CC | 2-POUPANÇA | 3-INVESTIMENTO (digite apenas o número): ");
            }

            respostaTipoConta = leitorTela.nextInt();

            System.out.printf("Deseja fazer um depósito? (ex 1100,50)       : R$ ");
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

        System.out.printf("Informe o valor do depósito (ex 1100,50)      : R$ ");
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

        System.out.printf("Informe o valor do saque (ex 1100,50)      : R$ ");
        dblValorSaque = leitorTela.nextDouble();
        BigDecimal valorSaque = new BigDecimal(dblValorSaque);

        String saldoAnterior = cliente.getContasCliente().get(idConta).consultarSaldoFormatadoEmMoedaLocal();

        if (verificaSaldoDisponivel(idConta,valorSaque)){
            cliente.getContasCliente().get(idConta).sacar(cliente, valorSaque);
            String saldoAtual = cliente.getContasCliente().get(idConta).consultarSaldoFormatadoEmMoedaLocal();

            System.out.println("\n---- Saque realizado com sucesso na conta " + idConta + "! ----");
            System.out.println("SALDO ANTERIOR: " + saldoAnterior);
            System.out.println("SALDO ATUAL   : " + saldoAtual);
            System.out.println("\n");
        }
    }

    public static void investir(Cliente cliente) throws Exception{
        int idContaOrigem;
        int idContaDestino;
        double dblValorInvestimento;

        Scanner leitorTela = new Scanner(System.in);
        System.out.printf("Informe o numero de identificação da conta origem  : ID ");
        idContaOrigem = leitorTela.nextInt();

        System.out.printf("Informe o numero de identificação da conta investimento ou poupança  : ID ");
        idContaDestino = leitorTela.nextInt();

        System.out.printf("Informe o valor do investimento (ex 1100,50)  : R$ ");
        dblValorInvestimento = leitorTela.nextDouble();
        BigDecimal valorInvestimento = new BigDecimal(dblValorInvestimento);

        String saldoAnteriorOrigem = cliente.getContasCliente().get(idContaOrigem).consultarSaldoFormatadoEmMoedaLocal();
        if (verificaSaldoDisponivel(idContaOrigem,valorInvestimento)){

            cliente.getContasCliente().get(idContaOrigem).sacar(cliente, valorInvestimento);
            String saldoAtualOrigem = cliente.getContasCliente().get(idContaOrigem).consultarSaldoFormatadoEmMoedaLocal();

            String saldoAnteriorDestino = cliente.getContasCliente().get(idContaDestino).consultarSaldoFormatadoEmMoedaLocal();
            cliente.getContasCliente().get(idContaDestino).investir(cliente, valorInvestimento);
            String saldoAtualDestino = cliente.getContasCliente().get(idContaDestino).consultarSaldoFormatadoEmMoedaLocal();

            //atualizado
            System.out.println("\n---- Investimento realizado com sucesso na conta " + idContaDestino + "! ----");
            System.out.println("SALDO ANTERIOR: " + saldoAnteriorDestino);
            System.out.println("SALDO ATUAL   : " + saldoAtualDestino);
            System.out.println("\n------------------- Sua conta corrente:  " + idContaOrigem + "! -------------");
            System.out.println("SALDO ANTERIOR: " + saldoAnteriorOrigem);
            System.out.println("SALDO ATUAL   : " + saldoAtualOrigem);
            System.out.println("\n");

        }
    }

    public static void resgatar(Cliente cliente) throws Exception{
        int idContaOrigem;
        int idContaDestino;
        double dblValorResgate;

        Scanner leitorTela = new Scanner(System.in);
        System.out.printf("Informe o numero de identificação da conta investimento ou poupança  : ID ");
        idContaOrigem = leitorTela.nextInt();

        System.out.printf("Informe o numero de identificação da conta destino  : ID ");
        idContaDestino = leitorTela.nextInt();

        System.out.printf("Informe o valor do resgate (ex 1100,50)  : R$ ");
        dblValorResgate = leitorTela.nextDouble();
        BigDecimal valorResgate = new BigDecimal(dblValorResgate);

        String saldoAnteriorOrigem = cliente.getContasCliente().get(idContaOrigem).consultarSaldoFormatadoEmMoedaLocal();

        if (verificaSaldoDisponivel(idContaOrigem,valorResgate)){
            cliente.getContasCliente().get(idContaOrigem).sacar(cliente, valorResgate);

            String saldoAtualOrigem = cliente.getContasCliente().get(idContaOrigem).consultarSaldoFormatadoEmMoedaLocal();

            String saldoAnteriorDestino = cliente.getContasCliente().get(idContaDestino).consultarSaldoFormatadoEmMoedaLocal();
            cliente.getContasCliente().get(idContaDestino).depositar(cliente, valorResgate);
            String saldoAtualDestino = cliente.getContasCliente().get(idContaDestino).consultarSaldoFormatadoEmMoedaLocal();

            //atualizado
            System.out.println("\n---- Resgate realizado com sucesso na conta " + idContaDestino + "! ----");
            System.out.println("SALDO ANTERIOR: " + saldoAnteriorDestino);
            System.out.println("SALDO ATUAL   : " + saldoAtualDestino);
            System.out.println("\n------------------- Sua conta de investimento/poupança:  " + idContaOrigem + "! -------------");
            System.out.println("SALDO ANTERIOR: " + saldoAnteriorOrigem);
            System.out.println("SALDO ATUAL   : " + saldoAtualOrigem);
            System.out.println("\n");
        }
    }
    public static void transferir(Cliente cliente) throws Exception{
        int idConta;
        double dblValorTransferencia;

        Scanner leitorTela = new Scanner(System.in);
        System.out.printf("Informe o numero de identificação da conta : ID ");
        idConta = leitorTela.nextInt();

        System.out.printf("Informe valor da transferência (ex 1100,50): R$ ");
        dblValorTransferencia = leitorTela.nextDouble();
        BigDecimal valorSaque = new BigDecimal(dblValorTransferencia);

        String saldoAnterior = cliente.getContasCliente().get(idConta).consultarSaldoFormatadoEmMoedaLocal();
        if (verificaSaldoDisponivel(idConta,valorSaque)) {
            cliente.getContasCliente().get(idConta).transferir(cliente, valorSaque);
            String saldoAtual = cliente.getContasCliente().get(idConta).consultarSaldoFormatadoEmMoedaLocal();

            System.out.println("\n---- Transferência realizada com sucesso na conta " + idConta + "! ----");
            System.out.println("SALDO ANTERIOR: " + saldoAnterior);
            System.out.println("SALDO ATUAL   : " + saldoAtual);
            System.out.println("\n");
        }
    }

    public static void imprimirSaldos(Cliente cliente){
        cliente.imprimir();
    }

    private static void executarSaidaAplicacao(String mensagem){
        System.out.println("\n------------------------------------\n"
                            + mensagem
                            + "\n----------------------------------\n");
        System.exit(0);
    }

    private static boolean verificaSaldoDisponivel(int idConta, BigDecimal valorSaque){
        BigDecimal valorSaldoCompara = cliente.getContasCliente().get(idConta).consultarSaldo();
        if (valorSaldoCompara.compareTo(valorSaque)<0){
            System.out.println(ERRO_SALDO_INSUFICIENTE);
            return false;
        }
        else {
            return true;
        }


    }
}
