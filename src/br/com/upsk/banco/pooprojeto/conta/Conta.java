package br.com.upsk.banco.pooprojeto.conta;

import br.com.upsk.banco.pooprojeto.cliente.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Objects;
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
                if (cliente instanceof ClientePJ){
                    System.out.println("\n### LEMBRANDO QUE CLIENTE PJ NAO ABRE CONTA POUPANCA!!! ###\n");
                    break;
                }

                Conta contaPoupanca = new ContaPoupanca();
                contaPoupanca.setIdConta( gerarIdConta() );
                contaPoupanca.depositar( cliente, valorDeposito );

                cliente.associarContaCliente(contaPoupanca);

            }
            case CONTA_INVESTIMENTO -> {
                Conta contaInvestimento = new ContaInvestimento();
                contaInvestimento.setIdConta( gerarIdConta() );
                contaInvestimento.depositar( cliente, valorDeposito );

                cliente.associarContaCliente(contaInvestimento);
            }
            default -> throw new Exception("ERRO: Nao foi possivel abrir uma nova conta para o tipo informado");
        }

        return cliente;
    }

    public abstract void depositar(Cliente cliente, BigDecimal valorDeposito) throws Exception;
    public abstract void investir(Cliente cliente, BigDecimal valorInvestimento) throws Exception;

    public void sacar(Cliente cliente, BigDecimal valorSaque)  throws Exception{
        if (   this.consultarSaldo().doubleValue() <= 0
                || this.consultarSaldo().doubleValue() < valorSaque.doubleValue() ){
            throw new Exception("INFO: Nao ha saldo suficiente na " + TipoContas.CONTA_POUPANCA);
        }

        double taxa = pegarTaxa(cliente);

        double novoSaldo = this.consultarSaldo().doubleValue();
        double imposto = valorSaque.doubleValue() * taxa;
        novoSaldo -= valorSaque.doubleValue() - imposto;

        this.atualizarSaldo(new BigDecimal(novoSaldo));
    }

    public void transferir(Cliente cliente, BigDecimal valorTransferencia)  throws Exception{
        if (   this.consultarSaldo().doubleValue() <= 0
                || this.consultarSaldo().doubleValue() < valorTransferencia.doubleValue() ){
            throw new Exception("INFO: Nao ha saldo suficiente para transferir o valor desejado" );
        }
        //comentario
        double taxa = pegarTaxa(cliente);

        double novoSaldo = this.consultarSaldo().doubleValue();
        double imposto = valorTransferencia.doubleValue() * taxa;
        novoSaldo -= valorTransferencia.doubleValue() - imposto;

        this.atualizarSaldo(new BigDecimal(novoSaldo));
    }

    private double pegarTaxa(Cliente cliente){
        double taxa = 0.00;
        if (cliente instanceof ClientePJ){
            taxa = - ClientePJ.TAXA_MOVIMENTACAO.doubleValue();
        }
        return taxa;
    }

    private static Integer gerarIdConta(){
        Random random = new Random();
        return random.nextInt(RANGE_CONTAS_INICIO, RANGE_CONTAS_FIM);
    }

    protected static Cliente cadastrarCliente(String nome, String documento, TipoDocumentos tipoDocumento) throws Exception {
        Cliente cliente;

        switch (tipoDocumento){
            case CPF -> cliente = new ClientePF(nome, documento);
            case CNPJ -> cliente = new ClientePJ(nome, documento);
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
        BigDecimal valorSaldo;
        if (this.saldo != null) {
            valorSaldo = this.saldo.setScale(SCALE, RoundingMode.UP);
        }else{
            valorSaldo = new BigDecimal(0.00);
        }

        return valorSaldo;
    }

    public String consultarSaldoFormatadoEmMoedaLocal() {
        String valorSaldo;
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        valorSaldo = nf.format(Objects.requireNonNullElseGet(this.saldo, () -> new BigDecimal(0.00)));

        return valorSaldo;
    }

    public Integer getIdConta() {
        return idConta;
    }

    public Conta getConta(Integer idConta, HashMap<Integer, Conta> hashContas) throws Exception{
        Conta conta;

        if (hashContas != null && hashContas.containsKey(idConta)) {
            conta = hashContas.get(idConta);
        } else {
            throw new Exception("INFO: Conta informada inexistente. Favor verificar!");
        }

        return conta;
    }

}
