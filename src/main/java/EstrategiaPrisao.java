public class EstrategiaPrisao implements EstrategiaAoCair {
    @Override
    public void executar(Jogador jogador, Espaco espaco) {
        System.out.println(">> Vá para a Prisão! (Você está apenas visitando por enquanto ou foi preso?)");
        if (espaco.getNome().equalsIgnoreCase("Vá para a Prisão")) {
            System.out.println(">> Preso!");
            jogador.setPosicao(10);
        }
    }
}
