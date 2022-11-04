package br.com.upsk.banco.pooprojeto.cliente;

import br.com.upsk.banco.pooprojeto.conta.Conta;

import java.math.BigDecimal;
import java.util.Map;

public class ClientePJ extends Cliente{

    public static final String TIPO_DOCUMENTO = "CNPJ";
    public static final BigDecimal TAXA_MOVIMENTACAO = new BigDecimal(0.005);
    public static final BigDecimal RENDIMENTO_INVESTIMENTO  = new BigDecimal(0.035);

    public ClientePJ(String nomeCliente, String documento) throws Exception {
        super(nomeCliente, documento);
        String documentoFormatado = validarEFormatarDocumento(documento);
        this.setDocumento(documentoFormatado);
    }

    @Override
    public String validarEFormatarDocumento(String documento) throws Exception{
        if (documento.length() != 14){
            throw new Exception("CNPJ inválido... precisa conter 14 numeros - sem separadores");
        }

        StringBuilder cpfBlocos = new StringBuilder();
        char[] charBloco = documento.toCharArray();

        for (int i = 0; i < charBloco.length; i++) {
            if (i ==1) {
                cpfBlocos.append(charBloco[i]).append(".");
            } else if (i == 4){
                cpfBlocos.append(charBloco[i]).append(".");
            } else if (i == 7){
                cpfBlocos.append(charBloco[i]).append("/");
            } else if (i == 11){
                cpfBlocos.append(charBloco[i]).append("-");
            } else {
                cpfBlocos.append(charBloco[i]);
            }
        }
        return cpfBlocos.toString();
    }

    @Override
    public void imprimir() {
        super.imprimir();
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("Identificação do Cliente       : ").append(this.getIdCliente()).append("\n");
        sb.append("Nome do Cliente                : ").append(this.getNomeCliente()).append("\n");
        sb.append("Documento do Cliente           : ").append(this.getDocumento()).append(" (Tipo: ").append(TIPO_DOCUMENTO).append(")\n");
        sb.append("---Conta(s) do Cliente         : \n\n");

        for (Map.Entry<Integer, Conta> contas : this.getContasCliente().entrySet()) {
            Conta conta = contas.getValue();
            sb.append("------>Identificação da Conta  : ").append(conta.getIdConta()).append("\n");
            sb.append("------>Tipo da Conta           : ").append(conta.getLabelConta()).append("\n");
            sb.append("------>Saldo da Conta          : ").append(conta.consultarSaldoFormatadoEmMoedaLocal()).append("\n");
            sb.append("-----------------------------------------------------------------\n");
        }

        sb.append("\n");

        System.out.println(sb);
    }
}
