import java.util.ArrayList;
import java.util.List;

public class Jogo {
    private static Jogo instancia;
    private List<Jogador> jogadores;
    private List<Espaco> tabuleiro;
    private int turno;

    private Jogo() {
        this.jogadores = new ArrayList<>();
        this.tabuleiro = new ArrayList<>();
        this.turno = 0;
    }

    public static synchronized Jogo getInstancia() {
        if (instancia == null) {
            instancia = new Jogo();
        }
        return instancia;
    }

    public void adicionarJogador(Jogador jogador) {
        this.jogadores.add(jogador);
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public Jogador getJogadorAtual() {
        if (jogadores.isEmpty())
            return null;
        return jogadores.get(turno % jogadores.size());
    }

    public void proximoTurno() {
        turno++;
    }

    public void setTabuleiro(List<Espaco> tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public List<Espaco> getTabuleiro() {
        return tabuleiro;
    }
}
