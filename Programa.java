import java.util.Locale;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Locale.setDefault(new Locale("pt", "BR"));

        // Personagem 1
        System.out.print("Digite o nome do personagem 1: ");
        String nome1 = scanner.nextLine();

        System.out.print("Digite a classe do personagem 1 (guerreiro, mago, arqueiro): ");
        String classe1 = scanner.nextLine();

        Personagem personagem1 = new Personagem(nome1, classe1);

        // Personagem 2
        System.out.print("\nDigite o nome do personagem 2: ");
        String nome2 = scanner.nextLine();

        System.out.print("Digite a classe do personagem 2 (guerreiro, mago, arqueiro): ");
        String classe2 = scanner.nextLine();

        Personagem personagem2 = new Personagem(nome2, classe2);

        // Mostrar status iniciais
        System.out.println("\nStatus inicial dos personagens:");
        personagem1.mostrarStatus();
        personagem2.mostrarStatus();


        // Personagem 1 ataca personagem 2
        personagem1.atacar();
        personagem2.receberDano(personagem1.forca);

        // Personagem 2 usa habilidade especial
        personagem2.usarHabilidadeEspecial();

        // Personagem 2 ataca personagem 1
        personagem2.atacar();
        personagem1.receberDano(personagem2.forca);

        // Mostrar status finais
        System.out.println("\nStatus final dos personagens:");
        personagem1.mostrarStatus();
        personagem2.mostrarStatus();

        scanner.close();
    }
}