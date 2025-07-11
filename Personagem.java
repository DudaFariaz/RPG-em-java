import java.util.Locale;
import java.util.Scanner;

public class Personagem {
    String nome;
    String classe;
    int nivel;
    int vida;
    int mana;
    int forca;

    public Personagem(String nomePerso, String classePerso) {
        nome = nomePerso;
        classe = classePerso.toLowerCase();
        nivel = 1;
        vida = 100;

        switch (classe) {
            case "mago":
                mana = 100;
                forca = 5;
                break;
            case "guerreiro":
                mana = 0;
                forca = 50;
                break;
            case "arqueiro":
                mana = 0;
                forca = 35;
                break;
            default:
                System.out.println("Classe inválida!");
                mana = 0;
                forca = 0;
                break;
        }
        System.out.println("Personagem criado: " + nome + " (" + classe + ")");
    }

    public void atacar() {
        switch (classe) {
            case "guerreiro":
                System.out.println(nome + " ataca com sua espada! Causando " + forca + " de dano.");
                break;
            case "mago":
                System.out.println(nome + " lança uma bola de fogo! Causando " + forca + " de dano.");
                break;
            case "arqueiro":
                System.out.println(nome + " dispara uma flecha certeira! Causando " + forca + " de dano.");
                break;
        }
    }

    public void receberDano(int dano) {
        vida -= dano;
        if (vida < 0) vida = 0;
        System.out.println(nome + " recebeu " + dano + " de dano. Vida atual: " + vida);
    }

    public void usarHabilidadeEspecial() {
        switch (classe) {
            case "guerreiro":
                System.out.println(nome + " usou Golpe Poderoso! Força aumentada temporariamente.");
                break;
            case "mago":
                if (mana >= 20) {
                    mana -= 20;
                    System.out.println(nome + " usou Tempestade Arcana! Mana restante: " + mana);
                } else {
                    System.out.println(nome + " não tem mana suficiente!");
                }
                break;
            case "arqueiro":
                System.out.println(nome + " usou Chuva de Flechas!");
                break;
        }
    }

    public void subirNivel() {
        nivel++;
        vida = Math.min(vida + 10, 100);
        forca += 1;
        if (classe.equals("mago")) {
            mana = Math.min(mana + 10, 100);
        }
        System.out.println(nome + " subiu de nível! Agora está no nível " + nivel + ".");
    }

    public void mostrarStatus() {
        System.out.print("Status do " + nome + ": Classe: " + classe + ", Nível: " + nivel + ", Vida: " + vida + ", Força: " + forca);
        if (classe.equals("mago")) {
            System.out.print(", Mana: " + mana);
        }
        System.out.println();
    }

    public void desenharPersonagem() {
        System.out.println("\nDesenho do personagem " + nome + ":");
        switch (classe) {
            case "guerreiro":
                System.out.println("  O==|:::::::::::::::>");
                System.out.println("   |");
                System.out.println("  / \\");
                break;
            case "mago":
                System.out.println("    *");
                System.out.println("   /*\\");
                System.out.println("  /* *\\");
                System.out.println("   |||");
                break;
            case "arqueiro":
                System.out.println("   )  ");
                System.out.println("  /|> ");
                System.out.println("  / \\ ");
                break;
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));
        Scanner scanner = new Scanner(System.in);

        // Criar Personagem 1
        System.out.print("Digite o nome do personagem 1: ");
        String nome1 = scanner.nextLine();
        System.out.print("Digite a classe do personagem 1 (guerreiro, mago, arqueiro): ");
        String classe1 = scanner.nextLine();
        Personagem p1 = new Personagem(nome1, classe1);

        // Criar Personagem 2
        System.out.print("\nDigite o nome do personagem 2: ");
        String nome2 = scanner.nextLine();
        System.out.print("Digite a classe do personagem 2 (guerreiro, mago, arqueiro): ");
        String classe2 = scanner.nextLine();
        Personagem p2 = new Personagem(nome2, classe2);

        // Mostrar status iniciais
        System.out.println("\nStatus iniciais:");
        p1.mostrarStatus();
        p2.mostrarStatus();

        // Mostrar desenhos
        p1.desenharPersonagem();
        p2.desenharPersonagem();

        // Interação: P1 ataca P2
        System.out.println("\n" + p1.nome + " ataca " + p2.nome + ":");
        p1.atacar();
        p2.receberDano(p1.forca);

        // P2 usa habilidade especial
        System.out.println("\n" + p2.nome + " usa habilidade especial:");
        p2.usarHabilidadeEspecial();

        // P2 ataca P1
        System.out.println("\n" + p2.nome + " ataca " + p1.nome + ":");
        p2.atacar();
        p1.receberDano(p2.forca);

        // Subir nível dos dois
        p1.subirNivel();
        p2.subirNivel();

        // Mostrar status finais
        System.out.println("\nStatus finais:");
        p1.mostrarStatus();
        p2.mostrarStatus();

        scanner.close();
    }
}
