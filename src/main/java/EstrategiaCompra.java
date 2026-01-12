import java.util.Scanner;

public class EstrategiaCompra implements EstrategiaAoCair {
    @Override
    public void executar(Jogador jogador, Espaco espaco) {
        if (espaco.getDono() == null) {
            System.out.println(">> Propriedade sem dono! Preço: $" + espaco.getPreco());
            if (jogador.podePagar(espaco.getPreco())) {
                System.out.print(">> Deseja comprar " + espaco.getNome() + "? (s/n): ");
                Scanner scanner = new Scanner(System.in);
                String resp = scanner.nextLine();
                if (resp.equalsIgnoreCase("s")) {
                    jogador.debitarComValidacao(espaco.getPreco());
                    espaco.setDono(jogador);
                    System.out.println(">> Compra realizada com sucesso!");
                }
            } else {
                System.out.println(">> Saldo insuficiente para comprar.");
            }
        } else {
            System.out.println(">> Esta propriedade já tem dono.");
        }
    }
}
