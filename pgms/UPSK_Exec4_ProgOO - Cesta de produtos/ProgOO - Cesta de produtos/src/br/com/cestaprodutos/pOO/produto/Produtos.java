package br.com.cestaprodutos.pOO.produto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Produtos {

    public Map<String, Double> listaProd = new HashMap<String, Double>();
    public void novosProdutos(String prodDescr, Double prodPreco){

        listaProd.put(prodDescr, prodPreco);

    }

    public void classificarProdutos(){
        listaProd.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
    }

    public void produtoMaisBarato(){

        System.out.printf("O produto mais barato: " + listaProd.entrySet().stream().sorted(Map.Entry.comparingByValue()).findFirst());
    }

    public void produtoMaisCaro(){

        for (String key : listaProd.keySet()){
            //System.out.println(String.format("key: %s", key));

        }
        System.out.println("O produto mais caro: " + listaProd.entrySet().stream().findAny());

    }
}
