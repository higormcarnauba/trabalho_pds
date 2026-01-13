public class ComandoJogar implements Comando {
    private Dado dado;

    public ComandoJogar() {
        this.dado = new Dado();
    }

    @Override
    public void executar() {
        Jogo jogo = Jogo.getInstancia();
        Jogador jogadorAtual = jogo.getJogadorAtual();

        int valorDado = dado.jogar() + dado.jogar();
        jogo.notificar(">> Dados: " + valorDado);

        int novaPosicao = (jogadorAtual.getPosicao() + valorDado) % 40;

        if (novaPosicao < jogadorAtual.getPosicao()) {
            jogo.notificar(">> Passou pelo Início! Ganhou $200.");
            jogadorAtual.creditar(200);
        }
        jogadorAtual.setPosicao(novaPosicao);

        Espaco novoEspaco = jogo.getTabuleiro().get(novaPosicao);
        jogo.notificar(">> Caiu em: " + novoEspaco.getNome() + " (" + novaPosicao + ")");

        // DELEGATION to Strategy Pattern logic inside Espaco
        novoEspaco.cair(jogadorAtual);

        if (jogadorAtual.getSaldo() < 0) {
            jogo.notificar("XXX " + jogadorAtual.getNome() + " FALIU! Fim de jogo. XXX");
            jogo.finalizarJogo();
        }

        // Iterator Pattern: Pass turn automatically after checking game over
        // But if game over, maybe shouldn't?
        // Let's keep it simply here.
        if (jogo.isJogoRolando()) // Ensure we check if game is still running
            jogo.proximoTurno();
    }
}
