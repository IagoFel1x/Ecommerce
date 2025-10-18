package controller; 

import model.Produto; 
import model.ProdutoDAO; 
import view.ProdutoView; 
import java.util.List;


public class ProdutoController {
    private ProdutoDAO produtoDAO;
    private ProdutoView produtoView;

    public ProdutoController() {
        this.produtoDAO = new ProdutoDAO();
        this.produtoView = new ProdutoView();
    }

    public void listarProdutos() {
        List<Produto> produtos = produtoDAO.buscarTodos();
        produtoView.exibirListaDeProdutos(produtos);
    }
}