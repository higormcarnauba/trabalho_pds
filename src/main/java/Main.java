import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<String> tabuleiro = new ArrayList<>();
    static int[] precos = new int[40];
    static int[] alugueis = new int[40];
    static String[] donos = new String[40]; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        inicializarTabuleiroComDadosReais(); 

        System.out.println("--- BANCO IMOBILIÁRIO (PDS - VERSÃO FASE 1) ---");
        System.out.print("Digite o número de jogadores (2-6): ");
        int qtdJogadores = scanner.nextInt();
        scanner.nextLine(); 

        ArrayList<jogador> jogadores = new ArrayList<>();
        String[] cores = {"Branco", "Preto", "Azul", "Amarelo", "Verde", "Vermelho"};
        
        for (int i = 0; i < qtdJogadores; i++) {
            System.out.print("Nome do jogador " + (i + 1) + ": ");
            String nome = scanner.nextLine();
            jogadores.add(new jogador(nome, cores[i % cores.length]));
        }

        boolean jogoRolando = true;
        int turno = 0;
        dado dado = new dado();

        while (jogoRolando) {
            jogador jogadorAtual = jogadores.get(turno % jogadores.size());
            
            System.out.println("\n------------------------------------------------");
            System.out.println("VEZ DE: " + jogadorAtual.nome + " (" + jogadorAtual.cor + ")");
            System.out.println("Saldo: " + jogadorAtual.saldo + " | Posição Atual: " + tabuleiro.get(jogadorAtual.posicao));
            System.out.println("[ENTER] para jogar o dado ou digite 'sair'...");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("sair")) {
                break;
            }

            int valorDado = dado.jogar() + dado.jogar();
            System.out.println(">> Dados: " + valorDado);
            
            int novaPosicao = (jogadorAtual.posicao + valorDado) % 40;
            if (novaPosicao < jogadorAtual.posicao) {
                System.out.println(">> Passou pelo Início! Ganhou $200.");
                jogadorAtual.saldo += 200;
            }
            jogadorAtual.posicao = novaPosicao;
            
            String nomeCasa = tabuleiro.get(novaPosicao);
            System.out.println(">> Caiu em: " + nomeCasa + " (" + novaPosicao + ")");

            gerenciarCasa(jogadorAtual, novaPosicao, scanner);

            if (jogadorAtual.saldo < 0) {
                System.out.println("XXX " + jogadorAtual.nome + " FALIU! Fim de jogo. XXX");
                jogoRolando = false;
            }
            turno++;
        }
        scanner.close();
    }

    private static void gerenciarCasa(jogador jogador, int pos, Scanner scanner) {
        if (precos[pos] == 0) {
            System.out.println(">> Apenas passeando... (Lógica de sorte/revés não implementada)");
            return;
        }

        String dono = donos[pos];
        int preco = precos[pos];
        int aluguel = alugueis[pos];

        if (dono == null) {
            System.out.println(">> Propriedade sem dono! Preço: $" + preco);
            if (jogador.saldo >= preco) {
                System.out.print(">> Deseja comprar " + tabuleiro.get(pos) + "? (s/n): ");
                String resp = scanner.nextLine();
                if (resp.equalsIgnoreCase("s")) {
                    jogador.saldo -= preco;
                    donos[pos] = jogador.nome;
                    System.out.println(">> Compra realizada com sucesso!");
                }
            } else {
                System.out.println(">> Saldo insuficiente para comprar.");
            }
        } else if (!dono.equals(jogador.nome)) {
            System.out.println(">> Propriedade de " + dono + "! Pague aluguel de $" + aluguel);
            jogador.saldo -= aluguel;
        } else {
            System.out.println(">> Você já é dono daqui.");
        }
    }

    private static void inicializarTabuleiroComDadosReais() {
        for (int i = 0; i < 40; i++) {
            tabuleiro.add("Especial / Sorte");
            precos[i] = 0;
            alugueis[i] = 0;
        }

        configurarCasa(0, "Ponto de Partida", 0, 0);
        configurarCasa(1, "Leblon", 100, 6);
        configurarCasa(2, "Sorte ou Revés", 0, 0);
        configurarCasa(3, "Av. Presidente Vargas", 60, 2);
        configurarCasa(4, "Av. Nossa Sra. de Copacabana", 60, 2);
        configurarCasa(5, "Companhia Ferroviária", 200, 50);
        configurarCasa(6, "Av. Brigadeiro Faria Lima", 240, 20);
        configurarCasa(7, "Companhia de Viação", 200, 50);
        configurarCasa(8, "Av. Rebouças", 220, 18);
        configurarCasa(9, "Av. 9 de Julho", 220, 18);
        configurarCasa(10, "Prisão (Visitante)", 0, 0);
        configurarCasa(11, "Av. Europa", 200, 16);
        configurarCasa(12, "Sorte ou Revés", 0, 0);
        configurarCasa(13, "Rua Augusta", 180, 14);
        configurarCasa(14, "Av. Pacaembu", 180, 14);
        configurarCasa(15, "Companhia de Táxi", 150, 40); 
        configurarCasa(16, "Sorte ou Revés", 0, 0);
        configurarCasa(17, "Interlagos", 350, 35);
        configurarCasa(18, "Lucros e Dividendos", 0, 0);
        configurarCasa(19, "Morumbi", 400, 50);
        configurarCasa(20, "Parada Livre", 0, 0);
        configurarCasa(21, "Flamengo", 120, 8); 
        configurarCasa(22, "Sorte ou Revés", 0, 0);
        configurarCasa(23, "Botafogo", 100, 6);
        configurarCasa(24, "Imposto de Renda", 0, 0);
        configurarCasa(25, "Companhia de Navegação", 150, 40);
        configurarCasa(26, "Av. Brasil", 160, 12);
        configurarCasa(27, "Sorte ou Revés", 0, 0);
        configurarCasa(28, "Av. Paulista", 140, 10);
        configurarCasa(29, "Jardim Europa", 140, 12);
        configurarCasa(30, "Vá para a Prisão", 0, 0);
        configurarCasa(31, "Copacabana", 260, 22);
        configurarCasa(32, "Companhia de Aviação", 200, 50); 
        configurarCasa(33, "Av. Vieira Souto", 320, 28);
        configurarCasa(34, "Av. Atlântica", 300, 26);
        configurarCasa(35, "Companhia de Táxi Aéreo", 200, 50); 
        configurarCasa(36, "Ipanema", 300, 26);
        configurarCasa(37, "Sorte ou Revés", 0, 0);
        configurarCasa(38, "Jardim Paulista", 280, 24);
        configurarCasa(39, "Brooklin", 260, 22);
    }

    private static void configurarCasa(int index, String nome, int preco, int aluguel) {
        tabuleiro.set(index, nome);
        precos[index] = preco;
        alugueis[index] = aluguel;
    }
}