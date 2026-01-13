import java.util.ArrayList;
import java.util.List;

public class Jogo {
    private static Jogo instancia;
    private List<Jogador> jogadores;
    private List<Espaco> tabuleiro;
    private IteradorJogadores iterador;
    private List<Observador> observadores;
    private boolean jogoRolando;

    private Jogo() {
        this.jogadores = new ArrayList<>();
        this.tabuleiro = new ArrayList<>();
        this.observadores = new ArrayList<>();
        this.jogoRolando = true;
    }

    public boolean isJogoRolando() {
        return jogoRolando;
    }

    public void finalizarJogo() {
        this.jogoRolando = false;
    }

    public static synchronized Jogo getInstancia() {
        if (instancia == null) {
            instancia = new Jogo();
        }
        return instancia;
    }

    public void adicionarObservador(Observador obs) {
        this.observadores.add(obs);
    }

    public void notificar(String mensagem) {
        for (Observador obs : observadores) {
            obs.atualizar(mensagem);
        }
    }

    public void adicionarJogador(Jogador jogador) {
        this.jogadores.add(jogador);
        // Reinicia o iterador quando novos jogadores entram (configuração inicial)
        this.iterador = new IteradorJogadores(this.jogadores);
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public Jogador getJogadorAtual() {
        if (iterador == null)
            return null;
        return iterador.atual();
    }

    public void proximoTurno() {
        if (iterador != null) {
            iterador.proximo();
        }
    }

    public void setTabuleiro(List<Espaco> tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public List<Espaco> getTabuleiro() {
        return tabuleiro;
    }

    // Inner class for Iterator
    private class IteradorJogadores implements Iterador<Jogador> {
        private List<Jogador> lista;
        private int indiceAtual;

        public IteradorJogadores(List<Jogador> lista) {
            this.lista = lista;
            this.indiceAtual = 0;
        }

        @Override
        public Jogador proximo() {
            if (lista.isEmpty())
                return null;
            indiceAtual = (indiceAtual + 1) % lista.size();
            return lista.get(indiceAtual);
        }

        @Override
        public Jogador atual() {
            if (lista.isEmpty())
                return null;
            return lista.get(indiceAtual);
        }
    }
}
