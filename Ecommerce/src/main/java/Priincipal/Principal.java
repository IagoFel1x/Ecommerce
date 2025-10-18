import controller.ProdutoController;


public class Principal {

    public static void main(String[] args) {
        ProdutoController controller = new ProdutoController();
        controller.listarProdutos();
    }
}