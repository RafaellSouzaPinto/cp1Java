package model;

import javax.persistence.Entity;

@Entity
public class FuncionarioSenior extends Funcionario {
    private double bonusPorBloco;

    public FuncionarioSenior() {}

    public FuncionarioSenior(String nome, int horasTrabalhadas, double valorPorHora, double bonusPorBloco) {
        super(nome, horasTrabalhadas, valorPorHora);
        this.bonusPorBloco = bonusPorBloco;
    }

    @Override
    public double calcularSalario() {
        int blocos = getHorasTrabalhadas() / 15;
        double bonus = blocos * bonusPorBloco;
        return super.calcularSalario() + bonus;
    }

    @Override
    public void imprimirInformacao() {
        super.imprimirInformacao();
        System.out.println("Bônus por bloco de 15 horas: " + bonusPorBloco);
    }

    public double getBonusPorBloco() {
        return bonusPorBloco;
    }

    public void setBonusPorBloco(double bonusPorBloco) {
        this.bonusPorBloco = bonusPorBloco;
    }
}
