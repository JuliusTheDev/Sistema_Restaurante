import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RestauranteMatriz restaurante = new RestauranteMatriz();

        int opcao;
        do {
            System.out.println("Menu:");
            System.out.println("1- Cadastrar prato de um andar");
            System.out.println("2- Visualizar prato de um andar");
            System.out.println("3- Visualizar todos os pratos");
            System.out.println("4- Quantidade de pratos vendidos de um andar");
            System.out.println("5- Mostrar os dados do prato mais vendido de um andar");
            System.out.println("0- Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarPrato(restaurante, scanner);
                    break;
                case 2:
                    visualizarPrato(restaurante, scanner);
                    break;
                case 3:
                    visualizarTodosOsPratos(restaurante);
                    break;
                case 4:
                    quantidadePratosVendidos(restaurante, scanner);
                    break;
                case 5:
                    mostrarPratoMaisVendido(restaurante, scanner);
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
                    break;
            }
        } while (opcao != 0);
    }

    private static void cadastrarPrato(RestauranteMatriz restaurante, Scanner scanner) {
        System.out.print("Informe o andar (0 a " + (restaurante.getNumAndares() - 1) + "): ");
        int andar = scanner.nextInt();
        System.out.print("Informe o prato (0 a " + (restaurante.getNumPratos() - 1) + "): ");
        int prato = scanner.nextInt();

        System.out.print("Nome do prato: ");
        String nomePrato = scanner.next();
        System.out.print("Preço do prato: ");
        double preco = scanner.nextDouble();
        System.out.print("Nome do chefe: ");
        String nomeChefe = scanner.next();
        System.out.print("Quantidade Vendida: ");
        int quantidadeVendida = scanner.nextInt();

        restaurante.setPrato(andar, prato, new Prato(nomePrato, preco, nomeChefe, quantidadeVendida));
        System.out.println("Prato cadastrado com sucesso.");
    }

    private static void visualizarPrato(RestauranteMatriz restaurante, Scanner scanner) {
        System.out.print("Informe o andar (0 a " + (restaurante.getNumAndares() - 1) + "): ");
        int andar = scanner.nextInt();
        System.out.print("Informe o prato (0 a " + (restaurante.getNumPratos() - 1) + "): ");
        int prato = scanner.nextInt();

        Prato pratoSelecionado = restaurante.getPrato(andar, prato);
        System.out.println("Prato no andar " + andar + " e prato " + prato + ":");
        System.out.println(pratoSelecionado);
    }

    private static void visualizarTodosOsPratos(RestauranteMatriz restaurante) {
        for (int i = 0; i < restaurante.getNumAndares(); i++) {
            for (int j = 0; j < restaurante.getNumPratos(); j++) {
                Prato prato = restaurante.getPrato(i, j);
                System.out.println("Andar " + i + ", Prato " + j + ":");
                System.out.println(prato);
                System.out.println("--------------------------");
            }
        }
    }

    private static void quantidadePratosVendidos(RestauranteMatriz restaurante, Scanner scanner) {
        System.out.print("Informe o andar (0 a " + (restaurante.getNumAndares() - 1) + "): ");
        int andar = scanner.nextInt();
        int totalVendidos = 0;

        for (int i = 0; i < restaurante.getNumPratos(); i++) {
            Prato prato = restaurante.getPrato(andar, i);
            totalVendidos += prato.getQuantidadeVendida();
        }

        System.out.println("Total de pratos vendidos no andar " + andar + ": " + totalVendidos);
    }

    private static void mostrarPratoMaisVendido(RestauranteMatriz restaurante, Scanner scanner) {
        System.out.print("Informe o andar (0 a " + (restaurante.getNumAndares() - 1) + "): ");
        int andar = scanner.nextInt();
        int indicePratoMaisVendido = -1;
        int quantidadeMaisVendida = 0;

        for (int i = 0; i < restaurante.getNumPratos(); i++) {
            Prato prato = restaurante.getPrato(andar, i);
            if (prato.getQuantidadeVendida() > quantidadeMaisVendida) {
                quantidadeMaisVendida = prato.getQuantidadeVendida();
                indicePratoMaisVendido = i;
            }
        }

        if (indicePratoMaisVendido != -1) {
            Prato pratoMaisVendido = restaurante.getPrato(andar, indicePratoMaisVendido);
            System.out.println("Prato mais vendido no andar " + andar + ":");
            System.out.println(pratoMaisVendido);
        } else {
            System.out.println("Nenhum prato vendido neste andar.");
        }
    }
}
