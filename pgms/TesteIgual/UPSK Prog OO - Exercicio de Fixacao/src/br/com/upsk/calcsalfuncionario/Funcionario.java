package br.com.upsk.calcsalfuncionario;

public class Funcionario {

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Funcionario{");
        sb.append("nome='").append(nome).append('\'');
        sb.append(", cpf='").append(cpf).append('\'');
        sb.append(", salarioBase=").append(salarioBase);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Funcionario that = (Funcionario) o;

        if (!Objects.equals(nome, that.nome)) return false;
        if (!Objects.equals(cpf, that.cpf)) return false;
        return Objects.equals(salarioBase, that.salarioBase);
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (cpf != null ? cpf.hashCode() : 0);
        result = 31 * result + (salarioBase != null ? salarioBase.hashCode() : 0);
        return result;
    }
}
