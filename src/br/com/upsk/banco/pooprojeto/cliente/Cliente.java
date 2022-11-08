package br.com.upsk.banco.pooprojeto.cliente;

import br.com.upsk.banco.pooprojeto.conta.Conta;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.ArrayList;

public abstract class Cliente {

    private Integer idCliente;
    private String nomeCliente;
    private String documento;
    private HashMap<Integer, Conta> contasCliente;
    private ArrayList<Integer> indexIdContas;

    public static final int TOTAL_DISPONIVEL_IDS = 100;

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
        System.out.println("\n");
        System.out.println("###########################################################");
        System.out.println("############### EXTRATO DE CONTAS DO CLIENTE ##############");
        System.out.println("###########################################################");

    }

    public void imprimirResumido() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("---------------------- Resumo do cliente ------------------------\n");
        sb.append("Nome do Cliente            : ").append(this.getNomeCliente()).append("\n");

        for (Map.Entry<Integer, Conta> contas : this.getContasCliente().entrySet()) {
            Conta conta = contas.getValue();
            sb.append("------>Id da Conta         : ").append(conta.getIdConta()).append("\n");
            sb.append("------>Tipo da Conta       : ").append(conta.getLabelConta()).append("\n");
            sb.append("------>Saldo da Conta      : ").append(conta.consultarSaldoFormatadoEmMoedaLocal()).append("\n");
            sb.append("-----------------------------------------------------------------\n");
        }

        sb.append("\n");

        System.out.println(sb);
    }

    public boolean clientePossuiConta(Integer idConta){
        boolean clientePossuiConta = false;

        if (this.getContasCliente().containsKey(idConta)){
            clientePossuiConta = true;
        }

        return clientePossuiConta;
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
