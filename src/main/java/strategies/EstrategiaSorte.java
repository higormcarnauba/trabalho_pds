import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EstrategiaSorte implements EstrategiaAoCair {
    private List<String> cartas;

    public EstrategiaSorte() {
        cartas = new ArrayList<>();
        inicializarCartas();
    }

    private void inicializarCartas() {
        // Hardcoded for now, ideal would be to load from file or Factory
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
        cartas.add(
                "Sua casa será desapropriada para a construção de um metro e ganhará uma gorda indenização%receba%60");
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

    @Override
    public void executar(Jogador jogador, Espaco espaco) {
        System.out.println(">> Sorte ou Revés! Pressione ENTER para sacar uma carta...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        int indiceCarta = (int) (Math.random() * cartas.size());
        String cartaTexto = cartas.get(indiceCarta);

        String[] partes = cartaTexto.split("%");
        String descricao = partes[0];
        String acao = partes[1];
        int valor = Integer.parseInt(partes[2].trim());

        System.out.println(">> CARTA: " + descricao);

        processarAcao(jogador, acao, valor);
        System.out.println(">> Novo Saldo: " + jogador.getSaldo());
    }

    private void processarAcao(Jogador jogador, String acao, int valor) {
        if (acao.equalsIgnoreCase("pague")) {
            System.out.println(">> Você perdeu $" + valor);
            jogador.debitarComValidacao(valor);
        } else if (acao.equalsIgnoreCase("receba") || acao.equalsIgnoreCase("recebe")) {
            System.out.println(">> Você ganhou $" + valor);
            jogador.creditar(valor);
        } else if (acao.equalsIgnoreCase("vaiParaPrisao")) {
            System.out.println(">> Indo direto para a Prisão!");
            jogador.setPosicao(10);
        } else if (acao.equalsIgnoreCase("inicio")) {
            System.out.println(">> Avançando para o Ponto de Partida!");
            jogador.setPosicao(0);
            jogador.creditar(200);
        } else if (acao.equalsIgnoreCase("presente")) {
            System.out.println(">> É seu aniversário/casamento! Receba $" + valor);
            jogador.creditar(valor);
        } else {
            System.out.println(">> Ação '" + acao + "' ignorada/não implementada.");
        }
    }
}
