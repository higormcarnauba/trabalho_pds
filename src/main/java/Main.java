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

        ArrayList<Jogador> jogadores = new ArrayList<>();
        String[] cores = {"Branco", "Preto", "Azul", "Amarelo", "Verde", "Vermelho"};
        
        for (int i = 0; i < qtdJogadores; i++) {
            System.out.print("Nome do jogador " + (i + 1) + ": ");
            String nome = scanner.nextLine();
            jogadores.add(new Jogador(nome, cores[i % cores.length]));
        }

        boolean jogoRolando = true;
        int turno = 0;
        Dado dado = new Dado();

        while (jogoRolando) {
            Jogador jogadorAtual = jogadores.get(turno % jogadores.size());
            
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

    private static void gerenciarCasa(Jogador jogador, int pos, Scanner scanner) {
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

    static ArrayList<String> cartas = new ArrayList<>();

// Adicione este método na classe Main
    private static void sacarCarta(jogador jogadorAtual, Scanner scanner) {
        System.out.println(">> Sorte ou Revés! Pressione ENTER para sacar uma carta...");
        scanner.nextLine();

        // Sorteia uma carta da lista
        int indiceCarta = (int) (Math.random() * cartas.size());
        String cartaTexto = cartas.get(indiceCarta);
        
        // BAD PRACTICE: "String Parsing" manual. Dependemos da ordem exata: Descrição%Ação%Valor
        String[] partes = cartaTexto.split("%");
        String descricao = partes[0];
        String acao = partes[1];
        int valor = Integer.parseInt(partes[2].trim()); // .trim() para evitar erro de espaço

        System.out.println(">> CARTA: " + descricao);

        // BAD PRACTICE: Lógica baseada em "Magic Strings". Se errar uma letra no txt, o jogo ignora.
        if (acao.equalsIgnoreCase("pague")) {
            System.out.println(">> Você perdeu $" + valor);
            jogadorAtual.saldo -= valor;
        } else if (acao.equalsIgnoreCase("receba") || acao.equalsIgnoreCase("recebe")) {
            System.out.println(">> Você ganhou $" + valor);
            jogadorAtual.saldo += valor;
        } else if (acao.equalsIgnoreCase("vaiParaPrisao")) {
            System.out.println(">> Indo direto para a Prisão!");
            jogadorAtual.posicao = 10; // 10 é o índice da prisão no nosso array hardcoded
        } else if (acao.equalsIgnoreCase("inicio")) {
            System.out.println(">> Avançando para o Ponto de Partida!");
            jogadorAtual.posicao = 0;
            jogadorAtual.saldo += 200; // Regra do ponto de partida
        } else if (acao.equalsIgnoreCase("presente")) {
            // Em tese receberia de todos, mas vamos simplificar (ruim) e dar do banco
            System.out.println(">> É seu aniversário/casamento! Receba $" + valor);
            jogadorAtual.saldo += valor;
        } else {
            System.out.println(">> Ação '" + acao + "' não implementada nesta versão ruim.");
        }
        
        System.out.println(">> Novo Saldo: " + jogadorAtual.saldo);
    }

// Coloque isso NO FINAL do método inicializarTabuleiroComDadosReais()
    
    // Carregando cartas (Hardcoded baseado no arquivo cartasDeSorteOuReves.txt)
    cartas.add("Sua empresa foi multada por poluir demais%pague%200");
    cartas.add("O dia do seu casamento chegou, receba os presentes.%presente%50");
    cartas.add("Reformou sua casa%pague%50");
    cartas.add("Seu livro será publicado por uma grande editora%receba%50");
    cartas.add("Utilize este cartão para se livrar da prisão%seLivraDaprisao%0");
    cartas.add("Vá para a prisão%vaiParaPrisao%0");
    cartas.add("Vá até o início%inicio%0");
    cartas.add("Suas ações na bolsa de valores estão em alta%recebe%100");
    cartas.add("Você vai começar um curso de MBA e ganhou um bom desconto para pagamento a vista%pague%20");
    cartas.add("Férias com a familia pague%pague%20");
    cartas.add("Recebeu o prêmio de profissional do ano e ganhou um carro%receba%10");
    cartas.add("Jogue os dados novamente%dados%0");
    cartas.add("Sua empresa irá patrocinar uma expedição a Antártida%pague%50");
    cartas.add("Vendeu a parte de sua empresa para um investidor%receba%75");
    cartas.add("Apostou no cavalo azarão e ganhou%receba%100");
    cartas.add("A falta de chuva prejudicou a colheita%pague%45");
    cartas.add("Recebeu uma herança inesperada%receba%75");
    cartas.add("Seu filho decidiu fazer intercâmbio%pague%20");
    cartas.add("Sua casa será desapropriada para a construção de um metro e ganhará uma gorda indenização%receba%60");
    cartas.add("Venceu licitação para grande obra%receba%150");
    cartas.add("Seu iate afundou, mas você tinha seguro!%receba%25");
    cartas.add("Seus funcionários entraram em greve%pague%30");
    cartas.add("Comprou obra de arte falsificada%pague%22");
    cartas.add("Seu jatinho precisa de manutenção%pague%9");
    cartas.add("Renovou a frota de carros da sua empresa%pague%100");
    cartas.add("Ganhou sozinho na loteria%receba%80");
    cartas.add("Atualizou os computadores da sua empresa%pague%30");
    cartas.add("Um navio afundou com suas mercadorias (não tinha seguro)%pague%40");
    cartas.add("Produção de leite de suas fazendas ficou abaixo da expectativa%pague%60");
    cartas.add("Tirou primeiro lugar no torneio de golfe receba%receba%100");
    cartas.add("Sorte se tirou o número par da soma dos dados e revés caso contrário%sorteOuReves%100");


}