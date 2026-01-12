public class EstrategiaPropriedade implements EstrategiaAoCair {
    private EstrategiaCompra compra;
    private EstrategiaAluguel aluguel;

    public EstrategiaPropriedade() {
        this.compra = new EstrategiaCompra();
        this.aluguel = new EstrategiaAluguel();
    }

    @Override
    public void executar(Jogador jogador, Espaco espaco) {
        // Decide which strategy to delegate to based on ownership
        if (espaco.getDono() == null) {
            compra.executar(jogador, espaco);
        } else {
            aluguel.executar(jogador, espaco);
        }
    }
}
