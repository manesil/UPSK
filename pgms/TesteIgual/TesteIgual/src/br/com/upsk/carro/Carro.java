package br.com.upsk.carro;

import java.util.Objects;

public class Carro {

    String modelo;
    String marca;
    Integer ano;
    int velocidade;

    public void AumentarVelocidade(){
        velocidade += 10;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Carro{");
        sb.append("modelo='").append(modelo).append('\'');
        sb.append(", marca='").append(marca).append('\'');
        sb.append(", ano=").append(ano);
        sb.append(", velocidade=").append(velocidade);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Carro carro = (Carro) o;

        if (velocidade != carro.velocidade) return false;
        if (!Objects.equals(modelo, carro.modelo)) return false;
        if (!Objects.equals(marca, carro.marca)) return false;
        return Objects.equals(ano, carro.ano);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelo, marca, ano, velocidade);
    }

}
