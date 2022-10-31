package br.com.upsk.carro;

public class VerCarro {

    public static void main(String[] args) {

        Carro carro1 = new Carro();
        Carro carro2 = new Carro();

        carro1.marca = "Mit";
        carro1.modelo = "Outlander";
        carro1.ano = 2016;

        carro2.marca = "Mit";
        carro2.modelo = "Outlander";
        carro2.ano = 2016;
    /*
        carro1.marca = "GM";
        carro1.modelo = "Corsa";
        carro1.ano = 2009;
*/
        if (carro1.equals(carro2)){
            System.out.println("1- Carro1 = Carro2");
        }
        else {
            System.out.println("1 - Carro1 <> carro2");
        }

        if (carro1 == carro2){
            System.out.println("2 - Carro1 = Carro2 =>" + carro1 + " == " + carro2);
        }
        else {
            System.out.println("2 - Carro1 <> carro2 =>" + carro1 + " == " + carro2);
        }

        if (carro1.toString().equals(carro2.toString())){
            System.out.println("3 - Carro1 = Carro2 =>" + carro1.toString() + " == " + carro2.toString());
        }
        else {
            System.out.println("3 - Carro1 <> carro2 =>" + carro1.toString() + " == " + carro2.toString());
        }

        if (carro1.hashCode() == carro2.hashCode()){
            System.out.println("4 - Carro1 = Carro2 =>" + carro1.hashCode() + " == " + carro2.hashCode());
        }
        else {
            System.out.println("4 - Carro1 <> carro2 =>" + carro1.hashCode() + " == " + carro2.hashCode());
        }
    }


}
