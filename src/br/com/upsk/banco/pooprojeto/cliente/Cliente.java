package br.com.upsk.banco.pooprojeto.cliente;

import br.com.upsk.banco.pooprojeto.conta.Conta;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;

public abstract class Cliente {

    private Integer idCliente;
    private String nomeCliente;
    private String documento;
    private HashMap<Integer, Conta> contasCliente;
    private ArrayList<Integer> indexIdContas;

    public static final int TOTAL_DISPONIVEL_IDS = 100;
    public static final BigDecimal RENDIMENTO_POUPANCA  = new BigDecimal(0.01);

    public Cliente(String nomeCliente, String documento) throws Exception {

        this.idCliente = gerarIdCliente();
        this.setNomeCliente(nomeCliente);
        this.setDocumento(documento);

    }

    public abstract String validarEFormatarDocumento(String documento) throws Exception;

    public Integer getIdCliente() {
        return idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    protected void setNomeCliente(String nomeCliente) throws Exception {
        if (nomeCliente != "") {
            this.nomeCliente = nomeCliente.toUpperCase();
        } else{
            throw new Exception("ERRO: Nome do cliente precisa ser informado!");
        }
    }

    public String getDocumento() {
        return documento;
    }

    protected void setDocumento(String documento) throws Exception {
        if (documento != "") {
            this.documento = documento;
        } else{
            throw new Exception("ERRO: Numero do documento do cliente precisa ser informado!");
        }
    }

    public ArrayList<Integer> getIndexIdContas() {
        return indexIdContas;
    }

    private Integer gerarIdCliente(){
        Random random = new Random();
        return random.nextInt(TOTAL_DISPONIVEL_IDS);
    }

    public HashMap<Integer, Conta> getContasCliente() {
        return contasCliente;
    }

    public void associarContaCliente(Conta conta) throws Exception {
        if (this.getContasCliente() == null){
            this.contasCliente = new HashMap<>();
            this.indexIdContas = new ArrayList<>();
        }
        if (conta != null){
            this.contasCliente.put(conta.getIdConta(), conta);
            this.indexIdContas.add(conta.getIdConta());
        }else{
            throw new Exception("ERRO: Falha ao associar conta - inexistente ou com valor nulo");
        }
    }

    public void imprimir(){
        System.out.println(this);
        System.out.println("###########################################################");
        System.out.println("############### EXTRATO DE CONTAS DO CLIENTE ##############");
        System.out.println("###########################################################");

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
