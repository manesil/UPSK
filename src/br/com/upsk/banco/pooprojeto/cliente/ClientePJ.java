package br.com.upsk.banco.pooprojeto.cliente;

import java.math.BigDecimal;

public class ClientePJ extends Cliente{

    public static final String TIPO_DOCUMENTO = "CNPJ";
    public static final BigDecimal TAXA_MOVIMENTACAO = new BigDecimal(0.005);
    public static final BigDecimal RENDIMENTO_INVESTIMENTO  = new BigDecimal(0.035);

    public ClientePJ(String nomeCliente, String documento) throws Exception {
        super(nomeCliente, documento);
    }
}
