package principal;

import controller.ProdutoController;
import java.util.Scanner;

/**
 * Ponto de entrada do sistema. Exibe um menu simples no terminal.
 */
public class Principal {

    public static void main(String[] args) {
        ProdutoController controller = new ProdutoController();

        try (Scanner entrada = new Scanner(System.in)) {
            boolean executando = true;
            while (executando) {
                System.out.println("\n===== E-COMMERCE =====");
                System.out.println("1. Listar produtos");
                System.out.println("2. Buscar produto por ID");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");

                String opcao = entrada.nextLine().trim();
                switch (opcao) {
                    case "1":
                        controller.listarProdutos();
                        break;
                    case "2":
                        System.out.print("ID do produto: ");
                        String id = entrada.nextLine().trim();
                        controller.buscarProdutoPorId(id);
                        break;
                    case "0":
                        executando = false;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            }
        }
        System.out.println("Sistema encerrado.");
    }
}
