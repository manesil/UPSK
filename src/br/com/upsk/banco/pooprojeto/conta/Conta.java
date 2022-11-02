package br.com.upsk.banco.pooprojeto.conta;

import br.com.upsk.banco.pooprojeto.cliente.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public abstract class Conta {

    private Integer idConta;
    private BigDecimal saldo;

    public static final int RANGE_CONTAS_INICIO = 500;
    public static final int RANGE_CONTAS_FIM = 800;
    public static final int SCALE = 2;


    public Cliente abrirConta(String nome, String documento, TipoDocumentos tipoDocumento) throws Exception {
        Cliente cliente = cadastrarCliente(nome, documento, tipoDocumento);

        Conta contaCorrente = new ContaCorrente();
        contaCorrente.setIdConta( gerarIdConta() );
        contaCorrente.setSaldo( new BigDecimal(0.00) );

        cliente.associarContaCliente(contaCorrente);

        return cliente;
    }

    public Cliente abrirConta(Cliente cliente, TipoContas tipoContas, BigDecimal valorDeposito) throws Exception{

        switch (tipoContas){
            case CONTA_CORRENTE -> {
                Conta contaCorrente = new ContaCorrente();
                contaCorrente.setIdConta( gerarIdConta() );
                contaCorrente.depositar( valorDeposito );

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
    public abstract void transferir(BigDecimal valorTransferencia) throws Exception;
    public abstract void depositar(BigDecimal valorDeposito) throws Exception;
    public abstract void aplicarRendimento() throws Exception;

    private Integer gerarIdConta(){
        Random random = new Random();
        return random.nextInt(RANGE_CONTAS_INICIO, RANGE_CONTAS_FIM);
    }

    protected Cliente cadastrarCliente(String nome, String documento, TipoDocumentos tipoDocumento) throws Exception {
        Cliente cliente = null;

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

}
