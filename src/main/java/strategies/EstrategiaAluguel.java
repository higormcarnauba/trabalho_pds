public class EstrategiaAluguel implements EstrategiaAoCair {
    @Override
    public void executar(Jogador jogador, Espaco espaco) {
        if (espaco.getDono() != null && !espaco.getDono().equals(jogador)) {
            System.out.println(
                    ">> Propriedade de " + espaco.getDono().getNome() + "! Pague aluguel de $" + espaco.getAluguel());
            jogador.pagar(espaco.getDono(), espaco.getAluguel());
        } else if (espaco.getDono() != null && espaco.getDono().equals(jogador)) {
            System.out.println(">> Você já é dono daqui.");
        }
    }
}
