package br.com.upsk.banco.pooprojeto.cliente;

import java.math.BigDecimal;

public class ClientePF extends Cliente {

    public static final String TIPO_DOCUMENTO = "CPF";
    private static final BigDecimal RENDIMENTO_POUPANCA  = new BigDecimal(0.01);
    private static final BigDecimal RENDIMENTO_INVESTIMENTO  = new BigDecimal(0.015);

    public ClientePF(String nomeCliente, String documento) throws Exception {
        super(nomeCliente, documento);
    }
}
