package br.com.upsk.banco.pooprojeto.cliente;

import br.com.upsk.banco.pooprojeto.conta.Conta;

import java.util.Random;
import java.util.ArrayList;

public abstract class Cliente {

    private Integer idCliente;
    private String nomeCliente;
    private String documento;
    public ArrayList<Conta> contasCliente;

    public static final int TOTAL_DISPONIVEL_IDS = 100;

    public Cliente(String nomeCliente, String documento) throws Exception {

        this.idCliente = gerarIdCliente();
        this.setNomeCliente(nomeCliente);
        this.setDocumento(documento);

    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) throws Exception {
        if (nomeCliente != "") {
            this.nomeCliente = nomeCliente;
        } else{
            throw new Exception("ERRO: Nome do cliente precisa ser informado!");
        }
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) throws Exception {
        if (documento != "") {
            this.documento = documento;
        } else{
            throw new Exception("ERRO: Numero do documento do cliente precisa ser informado!");
        }
    }

    private Integer gerarIdCliente(){
        Random random = new Random();
        return random.nextInt(TOTAL_DISPONIVEL_IDS);
    }

    public ArrayList<Conta> getContasCliente() {
        return contasCliente;
    }

    public void associarContaCliente(Conta conta) throws Exception {
        if (this.getContasCliente() == null){
            this.contasCliente = new ArrayList<>();
        }
        if (conta != null){
            this.contasCliente.add(conta);
        }else{
            throw new Exception("ERRO: Falha ao associar conta - inexistente ou com valor nulo");
        }
    }

    public void imprimir(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cliente{");
        sb.append("idCliente=").append(idCliente);
        sb.append(", nomeCliente='").append(nomeCliente).append('\'');
        sb.append(", documento='").append(documento).append('\'');
        sb.append(", contasCliente=").append(contasCliente);
        sb.append('}');
        return sb.toString();
    }
}
