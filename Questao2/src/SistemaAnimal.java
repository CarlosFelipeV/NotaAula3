import java.util.Scanner;

class Animal {
    protected String nome;
    protected String raca;

    public Animal() {
        this.nome = "Desconhecido";
        this.raca = "Desconhecida";
    }

    public Animal(String nome) {
        this.nome = nome;
        this.raca = "Desconhecida";
    }

    public void caminha() {
        System.out.println(nome + " está caminhando.");
    }
}

class Cachorro extends Animal {

    public Cachorro(String nome) {
        super(nome);
    }

    public void late() {
        System.out.println(nome + " está latindo: Au au!");
    }
}

class Gato extends Animal {

    public Gato(String nome) {
        super(nome);
    }

    public void mia() {
        System.out.println(nome + " está miando: Miau!");
    }
}

public class SistemaAnimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do cachorro: ");
        String nomeCachorro = scanner.nextLine();
        Cachorro cachorro = new Cachorro(nomeCachorro);
        cachorro.caminha();
        cachorro.late();

        System.out.print("\nDigite o nome do gato: ");
        String nomeGato = scanner.nextLine();
        Gato gato = new Gato(nomeGato);
        gato.caminha();
        gato.mia();

        scanner.close();
    }
}
