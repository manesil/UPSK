package br.com.upsk.banco.pooprojeto.conta;

import br.com.upsk.banco.pooprojeto.cliente.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Random;

public abstract class Conta {

    private Integer idConta;
    private BigDecimal saldo;
    protected String labelConta;

    public static final int RANGE_CONTAS_INICIO = 500;
    public static final int RANGE_CONTAS_FIM = 800;
    public static final int SCALE = 2;


    public static Cliente abrirConta(String nome, String documento, TipoDocumentos tipoDocumento) throws Exception {
        Cliente cliente = cadastrarCliente(nome, documento, tipoDocumento);

        Conta contaCorrente = new ContaCorrente();
        contaCorrente.setIdConta( gerarIdConta() );
        contaCorrente.setSaldo( new BigDecimal(0.00) );

        cliente.associarContaCliente(contaCorrente);

        return cliente;
    }

    public static Cliente abrirConta(Cliente cliente, TipoContas tipoContas, BigDecimal valorDeposito) throws Exception{

        switch (tipoContas){
            case CONTA_CORRENTE -> {
                Conta contaCorrente = new ContaCorrente();
                contaCorrente.setIdConta( gerarIdConta() );
                contaCorrente.depositar( cliente, valorDeposito );

                cliente.associarContaCliente(contaCorrente);
            }
            case CONTA_POUPANCA -> {
                System.out.println("PENDENTE IMPLEMENTAR ABERTURA " + tipoContas);

                if (cliente instanceof ClientePJ){
                    System.out.println("LEMBRANDO QUE CLIENTEPJ NAO ABRE CONTA POUPANCA");
                }
            }
            case CONTA_INVESTIMENTO -> {
                System.out.println("PENDENTE IMPLEMENTAR ABERTURA " + tipoContas);
            }
            default -> throw new Exception("ERRO: Nao foi possivel abrir uma nova conta para o tipoinformado");
        }

        return cliente;
    }

    public abstract void sacar(Cliente cliente, BigDecimal valorSaque) throws Exception;
    public abstract void transferir(Cliente cliente, BigDecimal valorTransferencia) throws Exception;
    public abstract void depositar(Cliente cliente, BigDecimal valorDeposito) throws Exception;
    public abstract void investir(Cliente cliente, BigDecimal valorInvestimento) throws Exception;

    private static Integer gerarIdConta(){
        Random random = new Random();
        return random.nextInt(RANGE_CONTAS_INICIO, RANGE_CONTAS_FIM);
    }

    protected static Cliente cadastrarCliente(String nome, String documento, TipoDocumentos tipoDocumento) throws Exception {
        Cliente cliente = null;
        String documentoFormatado;
        switch (tipoDocumento){
            case CPF -> {
                cliente = new ClientePF(nome, documento);
            }
            case CNPJ -> {
                cliente = new ClientePJ(nome, documento);
            }
            default -> throw new Exception("ERRO: Falha na abertura de conta - Cadastro do cliente");
        }
        return cliente;
    }

    protected void setIdConta(Integer idConta) {
        this.idConta = idConta;
    }

    protected void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    protected void atualizarSaldo(BigDecimal valorPararAtualizarSaldo){
        if (valorPararAtualizarSaldo != null)
            this.setSaldo(valorPararAtualizarSaldo.setScale(SCALE, RoundingMode.UP));
        else
            this.setSaldo(new BigDecimal(0.00));
    }

    public String getLabelConta() {
        return labelConta;
    }

    protected void setLabelConta(String labelConta) {
        this.labelConta = labelConta;
    }

    public BigDecimal consultarSaldo() {
        if (this.saldo != null) {
            return saldo.setScale(SCALE, RoundingMode.UP);
        }else{
            return new BigDecimal(0.00);
        }
    }

    public Integer getIdConta() {
        return idConta;
    }

    public Conta getConta(Integer idConta, HashMap<Integer, Conta> hashContas) throws Exception{
        Conta conta = null;
        if (hashContas != null && hashContas.containsKey(idConta)) {
            conta = hashContas.get(idConta);
        } else {
            throw new Exception("INFO: Conta informada inexistente. Favor verificar!");
        }

        return conta;
    }

}
