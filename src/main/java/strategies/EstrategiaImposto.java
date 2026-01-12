public class EstrategiaImposto implements EstrategiaAoCair {
    @Override
    public void executar(Jogador jogador, Espaco espaco) {
        System.out.println(">> Imposto de Renda! Você perdeu $200.");
        jogador.debitarComValidacao(200);
    }
}
