public class EstrategiaPrisao implements EstrategiaAoCair {
    @Override
    public void executar(Jogador jogador, Espaco espaco) {
        System.out.println(">> Vá para a Prisão! (Você está apenas visitando por enquanto ou foi preso?)");
        // Simplified Logic: If space name is "Vá para a Prisão", send them. If it's
        // just "Prisão", just visiting.
        if (espaco.getNome().equalsIgnoreCase("Vá para a Prisão")) {
            System.out.println(">> Preso!");
            jogador.setPosicao(10); // Hardcoded prison position for now
        }
    }
}
