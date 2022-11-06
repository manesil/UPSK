package br.com.upsk.banco.conta;

import br.com.upsk.banco.cliente.Cliente;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.function.BiFunction;

public class Conta {

    //Constantes para apoioar nas regras de negócio

    private final static BigDecimal VALOR_RENDIMENTO_POUPANCA_PF = new BigDecimal(0.01);
    private final static BigDecimal VALOR_RENDIMENTO_DEPOSITO_PF = new BigDecimal(0.015);
    private final static BigDecimal VALOR_RENDIMENTO_DEPOSITO_PJ = new BigDecimal(0.035);

    //Atributos (apenas na classe)
    private Integer idConta;
    private String tipo;
    private BigDecimal saldoConta = new BigDecimal(0);

    //Variaveis de trabalho
    Cliente cliente;

    //Construtor herdado da classe object
    //public Conta(){
        //precisa de gest set publico
        // get =     variavel = pegando o conteudo (GET)
        // set =     variavel (SET) = indicando um valor
    //}

    //Construtor especializado da classe
    public Conta(Integer idConta, String tipo){
        //get set pode ser private
        this.idConta = idConta;
        this.tipo = tipo;

    }

    //get e set => para aplicar o encapsulamento (evitando que as variáveis internas
    // sejam manipulados diretmente ou externamente)
    public String getTipo() {
        return tipo;
    }

    private void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Integer getIdConta() {
        return idConta;
    }

    private void setIdConta(Integer idConta) {
        this.idConta = idConta;
    }

    public BigDecimal getSaldoConta() {
        return saldoConta;
    }

    private void setSaldoConta(BigDecimal saldoConta) {
        this.saldoConta = saldoConta;
    }

    //TODO: Neri
    public void efetuarDepósito(Integer idConta, BigDecimal valorDeposito, String TipoConta){
        //pessoa física rende 1% poupança e 1,5% conta investimento
        //pessoa jurídica rende 3,5% conta investimento

        //Consultar a conta ok
        //verificar o tipo OK
        //verificar o tipo cliente

        //aplicar rendimento de acordo tipo conta e tipo cliente
        //atualizar saldo




    }

    //TODO: Bruna
    public void efetuarSaque(BigDecimal valorSaque, Integer idConta){
        //pessoa juridica paga 0,5%

    }

    //TODO: Andreia
    public void efetuarTransferencia(BigDecimal valorTransferencia, Integer idContaOrigem, Integer idContaDestino){
        //pessoa juridica paga 0,5% para transferir outra titularidade

    }

    public BigDecimal consultarSaldo(Integer idConta){

        return getSaldoConta();
    }

    public void abrirConta(String tipo){
        //conta poupança apenas para pessoa física
        //TODO Arraylist com abrirConta
    }

    //TODO: IZA Investir/resgate
    public void investirValor(BigDecimal valorInvestimento, Conta contaDestino){
        Integer idcontaOrigem = this.idConta;
        BigDecimal saldoDisponivel = consultarSaldo(idcontaOrigem);
        if (saldoDisponivel.doubleValue()>0){
            efetuarSaque(valorInvestimento, idcontaOrigem);
            efetuarDepósito(contaDestino.getIdConta(), valorInvestimento, contaDestino.getTipo());
        }
        else {
            System.out.println("Sem saldo na conta.Investimento não realizado.");
        }

    }

}
