package main;

import model.*;
import util.SQLGenerator;
import persistence.JPAUtil;

import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("Rafael", 10000, 20.0);
        FuncionarioSenior senior = new FuncionarioSenior("Maria", 45, 30.0, 50.0);
        FuncionarioEstagiario estagiario = new FuncionarioEstagiario("Pedro", 30, 15.0);
        FuncionarioGerente gerente = new FuncionarioGerente("Rodrigo", 40, 50.0, 2000.0);
        FuncionarioTerceirizado terceirizado = new FuncionarioTerceirizado("José", 35, 25.0, 500.0);

        System.out.println("=== Informações dos Funcionários ===");
        funcionario.imprimirInformacao();
        System.out.println();
        senior.imprimirInformacao();
        System.out.println();
        estagiario.imprimirInformacao();
        System.out.println();
        gerente.imprimirInformacao();
        System.out.println();
        terceirizado.imprimirInformacao();
        System.out.println();

        String sql = SQLGenerator.generateSelectSQL(Funcionario.class);
        System.out.println("SQL gerado para selecionar todos os registros:");
        System.out.println(sql);

        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            System.out.println("\n[CREATE] Inserindo funcionários no banco de dados...");
            em.persist(funcionario);
            em.persist(senior);
            em.persist(estagiario);
            em.persist(gerente);
            em.persist(terceirizado);
            em.getTransaction().commit();
            System.out.println("SQL de INSERT simulados executados.");

            System.out.println("\n[READ] Selecionando funcionários do banco de dados...");
            System.out.println(sql);

            System.out.println("\n[UPDATE] Atualizando informações do funcionário...");
            em.getTransaction().begin();
            Funcionario funcBanco = em.find(Funcionario.class, funcionario.getId());
            if (funcBanco != null) {
                em.merge(funcBanco);
            }
            em.getTransaction().commit();
            System.out.println("SQL de UPDATE simulados executados.");

            System.out.println("\n[DELETE] Removendo funcionário do banco de dados...");
            em.getTransaction().begin();
            em.getTransaction().commit();
            System.out.println("SQL de DELETE simulados executados.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
