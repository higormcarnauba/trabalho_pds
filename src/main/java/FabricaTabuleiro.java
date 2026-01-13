import java.util.ArrayList;
import java.util.List;

public class FabricaTabuleiro {

    public List<Espaco> criarTabuleiro() {
        List<Espaco> tabuleiro = new ArrayList<>();

        // 0 - Ponto de Partida
        tabuleiro.add(criarEspaco("Ponto de Partida", 0, 0, new EstrategiaVazia()));

        // 1 - Leblon
        tabuleiro.add(criarEspaco("Leblon", 100, 6, new EstrategiaPropriedade()));

        // 2 - Sorte ou Revés
        tabuleiro.add(criarEspaco("Sorte ou Revés", 0, 0, new EstrategiaSorte()));

        // 3 - Av. Presidente Vargas
        tabuleiro.add(criarEspaco("Av. Presidente Vargas", 60, 2, new EstrategiaPropriedade()));

        // 4 - Av. Nossa Sra. de Copacabana
        tabuleiro.add(criarEspaco("Av. Nossa Sra. de Copacabana", 60, 2, new EstrategiaPropriedade()));

        // 5 - Companhia Ferroviária
        tabuleiro.add(criarEspaco("Companhia Ferroviária", 200, 50, new EstrategiaPropriedade()));

        // 6 - Av. Brigadeiro Faria Lima
        tabuleiro.add(criarEspaco("Av. Brigadeiro Faria Lima", 240, 20, new EstrategiaPropriedade()));

        // 7 - Companhia de Viação
        tabuleiro.add(criarEspaco("Companhia de Viação", 200, 50, new EstrategiaPropriedade()));

        // 8 - Av. Rebouças
        tabuleiro.add(criarEspaco("Av. Rebouças", 220, 18, new EstrategiaPropriedade()));

        // 9 - Av. 9 de Julho
        tabuleiro.add(criarEspaco("Av. 9 de Julho", 220, 18, new EstrategiaPropriedade()));

        // 10 - Prisão (Visitante)
        tabuleiro.add(criarEspaco("Prisão (Visitante)", 0, 0, new EstrategiaPrisao()));

        // 11 - Av. Europa
        tabuleiro.add(criarEspaco("Av. Europa", 200, 16, new EstrategiaPropriedade()));

        // 12 - Sorte ou Revés
        tabuleiro.add(criarEspaco("Sorte ou Revés", 0, 0, new EstrategiaSorte()));

        // 13 - Rua Augusta
        tabuleiro.add(criarEspaco("Rua Augusta", 180, 14, new EstrategiaPropriedade()));

        // 14 - Av. Pacaembu
        tabuleiro.add(criarEspaco("Av. Pacaembu", 180, 14, new EstrategiaPropriedade()));

        // 15 - Companhia de Táxi
        tabuleiro.add(criarEspaco("Companhia de Táxi", 150, 40, new EstrategiaPropriedade()));

        // 16 - Sorte ou Revés
        tabuleiro.add(criarEspaco("Sorte ou Revés", 0, 0, new EstrategiaSorte()));

        // 17 - Interlagos
        tabuleiro.add(criarEspaco("Interlagos", 350, 35, new EstrategiaPropriedade()));

        // 18 - Lucros e Dividendos
        tabuleiro.add(criarEspaco("Lucros e Dividendos", 0, 0, new EstrategiaVazia())); // No specific behavior defined
                                                                                        // in legacy

        // 19 - Morumbi
        tabuleiro.add(criarEspaco("Morumbi", 400, 50, new EstrategiaPropriedade()));

        // 20 - Parada Livre
        tabuleiro.add(criarEspaco("Parada Livre", 0, 0, new EstrategiaVazia()));

        // 21 - Flamengo
        tabuleiro.add(criarEspaco("Flamengo", 120, 8, new EstrategiaPropriedade()));

        // 22 - Sorte ou Revés
        tabuleiro.add(criarEspaco("Sorte ou Revés", 0, 0, new EstrategiaSorte()));

        // 23 - Botafogo
        tabuleiro.add(criarEspaco("Botafogo", 100, 6, new EstrategiaPropriedade()));

        // 24 - Imposto de Renda
        tabuleiro.add(criarEspaco("Imposto de Renda", 0, 0, new EstrategiaImposto()));

        // 25 - Companhia de Navegação
        tabuleiro.add(criarEspaco("Companhia de Navegação", 150, 40, new EstrategiaPropriedade()));

        // 26 - Av. Brasil
        tabuleiro.add(criarEspaco("Av. Brasil", 160, 12, new EstrategiaPropriedade()));

        // 27 - Sorte ou Revés
        tabuleiro.add(criarEspaco("Sorte ou Revés", 0, 0, new EstrategiaSorte()));

        // 28 - Av. Paulista
        tabuleiro.add(criarEspaco("Av. Paulista", 140, 10, new EstrategiaPropriedade()));

        // 29 - Jardim Europa
        tabuleiro.add(criarEspaco("Jardim Europa", 140, 12, new EstrategiaPropriedade()));

        // 30 - Vá para a Prisão
        tabuleiro.add(criarEspaco("Vá para a Prisão", 0, 0, new EstrategiaPrisao()));

        // 31 - Copacabana
        tabuleiro.add(criarEspaco("Copacabana", 260, 22, new EstrategiaPropriedade()));

        // 32 - Companhia de Aviação
        tabuleiro.add(criarEspaco("Companhia de Aviação", 200, 50, new EstrategiaPropriedade()));

        // 33 - Av. Vieira Souto
        tabuleiro.add(criarEspaco("Av. Vieira Souto", 320, 28, new EstrategiaPropriedade()));

        // 34 - Av. Atlântica
        tabuleiro.add(criarEspaco("Av. Atlântica", 300, 26, new EstrategiaPropriedade()));

        // 35 - Companhia de Táxi Aéreo
        tabuleiro.add(criarEspaco("Companhia de Táxi Aéreo", 200, 50, new EstrategiaPropriedade()));

        // 36 - Ipanema
        tabuleiro.add(criarEspaco("Ipanema", 300, 26, new EstrategiaPropriedade()));

        // 37 - Sorte ou Revés
        tabuleiro.add(criarEspaco("Sorte ou Revés", 0, 0, new EstrategiaSorte()));

        // 38 - Jardim Paulista
        tabuleiro.add(criarEspaco("Jardim Paulista", 280, 24, new EstrategiaPropriedade()));

        // 39 - Brooklin
        tabuleiro.add(criarEspaco("Brooklin", 260, 22, new EstrategiaPropriedade()));

        return tabuleiro;
    }

    private Espaco criarEspaco(String nome, int preco, int aluguel, EstrategiaAoCair estrategia) {
        Espaco espaco = new Espaco(nome, preco, aluguel);
        espaco.setEstrategia(estrategia);
        return espaco;
    }
}
