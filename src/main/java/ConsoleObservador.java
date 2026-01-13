public class ConsoleObservador implements Observador {
    @Override
    public void atualizar(String mensagem) {
        System.out.println(mensagem);
    }
}
