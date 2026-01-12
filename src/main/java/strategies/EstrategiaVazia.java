public class EstrategiaVazia implements EstrategiaAoCair {
    @Override
    public void executar(Jogador jogador, Espaco espaco) {
        System.out.println(">> Apenas passeando...");
    }
}
