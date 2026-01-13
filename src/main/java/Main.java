import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inicialização do Jogo via Singleton
        Jogo jogo = Jogo.getInstancia();
        jogo.adicionarObservador(new ConsoleObservador());

        // Factory Method Usage
        FabricaTabuleiro fabrica = new FabricaTabuleiro();
        jogo.setTabuleiro(fabrica.criarTabuleiro());

        // Command Pattern Initialization
        Map<String, Comando> comandos = new HashMap<>();
        comandos.put("jogar", new ComandoJogar());
        comandos.put("sair", new ComandoSair());

        System.out.println("--- BANCO IMOBILIÁRIO (PDS - FASE 1 REFATORADA) ---");
        System.out.print("Digite o número de jogadores (2-6): ");
        int qtdJogadores = scanner.nextInt();
        scanner.nextLine();

        String[] cores = { "Branco", "Preto", "Azul", "Amarelo", "Verde", "Vermelho" };

        for (int i = 0; i < qtdJogadores; i++) {
            System.out.print("Nome do jogador " + (i + 1) + ": ");
            String nome = scanner.nextLine();
            jogo.adicionarJogador(new Jogador(nome, cores[i % cores.length]));
        }

        // --- GAME LOOP ---
        while (jogo.isJogoRolando()) {
            Jogador jogadorAtual = jogo.getJogadorAtual();

            System.out.println("\n------------------------------------------------");
            System.out.println("VEZ DE: " + jogadorAtual.getNome() + " (" + jogadorAtual.getCor() + ")");

            Espaco espacoAtual = jogo.getTabuleiro().get(jogadorAtual.getPosicao());
            System.out.println("Saldo: " + jogadorAtual.getSaldo() + " | Posição Atual: " + espacoAtual.getNome());

            System.out.println("[ENTER] para jogar o dado ou digite 'sair'...");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.isEmpty()) {
                input = "jogar";
            }

            Comando cmd = comandos.get(input);
            if (cmd != null) {
                cmd.executar();
            } else {
                System.out.println(">> Comando inválido!");
            }
        }
        scanner.close();
    }
}