package br.com.upsk.banco.pooprojeto.conta;

import br.com.upsk.banco.pooprojeto.cliente.Cliente;
import br.com.upsk.banco.pooprojeto.cliente.ClientePF;
import br.com.upsk.banco.pooprojeto.cliente.ClientePJ;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ContaCorrente extends Conta {

    public ContaCorrente(){
        super();
    }

    @Override
    public void sacar(Cliente cliente, BigDecimal valorSaque)  throws Exception{
        if (   this.consultarSaldo().doubleValue() <= 0
            || this.consultarSaldo().doubleValue() < valorSaque.doubleValue() ){
            throw new Exception("INFO: Nao ha saldo suficiente" );
        }

        double taxa = 0.00;

        if (  cliente != null
           && cliente instanceof ClientePJ){
            taxa = - ((ClientePJ) cliente).TAXA_MOVIMENTACAO.doubleValue();
        }

        double novoSaldo = this.consultarSaldo().doubleValue() - valorSaque.doubleValue();
        novoSaldo += novoSaldo * taxa;
        this.atualizarSaldo( new BigDecimal(novoSaldo).setScale(2, RoundingMode.UP) );

    }

    @Override
    public void transferir(BigDecimal valorTransferencia)  throws Exception{

    }

    @Override
    public void depositar(BigDecimal valorDeposito)  throws Exception{
        if ( valorDeposito!= null && valorDeposito.doubleValue() <= 0 ){
            throw new Exception("INFO: Valor de deposito invalido" );
        }

        this.atualizarSaldo(valorDeposito);
    }

    @Override
    public void aplicarRendimento()  throws Exception{

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
    public String toString() {
        final StringBuilder sb = new StringBuilder("Conta{");
        sb.append("idConta=").append(getIdConta());
        sb.append(", Tipo Conta= CC");
        sb.append(", saldo=R$").append(consultarSaldo());
        sb.append('}');
        return sb.toString();
    }
}
