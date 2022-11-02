package br.com.upsk.banco.conta;

import java.math.BigDecimal;
import java.util.Objects;

public class Conta {

    private String idConta;
    private String tipo;
    private BigDecimal saldoConta = new BigDecimal();

    public Conta(){

    }

    public Conta(String idConta, String tipo, BigDecimal saldoConta){
        this.idConta = idConta;
        this.tipo = tipo;
        this.saldoConta = saldoConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getIdConta() {
        return idConta;
    }

    public void setIdConta(String idConta) {
        this.idConta = idConta;
    }

    public BigDecimal getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(BigDecimal saldoConta) {
        this.saldoConta = saldoConta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Conta conta = (Conta) o;

        if (!Objects.equals(idConta, conta.idConta)) return false;
        if (!Objects.equals(tipo, conta.tipo)) return false;
        return Objects.equals(saldoConta, conta.saldoConta);
    }

    @Override
    public int hashCode() {
        int result = idConta != null ? idConta.hashCode() : 0;
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        result = 31 * result + (saldoConta != null ? saldoConta.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Conta{");
        sb.append("idConta='").append(idConta).append('\'');
        sb.append(", tipo='").append(tipo).append('\'');
        sb.append(", saldoConta=").append(saldoConta);
        sb.append('}');
        return sb.toString();
    }

    public void EfetuarDepósito(BigDecimal valorDeposito, String idConta){
        //pessoa física rende 1% poupança e 1,5% conta investimento
        //pessoa jurídica rende 3,5% conta investimento
    }

    public void EfetuarSaque(BigDecimal valorSaque, String idConta){
        //pessoa juridica paga 0,5%

    }

    public void EfetuarTransferencia(BigDecimal valorTransferencia, String idContaOrigem, String idContaDestino){
        //pessoa juridica paga 0,5% para transferir outra titularidade

    }

    public BigDecimal ConsultarSaldo(String idConta){

    }


}
