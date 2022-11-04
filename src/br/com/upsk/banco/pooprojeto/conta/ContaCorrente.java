package br.com.upsk.banco.pooprojeto.conta;

import br.com.upsk.banco.pooprojeto.cliente.Cliente;
import br.com.upsk.banco.pooprojeto.cliente.TipoContas;

import java.math.BigDecimal;

public class ContaCorrente extends Conta {

    public ContaCorrente(){
        super();
        this.setLabelConta(TipoContas.CONTA_CORRENTE.toString());
    }

    @Override
    public void depositar(Cliente cliente, BigDecimal valorDeposito)  throws Exception{
        if ( valorDeposito!= null && valorDeposito.doubleValue() <= 0 ){
            throw new Exception("INFO: Valor de deposito invalido" );
        }

        double novoSaldo =  this.consultarSaldo().doubleValue() + valorDeposito.doubleValue();
        this.atualizarSaldo(new BigDecimal(novoSaldo));
    }

    @Override
    public void investir(Cliente cliente, BigDecimal valorInvestimento)  throws Exception{

        throw new Exception("ERRO: Não existe a função de investimento para " + this.getLabelConta());
    }

    @Override
    protected void setIdConta(Integer idConta) {
        super.setIdConta(idConta);
    }

    @Override
    protected void setSaldo(BigDecimal saldo) {
        super.setSaldo(saldo);
    }

    @Override
    public Integer getIdConta() {
        return super.getIdConta();
    }

    @Override
    public String getLabelConta() {
        return super.getLabelConta();
    }

    @Override
    protected void setLabelConta(String labelConta) {
        super.setLabelConta(labelConta);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Conta{");
        sb.append("idConta=").append(getIdConta());
        sb.append(", Tipo Conta= ").append(TipoContas.CONTA_CORRENTE);
        sb.append(", saldo=R$").append(consultarSaldo());
        sb.append('}');
        return sb.toString();
    }

}
