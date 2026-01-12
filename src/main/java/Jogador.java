public class Jogador {
    private String nome;
    private String cor;
    private double saldo;
    private int posicao;

    public Jogador(String nome, String cor) {
        this.nome = nome;
        this.cor = cor;
        this.saldo = 1500;
        this.posicao = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getCor() {
        return cor;
    }

    public double getSaldo() {
        return saldo;
    }

    public void creditar(double valor) {
        this.saldo += valor;
    }

    public void debitar(double valor) {
        this.saldo -= valor;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    @Override
    public String toString() {
        return "Jogador [" + nome + "] - Saldo: " + saldo + " - Posição: " + posicao;
    }

    public boolean podePagar(double valor) {
        return saldo >= valor;
    }

    public void pagar(Jogador recebedor, double valor) {
        if (this.debitarComValidacao(valor)) {
            recebedor.creditar(valor);
        }
    }

    public boolean debitarComValidacao(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            return true;
        }
        // Logica de falencia ficaria aqui
        saldo -= valor;
        return true;
    }
}
