import java.util.Scanner;

public class EstrategiaPropriedade implements EstrategiaAoCair {
    @Override
    public void executar(Jogador jogador, Espaco espaco) {
        Jogo jogo = Jogo.getInstancia();
        Jogador dono = espaco.getDono();
        int preco = espaco.getPreco();
        int aluguel = espaco.getAluguel();

        if (dono == null) {
            jogo.notificar(">> Propriedade sem dono! Preço: $" + preco);
            if (jogador.getSaldo() >= preco) {
                // Input interaction still happens here for now, could be refactored to Command
                // later
                System.out.print(">> Deseja comprar " + espaco.getNome() + "? (s/n): ");
                Scanner scanner = new Scanner(System.in);
                String resp = scanner.nextLine();
                if (resp.equalsIgnoreCase("s")) {
                    jogador.debitarComValidacao(preco);
                    espaco.setDono(jogador);
                    jogo.notificar(">> Compra realizada com sucesso!");
                }
            } else {
                jogo.notificar(">> Saldo insuficiente para comprar.");
            }
        } else if (!dono.equals(jogador)) {
            jogo.notificar(">> Propriedade de " + dono.getNome() + "! Pague aluguel de $" + aluguel);
            jogador.debitarComValidacao(aluguel);
            // Credit the owner? The original code didn't seem to credit the owner
            // explicitly in the snippet I saw,
            // but normally Monopoly does. I'll stick to legacy behavior unless I see
            // 'creditar' in original.
            // Original snippet: just debitar.
        } else {
            jogo.notificar(">> Você já é dono daqui.");
        }
    }
}
