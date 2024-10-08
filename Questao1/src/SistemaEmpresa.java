import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

// Classe base: Funcionario
class Funcionario {
    protected String nome;
    protected String nasc;  // Data de nascimento no formato "dd/MM/yyyy"
    protected double salario;

    public Funcionario(String nome, String nasc, double salario) {
        this.nome = nome;
        this.nasc = nasc;
        this.salario = salario;
    }

    // Método para exibir o salário
    public void informarSalario() {
        System.out.println("Salário de " + nome + ": R$ " + salario);
    }

    // Método para calcular a idade com base na data de nascimento
    public int calcularIdade() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = LocalDate.parse(nasc, formatter);
        LocalDate hoje = LocalDate.now();
        Period periodo = Period.between(dataNascimento, hoje);
        return periodo.getYears();
    }

    // Exibir informações básicas do funcionário
    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Data de nascimento: " + nasc);
        System.out.println("Idade: " + calcularIdade() + " anos");
    }
}

// Subclasse: Gerente
class Gerente extends Funcionario {
    private String projeto;

    public Gerente(String nome, String nasc, double salario, String projeto) {
        super(nome, nasc, salario);
        this.projeto = projeto;
    }

    // Método específico para exibir o projeto
    public void informarProjeto() {
        System.out.println("Gerente " + nome + " está responsável pelo projeto: " + projeto);
    }
}

// Subclasse: Programador
class Programador extends Funcionario {
    private String linguagem;

    public Programador(String nome, String nasc, double salario, String linguagem) {
        super(nome, nasc, salario);
        this.linguagem = linguagem;
    }

    // Método específico para exibir a linguagem de programação
    public void informarLinguagem() {
        System.out.println("Programador " + nome + " trabalha com a linguagem: " + linguagem);
    }
}

// Classe principal para testar o sistema
public class SistemaEmpresa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Exemplo de criação de um gerente
        System.out.println("Cadastro do Gerente:");
        System.out.print("Nome: ");
        String nomeGerente = scanner.nextLine();
        System.out.print("Data de nascimento (dd/MM/yyyy): ");
        String nascGerente = scanner.nextLine();
        System.out.print("Salário: ");
        double salarioGerente = scanner.nextDouble();
        scanner.nextLine();  // Consumir a quebra de linha
        System.out.print("Projeto: ");
        String projetoGerente = scanner.nextLine();

        Gerente gerente = new Gerente(nomeGerente, nascGerente, salarioGerente, projetoGerente);

        // Exemplo de criação de um programador
        System.out.println("\nCadastro do Programador:");
        System.out.print("Nome: ");
        String nomeProgramador = scanner.nextLine();
        System.out.print("Data de nascimento (dd/MM/yyyy): ");
        String nascProgramador = scanner.nextLine();
        System.out.print("Salário: ");
        double salarioProgramador = scanner.nextDouble();
        scanner.nextLine();  // Consumir a quebra de linha
        System.out.print("Linguagem de Programação: ");
        String linguagemProgramador = scanner.nextLine();

        Programador programador = new Programador(nomeProgramador, nascProgramador, salarioProgramador, linguagemProgramador);

        // Exibir as informações do gerente e do programador
        System.out.println("\nInformações do Gerente:");
        gerente.exibirInformacoes();
        gerente.informarSalario();
        gerente.informarProjeto();

        System.out.println("\nInformações do Programador:");
        programador.exibirInformacoes();
        programador.informarSalario();
        programador.informarLinguagem();

        scanner.close();
    }
}
