package model;

import javax.persistence.Entity;

@Entity
public class FuncionarioEstagiario extends Funcionario {
    public FuncionarioEstagiario() {}

    public FuncionarioEstagiario(String nome, int horasTrabalhadas, double valorPorHora) {
        super(nome, horasTrabalhadas, valorPorHora);
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() * 0.8;
    }

    @Override
    public void imprimirInformacao() {
        System.out.println("Funcionário Estagiário:");
        super.imprimirInformacao();
    }

}
