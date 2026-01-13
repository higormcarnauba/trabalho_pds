import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.List;

public class Main {

    static List<Espaco> tabuleiro = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Factory Method Usage
        FabricaTabuleiro fabrica = new FabricaTabuleiro();
        tabuleiro = fabrica.criarTabuleiro();

        System.out.println("--- BANCO IMOBILIÁRIO (PDS - FASE 1 REFATORADA) ---");
        System.out.print("Digite o número de jogadores (2-6): ");
        int qtdJogadores = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Jogador> jogadores = new ArrayList<>();

        String[] cores = { "Branco", "Preto", "Azul", "Amarelo", "Verde", "Vermelho" };

        for (int i = 0; i < qtdJogadores; i++) {
            System.out.print("Nome do jogador " + (i + 1) + ": ");
            String nome = scanner.nextLine();
            jogadores.add(new Jogador(nome, cores[i % cores.length]));
        }

        // --- GAME LOOP ---
        boolean jogoRolando = true;
        int turno = 0;
        Dado dado = new Dado();

        while (jogoRolando) {
            Jogador jogadorAtual = jogadores.get(turno % jogadores.size());

            System.out.println("\n------------------------------------------------");
            System.out.println("VEZ DE: " + jogadorAtual.getNome() + " (" + jogadorAtual.getCor() + ")");

            Espaco espacoAtual = tabuleiro.get(jogadorAtual.getPosicao());
            System.out.println("Saldo: " + jogadorAtual.getSaldo() + " | Posição Atual: " + espacoAtual.getNome());

            System.out.println("[ENTER] para jogar o dado ou digite 'sair'...");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("sair")) {
                break;
            }

            int valorDado = dado.jogar() + dado.jogar();
            System.out.println(">> Dados: " + valorDado);

            int novaPosicao = (jogadorAtual.getPosicao() + valorDado) % 40;

            if (novaPosicao < jogadorAtual.getPosicao()) {
                System.out.println(">> Passou pelo Início! Ganhou $200.");
                jogadorAtual.creditar(200);
            }
            jogadorAtual.setPosicao(novaPosicao);

            Espaco novoEspaco = tabuleiro.get(novaPosicao);
            System.out.println(">> Caiu em: " + novoEspaco.getNome() + " (" + novaPosicao + ")");

            // DELEGATION to Strategy Pattern logic inside Espaco
            novoEspaco.cair(jogadorAtual);

            if (jogadorAtual.getSaldo() < 0) {
                System.out.println("XXX " + jogadorAtual.getNome() + " FALIU! Fim de jogo. XXX");
                jogoRolando = false;
            }
            turno++;
        }
        scanner.close();
    }
}