package br.com.upsk.banco.pooprojeto.conta;

import br.com.upsk.banco.pooprojeto.cliente.Cliente;
import br.com.upsk.banco.pooprojeto.cliente.ClientePF;
import br.com.upsk.banco.pooprojeto.cliente.ClientePJ;
import br.com.upsk.banco.pooprojeto.cliente.TipoContas;

import java.math.BigDecimal;

public class ContaInvestimento extends Conta{

    public ContaInvestimento(){
        super();
        this.setLabelConta(TipoContas.CONTA_INVESTIMENTO.toString());
    }

    @Override
    public void depositar(Cliente cliente, BigDecimal valorDeposito)  throws Exception{
        if ( valorDeposito!= null && valorDeposito.doubleValue() <= 0 ){
            throw new Exception("INFO: Valor de deposito invalido" );
        }

        double rendimento = pegarRendimento(cliente);
        double valorDepositoComRendimento = valorDeposito.doubleValue() + (valorDeposito.doubleValue() * rendimento);
        double novoSaldo =  this.consultarSaldo().doubleValue() + valorDepositoComRendimento;
        this.atualizarSaldo(new BigDecimal(novoSaldo));
    }

    @Override
    public void investir(Cliente cliente, BigDecimal valorInvestimento)  throws Exception{
        if ( valorInvestimento != null && valorInvestimento.doubleValue() <= 0 ){
            throw new Exception("INFO: Valor invalido para investimento na " + TipoContas.CONTA_INVESTIMENTO );
        }

        double rendimento = pegarRendimento(cliente);
        double novoSaldo = this.consultarSaldo().doubleValue() +valorInvestimento.doubleValue()+ (valorInvestimento.doubleValue() * rendimento);
        this.atualizarSaldo(new BigDecimal(novoSaldo));
    }

    private double pegarRendimento(Cliente cliente){
        double rendimento = 0.00;
        if (  cliente != null && cliente instanceof ClientePJ){
            rendimento = ((ClientePJ) cliente).RENDIMENTO_INVESTIMENTO.doubleValue();
        } else {
            rendimento = ((ClientePF) cliente).RENDIMENTO_INVESTIMENTO.doubleValue();
        }
        return rendimento;
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
        sb.append(", Tipo Conta= ").append(TipoContas.CONTA_INVESTIMENTO);
        sb.append(", saldo=R$").append(consultarSaldo());
        sb.append('}');
        return sb.toString();
    }
}
