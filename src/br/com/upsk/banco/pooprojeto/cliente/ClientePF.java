package br.com.upsk.banco.pooprojeto.cliente;

import br.com.upsk.banco.pooprojeto.conta.Conta;

import java.math.BigDecimal;
import java.util.Map;

public class ClientePF extends Cliente {

    public static final String TIPO_DOCUMENTO = "CPF";
    public static final BigDecimal RENDIMENTO_INVESTIMENTO  = new BigDecimal(0.015);
    public static final BigDecimal RENDIMENTO_POUPANCA  = new BigDecimal(0.01);

    public ClientePF(String nomeCliente, String documento) throws Exception {
        super(nomeCliente, documento);
        String documentoFormatado = validarEFormatarDocumento(documento);
        this.setDocumento(documentoFormatado);
    }

    @Override
    public String validarEFormatarDocumento(String documento) throws Exception{
        if (documento.length() != 11){
            throw new Exception("CPF inválido... precisa conter 11 numeros - sem separadores");
        }

        StringBuilder cpfBlocos = new StringBuilder();
        char[] charBloco = documento.toCharArray();

        for (int i = 0; i < charBloco.length; i++) {
            if (i ==2) {
                cpfBlocos.append(charBloco[i]).append(".");
            } else if (i == 5){
                cpfBlocos.append(charBloco[i]).append(".");
            } else if (i == 8){
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
