package br.com.upsk.calcsalfuncionario;

public class Funcionario2 {

    public static String nome;
    public static String cpf;
    public static Double salarioBase;

    public static double salarioProporcional(int diasTrabalhado){

        double salDia;
        double salProporcional;

        salDia = salarioBase/30;
        salProporcional = salDia * diasTrabalhado;
        return salProporcional;

    }

}
