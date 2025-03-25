package model;

import javax.persistence.Entity;

@Entity
public class FuncionarioGerente extends Funcionario {
    private double bonusMensal;

    public FuncionarioGerente() {}

    public FuncionarioGerente(String nome, int horasTrabalhadas, double valorPorHora, double bonusMensal) {
        super(nome, horasTrabalhadas, valorPorHora);
        this.bonusMensal = bonusMensal;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + bonusMensal;
    }

    @Override
    public void imprimirInformacao() {
        super.imprimirInformacao();
        System.out.println("Bônus Mensal: " + bonusMensal);
    }

    public double getBonusMensal() {
        return bonusMensal;
    }

    public void setBonusMensal(double bonusMensal) {
        this.bonusMensal = bonusMensal;
    }
}
