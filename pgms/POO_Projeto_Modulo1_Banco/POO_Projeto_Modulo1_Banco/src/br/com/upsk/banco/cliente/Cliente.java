package br.com.upsk.banco.cliente;

import br.com.upsk.banco.conta.Conta;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

//TODO: IZA Chamadas metodo conta
public class Cliente {

    private String idCliente;
    private String tipoCliente;
    private String nomeCliente;
    private Conta conta;
    private ArrayList<Integer> contas = new ArrayList<>();

    public Cliente(){

    }

    public Cliente(String idCliente, String tipo, String nomeCliente){
        setIdCliente(idCliente);
        setTipoCliente(tipo);
        setNomeCliente(nomeCliente);
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Conta abrirConta(String tipo){
        Random idConta = new Random();
        Integer intIDConta = idConta.nextInt(1000);
        conta = new Conta(intIDConta,tipo);
        contas.add(intIDConta);
        return conta;
    }

    public void efetuarDeposito(Integer idConta, BigDecimal valorDeposito){
        conta.efetuarDeposito(idConta,valorDeposito,this.conta.getTipo());
    }

    public void efetuarSaque(Integer idConta, BigDecimal valorSaque){

        //System.out.println("idConta: " + idConta);
        //System.out.println("valorSaque: " + valorSaque);
        //System.out.println("TipoConta: " + this.conta.getTipo());
        conta.efetuarSaque(idConta,valorSaque,this.tipoCliente);

    }



}