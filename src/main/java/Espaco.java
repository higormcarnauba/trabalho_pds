public class Espaco {
    private String nome;
    private int preco;
    private int aluguel;
    private Jogador dono;
    private EstrategiaAoCair estrategia;

    public Espaco(String nome) {
        this.nome = nome;
        this.preco = 0;
        this.aluguel = 0;
        this.dono = null;
        this.estrategia = new EstrategiaVazia();
    }

    public Espaco(String nome, int preco, int aluguel) {
        this.nome = nome;
        this.preco = preco;
        this.aluguel = aluguel;
        this.dono = null;
        this.estrategia = new EstrategiaPropriedade();
    }

    public void setEstrategia(EstrategiaAoCair estrategia) {
        this.estrategia = estrategia;
    }

    public void cair(Jogador jogador) {
        if (estrategia != null) {
            estrategia.executar(jogador, this);
        }
    }

    public String getNome() {
        return nome;
    }

    public int getPreco() {
        return preco;
    }

    public int getAluguel() {
        return aluguel;
    }

    public Jogador getDono() {
        return dono;
    }

    public void setDono(Jogador dono) {
        this.dono = dono;
    }

    @Override
    public String toString() {
        return nome + (dono != null ? " [" + dono.getNome() + "]" : "");
    }
}
