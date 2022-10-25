package br.com.cestaprodutos.pOO;
import br.com.cestaprodutos.pOO.produto.Produtos;

import java.util.Scanner;

public class PesquisaPreco {

    public static final String MSG_PROD_DESCR = "Digite a descrição do produto: ";
    public static final String MSG_PROD_PRECO = "Digite o preço do produto: ";
    public static final String MSG_PERGUNTA_CONTINUA = "Deseja incluir mais produtos? 1 = 'Sim'";

    public static void main(String[] args) {
        Scanner capturaTela = new Scanner(System.in);
        String produtoDescr;
        Double produtoPreco;
        Integer msg=1;

        Produtos produto = new Produtos();

        while (msg == 1)  {
            System.out.println(MSG_PROD_DESCR);
            produtoDescr = capturaTela.next();
            System.out.println(MSG_PROD_PRECO);
            produtoPreco = capturaTela.nextDouble();

            produto.novosProdutos(produtoDescr,produtoPreco);

            System.out.println(MSG_PERGUNTA_CONTINUA);
            msg = capturaTela.nextInt();
        }

        produto.classificarProdutos();
        produto.produtoMaisBarato();
        produto.produtoMaisCaro();

    }
}
