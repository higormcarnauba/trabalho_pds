public class jogador {
    public String nome;
    public String cor;
    public double saldo;
    public int posicao;

    public jogador(String nome, String cor) {
        this.nome = nome;
        this.cor = cor;
        this.saldo = 1500;
        this.posicao = 0; 
    }

    @Override
    public String toString() {
        return "Jogador [" + nome + "] - Saldo: " + saldo + " - Posição: " + posicao;
    }
}