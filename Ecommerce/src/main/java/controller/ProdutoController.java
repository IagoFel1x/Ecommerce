package controller;

import java.util.List;
import java.util.Optional;
import model.Produto;
import model.ProdutoDAO;
import view.ProdutoView;

public class ProdutoController {

    private final ProdutoDAO produtoDAO;
    private final ProdutoView produtoView;

    public ProdutoController() {
        this(new ProdutoDAO(), new ProdutoView());
    }

    public ProdutoController(ProdutoDAO produtoDAO, ProdutoView produtoView) {
        this.produtoDAO = produtoDAO;
        this.produtoView = produtoView;
    }

    public void listarProdutos() {
        List<Produto> produtos = produtoDAO.buscarTodos();
        produtoView.exibirListaDeProdutos(produtos);
    }

    public void buscarProdutoPorId(String idDigitado) {
        int id;
        try {
            id = Integer.parseInt(idDigitado);
        } catch (NumberFormatException e) {
            produtoView.exibirMensagem("ID inválido: digite apenas números.");
            return;
        }

        Optional<Produto> produto = produtoDAO.buscarPorId(id);
        if (produto.isPresent()) {
            produtoView.exibirProduto(produto.get());
        } else {
            produtoView.exibirMensagem("Nenhum produto encontrado com o ID " + id + ".");
        }
    }
}
