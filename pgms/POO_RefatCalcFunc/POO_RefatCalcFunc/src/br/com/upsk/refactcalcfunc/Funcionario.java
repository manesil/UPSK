package br.com.upsk.refactcalcfunc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Funcionario {

    private static final int MEDIA_DIAS_DO_MES = 30;
    private String nome;
    private String cpf;
    private BigDecimal salarioBase;

    public Funcionario(){

    }
    public Funcionario(String nome, String cpf){
        this(nome,cpf, BigDecimal.valueOf(0));
    }
    public Funcionario(String nome, String cpf, BigDecimal salarioBase){
        this.nome = nome;
        this.cpf=cpf;
        this.salarioBase = salarioBase;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public BigDecimal getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(BigDecimal salarioBase) {
        this.salarioBase = salarioBase;
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

    public BigDecimal ValorProporcionalSalario(int qtdDias){

        BigDecimal vlrQtdDiasMes  = new BigDecimal(MEDIA_DIAS_DO_MES);
        BigDecimal vlrQtdDias     = new BigDecimal(qtdDias);
        BigDecimal vlrSalarioBase = new BigDecimal(getSalarioBase().doubleValue());
        BigDecimal vlrSalarioDia  = new BigDecimal(0);

        vlrSalarioDia = vlrSalarioBase.divide(vlrQtdDiasMes,2, RoundingMode.HALF_UP);
        vlrSalarioDia = vlrSalarioDia.multiply(vlrQtdDias);
        return vlrSalarioDia;
    }

}
