public class ComandoSair implements Comando {
    @Override
    public void executar() {
        Jogo.getInstancia().finalizarJogo();
        Jogo.getInstancia().notificar(">> Jogo encerrado pelo jogador.");
    }
}
