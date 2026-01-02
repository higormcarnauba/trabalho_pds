import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<String> tabuleiro = new ArrayList<>();
        
        tabuleiro.add("Ponto de Partida");          // 0
        tabuleiro.add("Leblon");                    // 1
        tabuleiro.add("Sorte ou Revés");            // 2
        tabuleiro.add("Av. Presidente Vargas");     // 3
        tabuleiro.add("Av. Nossa Sra. de Copacabana"); // 4
        tabuleiro.add("Companhia Ferroviária");     // 5
        tabuleiro.add("Av. Brigadeiro Faria Lima"); // 6
        tabuleiro.add("Companhia de Viação");       // 7
        tabuleiro.add("Av. Rebouças");              // 8
        tabuleiro.add("Av. 9 de Julho");            // 9
        tabuleiro.add("Prisão (Visitante)");        // 10
        tabuleiro.add("Av. Europa");                // 11
        tabuleiro.add("Sorte ou Revés");            // 12
        tabuleiro.add("Rua Augusta");               // 13
        tabuleiro.add("Av. Pacaembu");              // 14
        tabuleiro.add("Companhia de Viação");       // 15
        tabuleiro.add("Sorte ou Revés");            // 16
        tabuleiro.add("Interlagos");                // 17
        tabuleiro.add("Lucros e Dividendos");       // 18
        tabuleiro.add("Av. Morumbi");               // 19
        tabuleiro.add("Parada Livre");              // 20
        tabuleiro.add("Av. Higienópolis");          // 21
        tabuleiro.add("Av. Henrique Schaumann");    // 22
        tabuleiro.add("Sorte ou Revés");            // 23
        tabuleiro.add("Av. Ibirapuera");            // 24
        tabuleiro.add("Companhia de Viação");       // 25
        tabuleiro.add("Av. Paulista");              // 26
        tabuleiro.add("Av. Brigadeiro Luís Antônio"); // 27
        tabuleiro.add("Companhia de Táxi Aéreo");   // 28
        tabuleiro.add("Rua da Consolação");         // 29
        tabuleiro.add("Vá para a Prisão");          // 30
        tabuleiro.add("Av. Ipiranga");              // 31
        tabuleiro.add("Av. São João");              // 32
        tabuleiro.add("Sorte ou Revés");            // 33
        tabuleiro.add("Rua Treze de Maio");         // 34
        tabuleiro.add("Av. Brigadeiro Faria Lima"); // 35 
        tabuleiro.add("Companhia de Navegação");    // 36
        tabuleiro.add("Av. Santo Amaro");           // 37
        tabuleiro.add("Sorte ou Revés");            // 38
        tabuleiro.add("Av. Magalhães de Almeida");  // 39

        System.out.println("O jogo foi iniciado.");
        System.out.println("Tabuleiro carregado com " + tabuleiro.size() + " posições.");
        
        System.out.print("Digite o número de jogadores (2-6): ");
        if(scanner.hasNextInt()) {
            int numJogadores = scanner.nextInt();
            System.out.println("Iniciando jogo para " + numJogadores + " jogadores...");
        }
        
        scanner.close();
    }
}