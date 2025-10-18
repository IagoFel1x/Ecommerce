package view;

import model.Produto; 
import java.util.List;


public class ProdutoView {

    public void exibirListaDeProdutos(List<Produto> produtos) {
        System.out.println("--- LISTA DE PRODUTOS CADASTRADOS ---");
        
        if (produtos == null || produtos.isEmpty()) {
            System.out.println("\nNenhum produto foi encontrado no banco de dados.");
        } else {
            for (Produto p : produtos) {
                System.out.println(p);
            }
        }
        
        System.out.println("-------------------------");
        System.out.println("Fim da listagem.");
    }
}