package br.com.upsk.banco.cliente;

import br.com.upsk.banco.conta.Conta;

import java.util.ArrayList;

public class Cliente {

    private String idCliente;
    private String tipoCliente;
    private String nomeCliente;
    public ArrayList<String> idConta;


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

    public void abrirConta(String tipo){
        Conta conta = new Conta();
        //TODO Arraylist com abrirConta
    }

}