package br.com.upsk.mergelistas;

import java.util.*;

public class MergeListas {

    public static void main(String[] args) {

       List listamontada1 =  montaLista1();
       List listamontada2 =  montaLista2();

       mergeLista(listamontada1, listamontada2);
    }

    private static List montaLista1(){
        String lista = "1,2,3,4";
        return Arrays.asList(lista.split(","));
    }
    private static List montaLista2(){
        String lista = "2,5";
        return Arrays.asList(lista.split(","));
    }

    private static void mergeLista(List<String> lista1, List<String> lista2){
        HashSet<String> listaMerge = new HashSet<String>();
        List<String> listMerge2 = new ArrayList<>();

        listaMerge.addAll(lista1);
        listaMerge.addAll(lista2);

        listMerge2.addAll(listaMerge);


        System.out.println("Final do merge");
        System.out.println("Lista 1:" + lista1);
        System.out.println("Lista 2:" + lista2);
        //Collections.sort(listMerge2);
        Collections.reverse(listMerge2);
        System.out.println("as listas foram agrupadas em ordem decrecente e sem duplicidade");
        System.out.println(listMerge2);
    }

}
