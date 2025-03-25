RM557515 - Gustavo Morales Monção
RM555130 - Rafael de Souza Pinto

1. Introdução
  Este relatório descreve o funcionamento de um programa desenvolvido em Java para gerenciar funcionários, calcular seus salários e
gerar consultas SQL automaticamente utilizando Reflection API e Hibernate. O sistema implementa diferentes perfis de funcionários, cada um com regras específicas de cálculo salarial,
além de integrar um banco de dados Oracle SQL Developer para persistência dos dados.

2. Estrutura do Programa
  O programa é composto pelas seguintes principais classes e funcionalidades:

    2.1 Classe Funcionario
      Esta classe representa um funcionário genérico e contém os seguintes atributos:
         - nome (String): Nome do funcionário.
         - horasTrabalhadas (int): Número de horas trabalhadas pelo funcionário.
         - valorPorHora (double): Valor pago por cada hora trabalhada.

    2.1.1 Métodos da Classe Funcionario
      - calcularSalario(): Retorna o salário total do funcionário com base nas horas trabalhadas multiplicadas pelo valor da hora.
      - imprimirInformacao(): Exibe os detalhes do funcionário no console.
  
  2.2 Classe FuncionarioSenior (Subclasse de Funcionario)
    Esta subclasse representa um funcionário sênior que recebe um bônus a cada 15 horas trabalhadas.
    2.2.1 Sobrescrita de Métodos
      - calcularSalario(): Adiciona um bônus baseado nas horas trabalhadas.
      - imprimirInformacao(): Exibe as informações do funcionário incluindo o bônus recebido.

  2.3 Outras Subclasses de Funcionários
    Foram criadas subclasses adicionais para representar diferentes perfis de funcionários, cada uma com regras específicas de cálculo salarial. Exemplos de subclasses possíveis:
      
      1. FuncionarioEstagiario: Possui um limite máximo de horas de trabalho e recebe um salário reduzido.
      2. FuncionarioTerceirizado: Pode ter um acréscimo de percentual sobre o salário devido a taxas administrativas.
      3. FuncionarioGerente: Recebe um adicional fixo no salário por cargo de chefia.

  2.4 Classe TabelaFuncionario
    Esta classe é responsável por mapear os funcionários em uma tabela no banco de dados. Utiliza anotações para definir a estrutura da tabela e Reflection API para gerar consultas SQL automaticamente.
    2.4.1 Anotações Utilizadas
      - @Tabela(nome="TAB_FUNCIONARIO"): Define que a classe será mapeada na tabela TAB_FUNCIONARIO no banco de dados.
      - @Coluna(nome="NOME"): Mapeia um atributo ao nome da coluna no banco.
      - @Coluna(nome="HORAS_TRABALHADAS"): Mapeia o número de horas trabalhadas.
      - @Coluna(nome="VALOR_HORA"): Mapeia o valor por hora.

    2.4.2 Geração de Código SQL
      Utilizando Reflection API, o programa gera automaticamente os comandos SQL para operações no banco. Exemplos:

        - Exemplo 1 – Seleção de todos os funcionários
            SELECT * FROM TAB_FUNCIONARIO;
        - Exemplo 2 – Inserção de um funcionário
            INSERT INTO TAB_FUNCIONARIO (NOME, HORAS_TRABALHADAS, VALOR_HORA) VALUES ('João Silva', 40, 25.00);
        - Exemplo 3 – Atualização do salário de um funcionário
            UPDATE TAB_FUNCIONARIO SET VALOR_HORA = 30.00 WHERE NOME = 'João Silva';
        - Exemplo 4 – Remoção de um funcionário
            DELETE FROM TAB_FUNCIONARIO WHERE NOME = 'João Silva';

3. Persistência de Dados com Hibernate
  O programa utiliza Hibernate para a conexão e manipulação dos dados no banco Oracle SQL Developer. Para isso, são utilizados os seguintes conceitos:

    3.1 Entity Manager
      Gerencia as entidades e realiza operações de persistência, garantindo que os objetos Java correspondam aos registros no banco.

    3.2 Persistence Unit
      Define a configuração da conexão com o banco de dados através do arquivo persistence.xml.

    3.3 Persistence Context
      Mantém um contexto de persistência ativo, permitindo que objetos sejam monitorados e sincronizados automaticamente com o banco de dados.

4. Conclusão
  O sistema desenvolvido permite a gestão eficiente de funcionários, incluindo o cálculo de salários, criação de diferentes perfis e persistência dos dados em banco utilizando Hibernate.
A integração com Reflection API possibilita a geração dinâmica de comandos SQL, proporcionando flexibilidade e escalabilidade ao projeto.
