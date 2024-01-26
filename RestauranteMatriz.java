

public class RestauranteMatriz {
    private static final int NUM_ANDARES = 5;
    private static final int NUM_PRATOS = 4;

    private Prato[][] matrizDePratos;

    public RestauranteMatriz() {
        matrizDePratos = new Prato[NUM_ANDARES][NUM_PRATOS];
        inicializarMatriz();
    }

    private void inicializarMatriz() {
        for (int i = 0; i < NUM_ANDARES; i++) {
            for (int j = 0; j < NUM_PRATOS; j++) {
                matrizDePratos[i][j] = new Prato();
            }
        }
    }

    public Prato getPrato(int andar, int prato) {
        return matrizDePratos[andar][prato];
    }

    public void setPrato(int andar, int prato, Prato novoPrato) {
        matrizDePratos[andar][prato] = novoPrato;
    }

    public int getNumAndares() {
        return NUM_ANDARES;
    }

    public int getNumPratos() {
        return NUM_PRATOS;
    }
}
