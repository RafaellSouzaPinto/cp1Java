package model;

import javax.persistence.Entity;

@Entity
public class FuncionarioTerceirizado extends Funcionario {
    private double custoAdicional;

    public FuncionarioTerceirizado() {}

    public FuncionarioTerceirizado(String nome, int horasTrabalhadas, double valorPorHora, double custoAdicional) {
        super(nome, horasTrabalhadas, valorPorHora);
        this.custoAdicional = custoAdicional;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + custoAdicional;
    }

    @Override
    public void imprimirInformacao() {
        super.imprimirInformacao();
        System.out.println("Custo Adicional: " + custoAdicional);
    }

    public double getCustoAdicional() {
        return custoAdicional;
    }

    public void setCustoAdicional(double custoAdicional) {
        this.custoAdicional = custoAdicional;
    }
}
