public class Dado {
    public int jogar() {
        return (int) (Math.random() * 6) + 1;
    }
}